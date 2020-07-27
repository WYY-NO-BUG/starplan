package com.demo.starplan.goodstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.starplan.R;

import java.util.List;

public class BabybusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<babybus> mBabybusList;
    private static final int VIEW_TYPE_ONE = 1;
    private static final int VIEW_TYPE_TWO = 2;
    private static final int VIEW_TYPE_THREE = 3;
    private static final int VIEW_TYPE_FOUR = 4;

    private Context mContext;
    private LayoutInflater inflater;

    public BabybusAdapter(List<babybus> mBabybusList, Context context) {
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
            case babybus.TypeOne:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.item_show, parent, false));
                break;
            case VIEW_TYPE_TWO:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.item_show_two, parent, false));
                break;
            case VIEW_TYPE_THREE:
                viewHolder = new ViewHolderThree(inflater.inflate(R.layout.item_title_small, parent, false));
                break;
            case babybus.TypeFour:
                viewHolder = new ViewHolderFour(inflater.inflate(R.layout.item_choose_one, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        babybus bbb = mBabybusList.get(position);
        switch (getItemViewType(position)) {
            case babybus.TypeOne:
                ((ViewHolderOne) holder).icon1.setImageResource(bbb.getImageId());
                ((ViewHolderOne) holder).icon2.setImageResource(bbb.getImageId());
                ((ViewHolderOne) holder).icon3.setImageResource(bbb.getImageId());
                ((ViewHolderOne) holder).title.setText(bbb.getTitle());
                break;

            case babybus.TypeTwo:
                ((ViewHolderTwo) holder).babybusTitle.setText(bbb.getTitle());
                ((ViewHolderTwo) holder).babybusImage.setBackgroundResource(bbb.getImageId());
                break;

            case babybus.TypeThree:
                ((ViewHolderThree) holder).babybusTitle.setText(bbb.getTitle());
                ((ViewHolderThree) holder).babybusImage.setBackgroundResource(bbb.getImageId());
                break;

            case babybus.TypeFour:
                ((ViewHolderFour) holder).babybusTitle.setText(bbb.getTitle());
                ((ViewHolderFour) holder).babybusImage.setBackgroundResource(bbb.getImageId());
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

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_show1);
            icon1 = itemView.findViewById(R.id.iv_show1);
            icon2 = itemView.findViewById(R.id.iv_show2);
            icon3 = itemView.findViewById(R.id.iv_show3);
        }
    }

    //第二种布局
    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        ImageView babybusImage;
        TextView babybusTitle;

        public ViewHolderTwo(View view) {
            super(view);
            babybusImage = (ImageView) view.findViewById(R.id.iv_show5);
            babybusTitle = (TextView) view.findViewById(R.id.tv_show);
        }
    }

    //第三种布局
    static class ViewHolderThree extends RecyclerView.ViewHolder {
        ImageView babybusImage;
        TextView babybusTitle;

        public ViewHolderThree(View view) {
            super(view);
            babybusImage = (ImageView) view.findViewById(R.id.iv_small_title);
            babybusTitle = (TextView) view.findViewById(R.id.tv_small_title);
        }
    }


    static class ViewHolderFour extends RecyclerView.ViewHolder {
        ImageView babybusImage;
        TextView babybusTitle;

        public ViewHolderFour(View view) {
            super(view);
            babybusImage = (ImageView) view.findViewById(R.id.iv_choose1);
            babybusTitle = (TextView) view.findViewById(R.id.tv_choose1);
        }
    }


}
