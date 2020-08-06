package com.demo.starplan.mediaplay;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.bean.VideoBean;
import com.demo.starplan.database.HistoryPlay;
import com.demo.starplan.mvp.Callback;
import com.google.gson.Gson;

import org.litepal.LitePal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MediaModel implements MediaContract.Model {

    private VideoBean videoBean;
    private List<VideoBean.DataBean.ListBean> videoBeanList;
    private List<HistoryPlay> historyPlayList;

    String responseData;

    //获取系统日期和时间
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date(System.currentTimeMillis());

    @Override
    public void sendRequestWithOkHttp(final Callback callback) {
        //开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://gitee.com/qfxl/star_project/raw/master/video.json")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    responseData = response.body().string();
                    videoBean = new Gson().fromJson(responseData, VideoBean.class);
                    init();
                    callback.onSuccess(videoBeanList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void init() {
        videoBeanList = new ArrayList<VideoBean.DataBean.ListBean>();
        Babybus bbb = new Babybus();
        for (VideoBean.DataBean.ListBean VDB : videoBean.getData().getList()){
            videoBeanList.add(VDB);
        }

    }

    @Override
    public void addVideoToHistory(VideoBean.DataBean.ListBean data ) {
        historyPlayList = LitePal.where("name = ?", data.getName())
                .find(HistoryPlay.class);
//                        historyPlayList = LitePal.findAll(HistoryPlay.class);
        if (historyPlayList.size() == 0) {
            HistoryPlay historyPlay = new HistoryPlay();
            historyPlay.setName(data.getName());
            historyPlay.setUrlImg(data.getImg());
            historyPlay.setUrlVideo(data.getVideoUrl());
            historyPlay.setDate(simpleDateFormat.format(date));
            historyPlay.save();
        }
    }


}
