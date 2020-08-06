package com.demo.starplan.history;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.Callback;
import com.demo.starplan.mvp.IModel;
import com.demo.starplan.mvp.IPresenter;
import com.demo.starplan.mvp.IView;

import java.util.List;

public interface HistoryContract {

    interface View extends IView {
        void showView(List<Babybus> babybusList);
    }

    interface Model extends IModel {

        //从数据库获取数据
        void getData(Callback callback);


    }

    interface Presenter<V extends HistoryContract.View, M extends HistoryContract.Model> extends IPresenter<V, M > {

    }
}
