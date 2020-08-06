package com.demo.starplan.recommend;

import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.Callback;
import com.demo.starplan.mvp.IModel;
import com.demo.starplan.mvp.IPresenter;
import com.demo.starplan.mvp.IView;

import java.util.List;


public interface RecommendedContract {

    interface View extends IView{

        //展示数据
        void showView(List<Babybus> babybusList);
    }

    interface Model extends IModel{

        //请求网络数据
        void sendRequestWithOkHttp(Callback callback);


        //初始化数据
        void init();

    }

    interface Presenter<V extends View, M extends Model> extends IPresenter<V, M >{


    }
}
