package com.example.hellopanda.models;

import java.time.ZonedDateTime;

public class User {
    //define variables for User
    private String user;
    private String password;
    private String email;
    private int panda;

    // initialise constructors
    public User() {
    }

    public User(String user, String password, String email, int panda) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.panda = panda;
    }
    // create getter methods
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPanda() { return panda;}
}