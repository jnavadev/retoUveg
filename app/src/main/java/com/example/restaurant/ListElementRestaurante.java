package com.example.restaurant;

import java.io.Serializable;

public class ListElementRestaurante implements Serializable {

    public String color;
    public String name;

    public ListElementRestaurante(String color, String name) {
        this.color = color;
        this.name = name;
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
}
