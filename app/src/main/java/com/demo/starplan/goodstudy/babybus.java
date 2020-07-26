package com.demo.starplan.goodstudy;

public class babybus {
    private String title;
    private int imageId;
    public static final int TypeOne = 1;
    public static final int TypeTwo = 2;
    public static final int TypeThree = 3;
    public static final int TypeFour = 4;
    public int type;


    public babybus(String name, int imageId){
        this.title = name;
        this.imageId = imageId;
    }

    public babybus(String name, int imageId,int type){
        this.title = name;
        this.imageId = imageId;
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
