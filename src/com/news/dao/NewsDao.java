package com.news.dao;

import com.news.entity.News;
import com.news.utils.DButils;
import com.news.utils.NewsDButils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface NewsDao {
    /**
     * 删除
     */
    static boolean delete(News news) {
        return false;
    }

    /**
     * 修改
     */
    static boolean update(News news) {
        return false;
    }

    /**
     * 查询
     */
    static List<News> selectNews(String keyword) {
        List<News> matchNews = new ArrayList<>();
        String sql = "SELECT newsID, newsTitle, newsText, newsCount,newsLabel FROM news " +
                "WHERE newsTitle REGEXP '" + keyword + "'";
        ResultSet rs;
        NewsDButils dButils = new NewsDButils();
        try {
            dButils.getConnect();
            rs = dButils.selectTable(sql);
            while (rs.next()) {
                matchNews.add(
                        new News(rs.getInt("newsId")
                                , rs.getString("newsTitle")
                                , rs.getString("newsText")
                                , rs.getInt("newsCount")
                                , rs.getString("newsLabel")
                        )
                );
            }
            dButils.getClose();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return matchNews;
    }
}
