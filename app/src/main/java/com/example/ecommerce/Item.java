package com.example.ecommerce;

public class Item {
    private int imageResId;
    private String name;
    private int price;

    public Item(int imageResId, String name, int price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

