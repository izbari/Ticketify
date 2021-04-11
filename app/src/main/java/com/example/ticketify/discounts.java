package com.example.ticketify;

public class discounts {
    private String title;
    private String description;
    private int imgID;


    public discounts(String title, String description, int imgID) {
        this.title = title;
        this.description = description;
        this.imgID = imgID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImgID() {
        return imgID;
    }
}
