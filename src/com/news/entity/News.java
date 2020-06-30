package com.news.entity;

import com.news.dao.NewsDao;

import java.util.List;

public class News {

    private int newsId;
    private String newsText;
    private int newsCount;
    private String newsLabel;

    public int getNewsId() {
        return newsId;
    }

    public int getNewsCount() {
        return newsCount;
    }

    public String getNewsText() {
        return newsText;
    }

    public String getNewsLabel() {
        return newsLabel;
    }


    public void setNewsId(int id) {
        this.newsId = id;
    }

    public void setNewsCount(int count) {
        this.newsCount = count;
    }

    public void setNewsText(String text) {
        this.newsText = text;
    }

    public void setNewsLabel(String label)
    {
        this.newsLabel=label;
    }
}
