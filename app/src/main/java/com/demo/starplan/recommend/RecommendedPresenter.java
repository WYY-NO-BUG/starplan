package com.demo.starplan.recommend;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.BasePresenter;
import com.demo.starplan.mvp.Callback;

import java.util.List;

public class RecommendedPresenter extends BasePresenter<RecommendedFragment, RecommendedModel>
        implements RecommendedContract.Presenter<RecommendedFragment, RecommendedModel> {


    public RecommendedPresenter(RecommendedFragment recommendedFragment) {
        mView = recommendedFragment;
        mModel = new RecommendedModel();
    }

    @Override
    public void getMessage() {
        mModel.sendRequestWithOkHttp(new Callback<List<Babybus>>() {

            @Override
            public void onSuccess(List<Babybus> data) {
                mView.showView(data);
            }

            @Override
            public void onFauilure() {

            }
        });
    }
}
