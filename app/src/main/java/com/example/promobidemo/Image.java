package com.example.promobidemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.io.Serializable;

public class Image  {
    @ColumnInfo(name="imageid")
    private String id;
    @ColumnInfo(name="imagewidth")
    private int width;
    @ColumnInfo(name="imageheight")
    private int height;
    @ColumnInfo(name="imageurl")
    private String url;

    @Ignore
    public Image(){}
    public Image(String id, int width, int height, String url) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
