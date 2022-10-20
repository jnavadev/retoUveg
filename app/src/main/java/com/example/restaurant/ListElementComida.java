package com.example.restaurant;

import java.io.Serializable;

public class ListElementComida implements Serializable {
    public String color;
    public String name;
    public String price;
    public String status;

    public ListElementComida(String color, String name, String price, String status) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
