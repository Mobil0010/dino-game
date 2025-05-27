package com.chrome.dinogame.dinogame.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scores")
public class Score {
    @Id
    private String id;
    private String userId;
    private double value;
    private long playTime;

    public Score() {}

    public Score(String userId, double value, long playTime) {
        this.userId = userId;
        this.value = value;
        this.playTime = playTime;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public double getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public long getPlayTime() { return playTime; }
    public void setPlayTime(long playTime) { this.playTime = playTime; }
}
