package com.example.selectimage;

public class ImageCityBean {
    private String key;
    private String path;
    public ImageCityBean(String key, String path) {
        this.key = key;
        this.path = path;
    }

    public String getKey() {
        return key;
    }

    public String getPath() {
        return path;
    }
}
