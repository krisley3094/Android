package com.itbank.listview03;

import android.graphics.drawable.Drawable;

/**
 * Created by 연지점204강사 on 2017-06-17.
 */


/*
    4개의 데이터를 1개처럼 사용하고 싶다
    묶음 처리를 클래스를 이용하여 수행

    데이터 저장 묶음 클래스(DTO / VO)
 */
public class ListItem {
    //변수로 데이터들을 선언
    private Drawable icon;
    private String title;
    private String detail;
    private int price;

    //변수가 잠겨 있으므로 편리하게 사용하기 위한 생성자/세터메소드/게터메소드를 추가
    public ListItem() {
    }

    public ListItem(Drawable icon, String title, String detail, int price) {
        this.icon = icon;
        this.title = title;
        this.detail = detail;
        this.price = price;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}












