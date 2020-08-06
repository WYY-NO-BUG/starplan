package com.demo.starplan.mvp;

public interface Callback<T> {

    //成功返回
    void onSuccess(T data);

    //失败返回
    void onFauilure();
}
