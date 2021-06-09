package com.codegym.model;

public class Category {
    private int idCate;
    private String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
