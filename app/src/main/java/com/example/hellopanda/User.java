package com.example.hellopanda;

import java.time.ZonedDateTime;

class User {
    //define variables for User
    private String userName;
    private String password;
    private String email;
    private ZonedDateTime time;
    private long streak;

    public User() {
    }

    // initialise constructor
    public User(String userName, String password, String email, ZonedDateTime time, long streak) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.time = time;
        this.streak = streak;
    }
    public User(String userName, String password, String email, ZonedDateTime time) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.time = time;
    }

    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(ZonedDateTime time) {
        this.time = time;
    }

    public User(long streak) {
        this.streak = streak;
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

    public ZonedDateTime getTime() { return time; }

    public long getStreak() { return streak; }
}
