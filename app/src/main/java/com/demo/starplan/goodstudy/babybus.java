package com.demo.starplan.goodstudy;

import android.graphics.Bitmap;

import com.demo.starplan.httpdemo.ReturnImg;

public class babybus {

    private String name;
    private int imageId;
    private String urlImg;
    private String title;
    private String desc;

    public static final int TypeOne = 1;
    public static final int TypeTwo = 2;
    public static final int TypeThree = 3;
    public static final int TypeFour = 4;
    public static final int TypeFive = 5;
    public int type;

    public babybus(String name, String title, String urlImg, int type) {
        this.name = name;
        this.urlImg = urlImg;
        this.title = title;
        this.type = type;
    }

    public babybus(String name, String url, int type){
        this.name = name;
        this.type = type;
        this.urlImg = url;
    }

    public babybus(String name, int imageId,int type){
        this.name = name;
        this.imageId = imageId;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUrlImg() {
        return urlImg;
    }
}
