package com.example.recyclerviewjson;

public class KittenItem {

    private String imageUrl;
    private String kittenName;
    private int kittenLikes;


    public KittenItem(String imageUrl, String kittenName, int kittenLikes) {
        this.imageUrl = imageUrl;
        this.kittenName = kittenName;
        this.kittenLikes = kittenLikes;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getKittenName(){
        return kittenName;
    }

    public int getKittenLikes(){
        return kittenLikes;
    }
}
