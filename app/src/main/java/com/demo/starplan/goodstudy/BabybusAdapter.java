package com.demo.starplan.goodstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.starplan.HistoryActivity;
import com.demo.starplan.R;
import com.demo.starplan.database.HistoryPlay;
import com.demo.starplan.httpdemo.ReturnImg;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.List;

public class BabybusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<babybus> mBabybusList;

    private Context mContext;
    private LayoutInflater inflater;

    private List<HistoryPlay> historyPlayList;
    private List<HistoryPlay> selectList;
    private babybus deleteChoose;

    public BabybusAdapter(List<babybus> mBabybusList, Context context) {
        this.mBabybusList = mBabybusList;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    public void removeData(int position) {
        mBabybusList.remove(position);

        notifyItemRemoved(position);
        notifyDataSetChanged();
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
            case babybus.TypeOne:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.item_show, parent, false));
                break;
            case babybus.TypeTwo:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.item_show_two, parent, false));
                break;
            case babybus.TypeThree:
                viewHolder = new ViewHolderThree(inflater.inflate(R.layout.item_title_small, parent, false));
                break;
            case babybus.TypeFour:
                viewHolder = new ViewHolderFour(inflater.inflate(R.layout.item_choose_one, parent, false));
                break;
            case babybus.TypeFive:
                viewHolder = new ViewHolderFive(inflater.inflate(R.layout.item_choose_two, parent, false));
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final babybus bbb = mBabybusList.get(position);
        switch (getItemViewType(position)) {
            case babybus.TypeOne:
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderOne) holder).icon1);
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderOne) holder).icon2);
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderOne) holder).icon3);
                ((ViewHolderOne) holder).title.setText(bbb.getName());
                ((ViewHolderOne) holder).babybusView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        historyPlayList = LitePal.where("urlImg = ?", bbb.getUrlImg())
                                .find(HistoryPlay.class);
//                        historyPlayList = LitePal.findAll(HistoryPlay.class);
                        if (historyPlayList.size() == 0) {
                            HistoryPlay historyPlay = new HistoryPlay();
                            historyPlay.setTitle(bbb.getTitle());
                            historyPlay.setUrlImg(bbb.getUrlImg());
                            historyPlay.save();
                        }

                    }
                });
                break;

            case babybus.TypeTwo:
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderTwo) holder).babybusImage);
                ((ViewHolderTwo) holder).babybusTitle.setText(bbb.getName());
                ((ViewHolderTwo) holder).babybusView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        historyPlayList = LitePal.where("name = ?", bbb.getName())
                                .find(HistoryPlay.class);
                        if (historyPlayList.size() == 0) {
                            HistoryPlay historyPlay = new HistoryPlay();
                            historyPlay.setName(bbb.getName());
                            historyPlay.setUrlImg(bbb.getUrlImg());
                            historyPlay.save();
                        }
                    }
                });

                break;

            case babybus.TypeThree:
                ((ViewHolderThree) holder).babybusTitle.setText(bbb.getName());
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderThree) holder).babybusImage);
                break;

            case babybus.TypeFour:
                ((ViewHolderFour) holder).babybusTitle.setText(bbb.getName());
                Glide.with(mContext)
                        .load(bbb.getUrlImg())
                        .into(((ViewHolderFour) holder).babybusImage);
                ((ViewHolderFour) holder).babybusView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        historyPlayList = LitePal.where("title = ?", bbb.getName())
                                .find(HistoryPlay.class);
                        if (historyPlayList.size() == 0) {
                            HistoryPlay historyPlay = new HistoryPlay();
                            historyPlay.setTitle(bbb.getName());
                            historyPlay.setUrlImg(bbb.getUrlImg());
                            historyPlay.setName(bbb.getDesc());
                            historyPlay.save();
                        }
                    }
                });
                break;

            case babybus.TypeFive:
                if (bbb.getTitle() != null) {
                    ((ViewHolderFive) holder).babybusTitle.setText(bbb.getTitle());
                }
                if (bbb.getName() != null) {
                    ((ViewHolderFive) holder).babaybusName.setText(bbb.getName());
                }
                String url = bbb.getUrlImg();
                Glide.with(mContext)
                        .load(url)
                        .into(((ViewHolderFive) holder).babybusImage);

                ((ViewHolderFive) holder).babybusView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "点击", Toast.LENGTH_SHORT).show();
                    }
                });
                ((ViewHolderFive) holder).babybusView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        deleteChoose = mBabybusList.get(holder.getAdapterPosition());
                        LitePal.deleteAll(HistoryPlay.class, "urlImg = ? or name = ?",
                                deleteChoose.getUrlImg(), deleteChoose.getName());

                        removeData(position);

                        return true;
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mBabybusList.size();
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

        public ViewHolderFive(View view) {
            super(view);

            babybusView = view;
            babybusImage = (ImageView) view.findViewById(R.id.iv_choose_two1);
            babybusTitle = (TextView) view.findViewById(R.id.tv_choose_two1);
            babaybusName = view.findViewById(R.id.tv_choose_two2);
        }
    }


}
