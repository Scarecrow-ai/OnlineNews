package com.news.entity;

public class Review {
    private int reviewId;
    private String userName;
    private int newsId;
    private String text;

    public int getReviewId() {
        return reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getText() {
        return text;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNewsId(int newsid) {
        this.newsId = newsid;
    }

    public void setText(String text) {
        this.text = text;
    }
}
