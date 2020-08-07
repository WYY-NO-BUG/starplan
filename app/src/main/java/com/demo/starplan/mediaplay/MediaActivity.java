package com.demo.starplan.mediaplay;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.starplan.R;
import com.demo.starplan.bean.VideoBean;
import com.demo.starplan.database.HistoryPlay;
import com.demo.starplan.mvp.BaseMvpActivity;

import org.litepal.LitePal;

import java.util.List;

public class MediaActivity extends BaseMvpActivity<MediaPresenter> implements MediaContract.View, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ImageView back, control;
    private RelativeLayout relativeLayout;
    private LinearLayout progress;
    private ImageView placeholder;
    private TextView time_move, time_all, title;
    private RecyclerView recyclerView;

    //获取历史时间的点击位置
    private String positionOfHistory;

    //进度条
    private SeekBar seekBar;

    //使用textureview
    private TextureView mTextureViewPlayVideo;
    private Surface mSurface;
    private MediaPlayer mMediaPlayer;

    //声明线程，seekbar时会开启此线程
    private Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        /**
         * 读取参数
         * 检查从历史记录中传过来的参数
         * 如果参数为空，不是从历史记录页面过来
         * 否则在后面通过参数进行播放的选择*/
        Intent intent = getIntent();
        positionOfHistory = intent.getStringExtra("uri");

        init();

        /**
         * 检查手机的SD卡写入权限
         * 可能暂时没用，先声明
         * 第一次没有申请权限时，进行申请
         * 每一次打开app检查一次权限
         * */
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            requestData();
            mTextureViewPlayVideo.setSurfaceTextureListener(mSurfaceTextureListener);
        }

        /**
         * 设置三个控件功能
         * */
        back.setOnClickListener(this);
        control.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);

    }

    /**
     * 声明一个surfacetextureview接口
     * <p>
     * 重写三个函数
     * 在Availvable中我们需要为mediaplayer设置一个surface
     * 之后的播放都在该surface
     * <p>
     * 视频结束后，需要对mediaplaer资源释放
     */
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            mSurface = new Surface(surface);
            mMediaPlayer.setSurface(mSurface);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            mSurface = null;
            mMediaPlayer.stop();
            mMediaPlayer.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    };

    /**
     * 通过presenter进行数据请求
     */
    @Override
    public void requestData() {
        mPresenter.getMessage();
    }

    /**
     * 设置一个recycleview展示右边选择界面
     * <p>
     * 视频播放屏幕设置
     * 判断是否是历史浏览
     * <p>
     * adapter设置点击事件
     * 对视频进行切换
     */
    @Override
    public void showView(final List<VideoBean.DataBean.ListBean> videoBeanList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView = findViewById(R.id.recycler_right_choose);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MediaActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                MediaAdapter adapter = new MediaAdapter(videoBeanList, MediaActivity.this);
                recyclerView.setAdapter(adapter);

                /*
                 * 判断是否有从历史浏览传过来的参数
                 * */
                if (positionOfHistory != null) {
                    List<HistoryPlay> historyVideo = LitePal.where("name = ? ", positionOfHistory).find(HistoryPlay.class);
                    title.setText(historyVideo.get(0).getName());
                    setVideo(historyVideo.get(0).getUrlVideo());
                } else {
                    title.setText(videoBeanList.get(0).getName());
                    setVideo(videoBeanList.get(0).getVideoUrl());
                    mPresenter.addHistory(videoBeanList.get(0));
                }

                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(final int position) {
                        setVideo(videoBeanList.get(position).getVideoUrl());
                        title.setText(videoBeanList.get(position).getName());
                        mPresenter.addHistory(videoBeanList.get(position));
                    }
                });

            }
        });
    }

    //初始化控件
    public void init() {
        mPresenter = new MediaPresenter(MediaActivity.this);
        mMediaPlayer = new MediaPlayer();
        mTextureViewPlayVideo = findViewById(R.id.texture_view_video);
        seekBar = findViewById(R.id.seekBar_video);
        back = findViewById(R.id.media_back);
        control = findViewById(R.id.btn_control);
        relativeLayout = findViewById(R.id.video_layout);
        progress = findViewById(R.id.progress_video);

        placeholder = findViewById(R.id.placeholder);
        Glide.with(this)
                .load(R.drawable.place)
                .into(placeholder);

        time_move = findViewById(R.id.time_move);
        time_all = findViewById(R.id.time_all);

        title = findViewById(R.id.media_title_text);
    }


    /**
     * 播放逻辑
     * 每一次播放视频需要进行调用
     * <p>
     * 需要设置OnPrepared监听，在里面开启SeekBar线程
     * <p>
     * 设置视频结束监听
     * 视频结束后，control按钮变为暂停
     */
    private void setVideo(String url) {
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.prepareAsync();

            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                    control.setImageResource(R.drawable.replaceable_drawable_video_player_pause);
                    thread = new Thread(new SeekBarThread());
                    thread.start();
                }
            });

            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    control.setImageResource(R.drawable.replaceable_drawable_video_player_play);
                }
            });

            if (mMediaPlayer.isPlaying()) {
                placeholder.setVisibility(View.GONE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 重写了点击事件
     * <p>
     * 点击返回时，结束activity
     * 点击控制键，可以调整暂停和播放
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.media_back:
                finish();
                break;

            case R.id.btn_control:
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    control.setImageResource(R.drawable.replaceable_drawable_video_player_play);
                } else {
                    mMediaPlayer.start();
                    control.setImageResource(R.drawable.replaceable_drawable_video_player_pause);
                }
                break;

        }
    }


    /**
     * 继承了SeekBar监听接口
     * <p>
     * 重写接听接口的三种方法
     * <p>
     * 在停止拖动进度条时
     * 将视频进度通过一个计算调整到当前位置
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int dest = seekBar.getProgress();
        int mMax = mMediaPlayer.getDuration();
        int sMax = seekBar.getMax();
        mMediaPlayer.seekTo(mMax * dest / sMax);
    }

    /**
     * SeekBar的线程
     * 通过开启一个子线程
     * 使进度条动态变化
     * <p>
     * 获取到视频的当前进度
     * 通过获取进度条总长度，视屏总长度
     * 计算出进度条当前进度
     * 设置为没一秒执行一次
     * <p>
     * 获取到开始时间和当前时间
     */
    class SeekBarThread implements Runnable {
        @Override
        public void run() {
            while (mMediaPlayer.isPlaying()) {
                int position = mMediaPlayer.getCurrentPosition();
                int mMax = mMediaPlayer.getDuration();
                int sMax = seekBar.getMax();
                time_all.setText(String.valueOf(mMax / 60000) + ":" + String.valueOf(mMax % 60000 / 1000));
                seekBar.setProgress(position * sMax / mMax);
                String time = String.valueOf(position / 60000) + ":" + String.valueOf(position % 60000 / 1000);
                time_move.setText(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 申请权限
     * 拒绝或接受后回调
     * 接受就调用requestData（）开始获取数据
     * 否则突出activity
     */
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.
                        PERMISSION_GRANTED) {
                    requestData();
                } else {
                    Toast.makeText(MediaActivity.this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }


    /**
     * 通过activity的生命周期
     * <p>
     * onStop的时候视频暂停，再次回来时onRestart（）开始播放
     * <p>
     * 当activity销毁时，停止视频
     * 释放视频资源，
     */
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        if (!mMediaPlayer.isPlaying()) {
//            mMediaPlayer.start();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mMediaPlayer.isPlaying()) {
//            mMediaPlayer.pause();
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
        }
    }
}
