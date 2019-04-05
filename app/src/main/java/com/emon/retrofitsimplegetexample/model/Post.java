package com.emon.retrofitsimplegetexample.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;
    private int userId;
    private String title;
    @SerializedName("body")
    private String text;


    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
