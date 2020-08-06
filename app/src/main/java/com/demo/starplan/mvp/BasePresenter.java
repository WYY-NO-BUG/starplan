package com.demo.starplan.mvp;

public abstract class BasePresenter<V extends IView,M extends  IModel> implements IPresenter<V,M> {

    protected V mView;
    protected M mModel;


}
