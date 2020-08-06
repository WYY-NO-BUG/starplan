package com.demo.starplan.mediaplay;


import android.content.Context;
import android.widget.VideoView;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.bean.VideoBean;
import com.demo.starplan.mvp.Callback;
import com.demo.starplan.mvp.IModel;
import com.demo.starplan.mvp.IPresenter;
import com.demo.starplan.mvp.IView;

import java.util.List;

public interface MediaContract {

    interface View extends IView{
        //展示数据
        void showView(List<VideoBean.DataBean.ListBean> data);
    }
    interface Model extends IModel {

        //请求网络数据
        void sendRequestWithOkHttp(Callback callback);

        void init();

        void addVideoToHistory(VideoBean.DataBean.ListBean data);
    }

    interface Presenter<V extends MediaContract.View, M extends MediaContract.Model> extends IPresenter<V, M > {
        void addHistory(VideoBean.DataBean.ListBean data);
    }
}
