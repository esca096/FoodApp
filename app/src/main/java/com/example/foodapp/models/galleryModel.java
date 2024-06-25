package com.example.foodapp.models;

public class galleryModel {
    int image;
    String discount;
    String name;
    String type;
    String description;

    public galleryModel(int image, String discount, String name, String description) {
        this.image = image;
        this.discount = discount;
        this.name = name;
        this.description = description;
    }

    public galleryModel(int image, String discount, String name, String type, String description) {
        this.image = image;
        this.discount = discount;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
