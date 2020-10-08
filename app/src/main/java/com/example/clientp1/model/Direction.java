package com.example.clientp1.model;

import java.util.UUID;

public class Direction {

    private int direction;
    private String type, id;

    public Direction() {

    }
    public Direction(int direction) {
        this.direction = direction;
        id = UUID.randomUUID().toString();
        type = "Direction";
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
