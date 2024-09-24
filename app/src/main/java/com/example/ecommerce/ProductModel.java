package com.example.ecommerce;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private String id;
    private String title;
    private String description;
    private String price;
    private String Image;
    private boolean show;

    public ProductModel() {

    }

    public ProductModel(String id, String title, String description, String price, String image, boolean show) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        Image = image;
        this.show = show;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
