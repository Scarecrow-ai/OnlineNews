package com.news;

import com.news.dao.NewsDao;
import com.news.entity.News;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<News> result = new ArrayList<>();
        result = NewsDao.selectNews("Label:hd");
        for (News news : result) {
            System.out.println(news.getNewsText());
        }
    }
}
