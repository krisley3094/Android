package com.itbank.listview04;

import android.graphics.drawable.Drawable;

/**
 * Created by 연지점204강사 on 2017-06-17.
 */

public class MusicData {
    private Drawable image;
    private int rank;
    private String title;

    public MusicData(Drawable image, int rank, String title) {
        this.image = image;
        this.rank = rank;
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
