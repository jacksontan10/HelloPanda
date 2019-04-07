package com.example.hellopanda;

class User {
    //define variables for User
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    // initialise constructor
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    // create getter methods
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
