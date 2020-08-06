package com.demo.starplan.bean;

public class Babybus {

    private String name;
    private int imageId;
    private String urlImg;
    private String[] urlImgRec = new String[3];
    private String title;
    private String desc;
    private String date;

    private int i;


    public static final int TypeOne = 1;
    public static final int TypeTwo = 2;
    public static final int TypeThree = 3;
    public static final int TypeFour = 4;
    public static final int TypeFive = 5;
    public int type;

    public Babybus() {
    }

    public Babybus(String name, String title, String urlImg, String date, int type) {
        this.name = name;
        this.urlImg = urlImg;
        this.title = title;
        this.date = date;
        this.type = type;
    }

    public Babybus(String name, String urlImg, int i, int type) {
        this.name = name;
        this.urlImgRec[i] = urlImg;
        this.type = type;
    }

    public Babybus(String name, String url, int type){
        this.name = name;
        this.type = type;
        this.urlImg = url;
    }

    public Babybus(String name, int imageId, int type){
        this.name = name;
        this.imageId = imageId;
        this.type = type;
    }

    public String getUrlImgRec(int i) {
        return urlImgRec[i];
    }

    public void setUrlImgRec(String urlImg,int i) {
        this.urlImgRec[i] = urlImg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
