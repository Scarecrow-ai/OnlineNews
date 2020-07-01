package com.news;

import com.news.dao.NewsDao;
import com.news.entity.News;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<News> result = new ArrayList<>();
//        result.add(NewsDao.selectNews(1));
//        for (News news : result) {
//            System.out.println(news.getNewsTitle());
//        }
        NewsDao.delete(50);
    }
}
