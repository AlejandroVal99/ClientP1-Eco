package com.example.clientp1.model;

import java.util.UUID;

public class Name {

    private String nickname,id,type;

    public Name() {

    }

    public Name(String nickname) {
        this.nickname = nickname;
        id = UUID.randomUUID().toString();
        type = "Name";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
