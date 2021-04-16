package com.example.ticketify;

public class Discount {
    private String title;
    private String description;
    private String imgURL;

    public void Discount() {

    }

    public Discount(String title, String description, String imgURL) {
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getDescription() {
        return description;
    }


}
