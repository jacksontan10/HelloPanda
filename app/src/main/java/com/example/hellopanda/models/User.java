package com.example.hellopanda.models;

import java.time.ZonedDateTime;

public class User {
    //define variables for User
    private String user;
    private String password;
    private String email;
    private ZonedDateTime time;
    private long streak;

    // initialise constructors
    public User() {
    }

    public User(String user, String password, String email) {
        this.user = user;
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
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public long getStreak() {
        return streak;
    }
}