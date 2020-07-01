package com.news;

import com.news.dao.NewsDao;
import com.news.entity.News;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<News> result = NewsDao.selectNews("好");
        for (News news : result) {
            System.out.println(news.getNewsTitle());
        }
    }
}
