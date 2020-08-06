package com.demo.starplan.history;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.BasePresenter;
import com.demo.starplan.mvp.Callback;

import java.util.List;

public class HistoryPresenter extends BasePresenter<HistoryActivity,HistoryModel>
        implements HistoryContract.Presenter<HistoryActivity,HistoryModel> {

    public HistoryPresenter(HistoryActivity historyActivity) {
        mView = historyActivity;
        mModel = new HistoryModel();
    }

    @Override
    public void getMessage() {
        mModel.getData(new Callback<List<Babybus>>() {
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
