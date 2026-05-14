package com.EmbarkXPractice.ChallengeApp;

public class Challenge {

    private long id;
    private String month;
    private String description;

    public Challenge(Long id, String month, String description) {
        this.id =id;
        this.month = month;
        this.description = description;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
