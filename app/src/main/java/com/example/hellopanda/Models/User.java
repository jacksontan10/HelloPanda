package com.example.hellopanda.Models;

public class User {
    //define variables for User
    private String user;
    private String password;
    private String email;

    public User() {
    }

    // initialise constructor
    public User(String user, String password, String email) {
        this.user = user;
        this.password = password;
        this.email = email;
    }

    // create getter methods
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
