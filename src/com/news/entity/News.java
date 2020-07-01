package com.news.entity;

import com.news.dao.NewsDao;

import java.util.List;

public class News {
    private int newsId;
    private String newsTitle;
    private String newsText;
    private int newsCount;
    private String newsLabel;

    public News(int id, String title, String text, int count, String label) {
        newsId = id;
        newsTitle = title;
        newsText = text;
        newsCount = count;
        newsLabel = label;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

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
}
