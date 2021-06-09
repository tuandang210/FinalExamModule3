package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int number;
    private String color;
    private String intro;
    private int idCate;

    public Product() {
    }

    public Product(String name, float price, int number, String color, String intro, int idCate) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.intro = intro;
        this.idCate = idCate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }
}
