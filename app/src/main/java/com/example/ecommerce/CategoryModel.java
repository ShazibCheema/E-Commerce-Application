package com.example.ecommerce;

public class CategoryModel {
    private String name, icon, brief;
    private int id;

    public CategoryModel(String name, String icon, String brief, int id) {
        this.name = name;
        this.icon = icon;
        this.brief = brief;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
