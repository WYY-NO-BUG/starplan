package com.demo.starplan.recommend;

import com.demo.starplan.bean.BabyBusBean;
import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.Callback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecommendedModel implements RecommendedContract.Model {

    private BabyBusBean babyBusBean;
    private List<Babybus> babybusList;
    String responseData;

    @Override
    public void sendRequestWithOkHttp(final Callback callback) {
        //开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://gitee.com/qfxl/star_project/raw/master/forTest.json")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    responseData = response.body().string();
                    babyBusBean = new Gson().fromJson(responseData, BabyBusBean.class);
                    init();
                    callback.onSuccess(babybusList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void init() {
        babybusList = new ArrayList<>();
        Babybus bbb = new Babybus();
        int i = 0;
        for (BabyBusBean.DataBean.RecommendListBean BDR : babyBusBean.getData().getRecommendList()) {
            if (bbb.getName() == null) {
                bbb.setName(BDR.getSerialInfo());
                bbb.type = 1;
                bbb.setUrlImgRec(BDR.getImg(), i);
                i++;
            } else {
                bbb.setUrlImgRec(BDR.getImg(), i);
                i++;
            }
        }
        babybusList.add(bbb);
        for (BabyBusBean.DataBean.SubjectListBean BDR : babyBusBean.getData().getSubjectList()) {
            babybusList.add(new Babybus(BDR.getName(), BDR.getImg(), 2));
        }
        for (BabyBusBean.DataBean.EliteListBean BDR : babyBusBean.getData().getEliteList()) {
            babybusList.add(new Babybus(BDR.getName(), BDR.getImg(), 3));
        }
        for (BabyBusBean.DataBean.EliteListBean.ListBean BDR : babyBusBean.getData().getEliteList().get(0).getList()) {
            Babybus bbb1 = new Babybus(BDR.getName(), BDR.getImg(), 4);
            bbb1.setDesc(BDR.getDesc());
            babybusList.add(bbb1);
        }
    }
}