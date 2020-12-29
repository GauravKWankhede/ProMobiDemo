package com.example.promobidemo;

import io.realm.RealmObject;

public class Image  extends RealmObject {
    private String id;
    private int width;
    private int height;
    private String url;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }
}
