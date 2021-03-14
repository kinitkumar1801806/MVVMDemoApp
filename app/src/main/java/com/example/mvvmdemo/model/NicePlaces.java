package com.example.mvvmdemo.model;

public class NicePlaces {
    public String title,imageurl;

    public NicePlaces(String imageurl,String title) {
        this.title = title;
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
