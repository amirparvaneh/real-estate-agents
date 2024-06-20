package com.verde.realestates.model;

//use this enum after adding role to authentication
public enum Role {
    ADMIN(0),
    AGENT(1);


    private int value;

    Role(int value) {
        this.value = value;
    }
}
