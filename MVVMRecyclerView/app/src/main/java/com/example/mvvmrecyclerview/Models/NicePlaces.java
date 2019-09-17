package com.example.mvvmrecyclerview.Models;

public class NicePlaces {

    private String title;
    private String imageUrl;

    public NicePlaces(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public NicePlaces(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
