package com.demo.starplan.mediaplay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.demo.starplan.R;
import com.demo.starplan.bean.VideoBean;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    private List<VideoBean.DataBean.ListBean> mVideoBeanList;
    private Context mContext;


    //设置图片圆角
    private RoundedCorners roundedCorners = new RoundedCorners(30);
    private RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

    public MediaAdapter(List<VideoBean.DataBean.ListBean> videoBeanList, Context mContext) {
        this.mVideoBeanList = videoBeanList;
        this.mContext = mContext;
    }



    //声明接口
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public MediaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media_show, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MediaAdapter.ViewHolder holder, final int position) {

        final VideoBean.DataBean.ListBean video = mVideoBeanList.get(position);
        Glide.with(mContext)
                .load(video.getImg())
                .apply(options)
                .into(holder.videoImage);
        holder.videoName.setText(video.getName());
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideoBeanList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView videoImage;
        TextView videoName;
        View videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView;
            videoImage = itemView.findViewById(R.id.iv_right_media);
            videoName = itemView.findViewById(R.id.tv_right_media);
        }
    }

}
