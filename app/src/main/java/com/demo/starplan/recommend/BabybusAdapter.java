package com.demo.starplan.recommend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.demo.starplan.R;
import com.demo.starplan.bean.Babybus;
import com.demo.starplan.database.HistoryPlay;
import com.demo.starplan.mediaplay.MediaActivity;

import org.litepal.LitePal;

import java.util.List;


/**
 *推荐页和历史浏览的recycleview的适配器使用同一个
 *
 * 通过传入参数的不同选择布局
 *
 * 达到五种不同的不效果
 * 实现recycleview的多种复杂布局
 *
 * */

public class BabybusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private List<Babybus> mBabybusList;

    private Context mContext;
    private LayoutInflater inflater;

    private List<HistoryPlay> historyPlayList;
    private Babybus deleteChoose;

    //用于向下传递的位置参数
    private int position;

    //设置图片圆角
    private RoundedCorners roundedCorners = new RoundedCorners(30);
    private RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

    public BabybusAdapter(List<Babybus> mBabybusList, Context context) {
        this.mBabybusList = mBabybusList;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemViewType(int position) {
        return mBabybusList.get(position).type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Babybus.TypeOne:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.item_show, parent, false));
                break;
            case Babybus.TypeTwo:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.item_show_two, parent, false));
                break;
            case Babybus.TypeThree:
                viewHolder = new ViewHolderThree(inflater.inflate(R.layout.item_title_small, parent, false));
                break;
            case Babybus.TypeFour:
                viewHolder = new ViewHolderFour(inflater.inflate(R.layout.item_choose_one, parent, false));
                break;
            case Babybus.TypeFive:
                viewHolder = new ViewHolderFive(inflater.inflate(R.layout.item_choose_two, parent, false));
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final Babybus bbb = mBabybusList.get(position);
        this.position = position;
        switch (getItemViewType(position)) {
            case Babybus.TypeOne:
                Glide.with(mContext)
                        .load(bbb.getUrlImgRec(0))
                        .into(((ViewHolderOne) holder).icon1);
                Glide.with(mContext)
                        .load(bbb.getUrlImgRec(1))
                        .into(((ViewHolderOne) holder).icon2);
                Glide.with(mContext)
                        .load(bbb.getUrlImgRec(2))
                        .into(((ViewHolderOne) holder).icon3);
                ((ViewHolderOne) holder).title.setText(bbb.getName());
                ((ViewHolderOne) holder).icon1.setOnClickListener(this);

                ((ViewHolderOne) holder).icon2.setOnClickListener(this);

                ((ViewHolderOne) holder).icon3.setOnClickListener(this);
                break;

            case Babybus.TypeTwo:
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .apply(new RequestOptions().placeholder(R.drawable.photo_22))
                        .into(((ViewHolderTwo) holder).babybusImage);
                ((ViewHolderTwo) holder).babybusTitle.setText(bbb.getName());
                ((ViewHolderTwo) holder).babybusView.setOnClickListener(this);

                break;

            case Babybus.TypeThree:
                ((ViewHolderThree) holder).babybusTitle.setText(bbb.getName());
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderThree) holder).babybusImage);
                break;

            case Babybus.TypeFour:
                ((ViewHolderFour) holder).babybusTitle.setText(bbb.getName());
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .apply(new RequestOptions().placeholder(R.drawable.photo_42))
                        .apply(options)
                        .into(((ViewHolderFour) holder).babybusImage);
                ((ViewHolderFour) holder).babybusView.setOnClickListener(this);
                break;

            case Babybus.TypeFive:
                if (bbb.getTitle() != null) {
                    ((ViewHolderFive) holder).babybusTitle.setText(bbb.getTitle());
                }
                if (bbb.getName() != null) {
                    ((ViewHolderFive) holder).babaybusName.setText(bbb.getName());
                }
                ((ViewHolderFive) holder).date.setText(bbb.getDate());
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .apply(options)
                        .into(((ViewHolderFive) holder).babybusImage);


                //向播放页传入参数
                //从而判断是哪一个视频
                ((ViewHolderFive) holder).babybusView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, MediaActivity.class);
                        intent.putExtra("uri",bbb.getName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                ((ViewHolderFive) holder).delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteChoose = mBabybusList.get(holder.getAdapterPosition());
                        LitePal.deleteAll(HistoryPlay.class, "urlImg = ? or name = ?",
                                deleteChoose.getUrlImg(), deleteChoose.getName());
                        removeData(position);
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mBabybusList.size();
    }


    /**
     * 所有的点击时间都会跳转到播放页
     *
     * delete和历史播放页另设
     *
     * */
    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.delete) {
            Intent intent = new Intent(mContext, MediaActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }

    }


    //第一种布局
    public static class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView icon1, icon2, icon3;
        private View babybusView;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

            babybusView = itemView;
            title = (TextView) itemView.findViewById(R.id.tv_show1);
            icon1 = itemView.findViewById(R.id.iv_show1);
            icon2 = itemView.findViewById(R.id.iv_show2);
            icon3 = itemView.findViewById(R.id.iv_show3);
        }
    }

    //第二种布局
    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        private ImageView babybusImage;
        private TextView babybusTitle;
        private View babybusView;

        public ViewHolderTwo(View view) {
            super(view);

            babybusView = view;
            babybusImage = (ImageView) view.findViewById(R.id.iv_show5);
            babybusTitle = (TextView) view.findViewById(R.id.tv_show);
        }
    }

    //第三种布局
    static class ViewHolderThree extends RecyclerView.ViewHolder {
        private ImageView babybusImage;
        private TextView babybusTitle;
        private View babybusView;

        public ViewHolderThree(View view) {
            super(view);
            babybusView = view;
            babybusImage = (ImageView) view.findViewById(R.id.iv_small_title);
            babybusTitle = (TextView) view.findViewById(R.id.tv_small_title);
        }
    }


    //第四种布局
    static class ViewHolderFour extends RecyclerView.ViewHolder {
        private ImageView babybusImage;
        private TextView babybusTitle;
        private View babybusView;

        public ViewHolderFour(View view) {
            super(view);

            babybusView = view;
            babybusImage = (ImageView) view.findViewById(R.id.iv_choose1);
            babybusTitle = (TextView) view.findViewById(R.id.tv_choose1);
        }
    }

    //第五种布局
    static class ViewHolderFive extends RecyclerView.ViewHolder {
        private ImageView babybusImage;
        private TextView babybusTitle;
        private TextView babaybusName;
        private View babybusView;
        private TextView delete;
        private TextView date;

        public ViewHolderFive(View view) {
            super(view);

            babybusView = view;
            babybusImage = (ImageView) view.findViewById(R.id.iv_choose_two1);
            babybusTitle = (TextView) view.findViewById(R.id.tv_choose_two2);
            babaybusName = view.findViewById(R.id.tv_choose_two1);
            delete = view.findViewById(R.id.delete);
            date = view.findViewById(R.id.tv_choose_two3);
        }
    }

    /**
     *
     * 删除recycleview的item函数*/
    public void removeData(int position) {
        mBabybusList.remove(position);

        notifyItemRemoved(position);
        notifyDataSetChanged();
    }


}
