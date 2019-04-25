package com.example.hellopanda.Models;

public class CategoryScore {
    private String Category_Score;
    private String user;
    private String score;

    public CategoryScore() {
    }

    public CategoryScore(String Category_Score, String user, String score) {
        this.Category_Score = Category_Score;
        this.user = user;
        this.score = score;
    }

    public String getCategory_Score() {
        return Category_Score;
    }

    public void setCategory_Score(String category_Score) {
        Category_Score = category_Score;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}