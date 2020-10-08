package com.example.clientp1.model;

import java.util.UUID;

public class Colors {

    private int r, g, b;
    private String id, type;

    public Colors(int r, int g, int b) {

        this.r = r;
        this.g = g;
        this.b = b;
        id = UUID.randomUUID().toString();
        type = "Color";
    }

    public Colors() {

    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
