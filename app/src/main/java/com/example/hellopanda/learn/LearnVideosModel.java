//referenced from https://www.youtube.com/watch?v=bSMZknDI6bg channel: android-coffee.com

package com.example.hellopanda.learn;

public class LearnVideosModel {

    String videoUrl;

    public LearnVideosModel() {
    }

    public LearnVideosModel(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
