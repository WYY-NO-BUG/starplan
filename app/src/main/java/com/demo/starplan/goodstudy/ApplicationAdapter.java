package com.demo.starplan.goodstudy;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.starplan.R;

import java.util.ArrayList;

public class ApplicationAdapter extends RecyclerView.Adapter {

    //布局类型
    private static final int VIEW_TYPE_ONE = 1;
    private static final int VIEW_TYPE_TWO = 2;
    private static final int VIEW_TYPE_THREE = 3;
    private static final int VIEW_TYPE_FOUR = 4;

    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<ApplicationBean> mDataList;

    public ApplicationAdapter(Context mContext, ArrayList<ApplicationBean> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position).getType() == ApplicationBean.TypeOne) {
            return VIEW_TYPE_ONE;
        } else if (mDataList.get(position).getType() == ApplicationBean.TypeTwo) {
            return VIEW_TYPE_TWO;
        } else if (mDataList.get(position).getType() == ApplicationBean.TypeThree) {
            return VIEW_TYPE_THREE;
        } else if (mDataList.get(position).getType() == ApplicationBean.TypeOFour) {
            return VIEW_TYPE_FOUR;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case VIEW_TYPE_ONE:
                viewHolder = new
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //第一种布局viewHolder
    public static class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView title_text;
        private ImageView icon;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

            title_text = (TextView) itemView.findViewById(R.id.tv_small_title);
            icon = itemView.findViewById(R.id.iv_small_title);
        }
    }

    //第二种布局
    public static class ViewHolderTwo extends RecyclerView.ViewHolder {

        private TextView title_text;
        private ImageView icon1,icon2,icon3;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);

            title_text = (TextView) itemView.findViewById(R.id.tv_small_title);
            icon = itemView.findViewById(R.id.iv_small_title);
        }
    }
}
