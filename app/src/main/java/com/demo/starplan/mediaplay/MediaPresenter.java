package com.demo.starplan.mediaplay;

import androidx.fragment.app.FragmentActivity;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.bean.VideoBean;
import com.demo.starplan.mvp.BasePresenter;
import com.demo.starplan.mvp.Callback;
import com.demo.starplan.mvp.IPresenter;

import java.util.List;

public class MediaPresenter extends BasePresenter<MediaActivity, MediaModel>
        implements MediaContract.Presenter<MediaActivity, MediaModel> {

    public MediaPresenter(MediaActivity mediaActivity) {
        mView = mediaActivity;
        mModel = new MediaModel();
    }

    @Override
    public void getMessage() {
        mModel.sendRequestWithOkHttp(new Callback<List<VideoBean.DataBean.ListBean>>() {
            @Override
            public void onSuccess(List<VideoBean.DataBean.ListBean> data) {
                mView.showView(data);
            }

            @Override
            public void onFauilure() {

            }
        });
    }

    @Override
    public void addHistory(VideoBean.DataBean.ListBean data) {
        mModel.addVideoToHistory(data);
    }
}
