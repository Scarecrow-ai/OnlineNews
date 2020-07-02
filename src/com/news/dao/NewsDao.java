package com.news.dao;

import com.news.entity.News;
import com.news.utils.NewsDButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface NewsDao {
    /**
     * 删除
     */
    static boolean delete(int newsId) {
        boolean deleteFinished = false;
        String sql = "DELETE FROM news WHERE newsId=" + newsId;
        NewsDButils dButils = new NewsDButils();
        try {
            dButils.getConnect();
            dButils.updateTable(sql);
            dButils.getClose();
            deleteFinished = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deleteFinished;
    }

    /**
     * 修改
     */
    static boolean update(News news) {
        boolean updateFinished = false;
        String sql = "UPDATE news SET newsTitle='" + news.getNewsTitle() +
                "' , newsText='" + news.getNewsText()
                + "', newsLabel='" + news.getNewsLabel()
                + "', newsCount=" + news.getNewsCount()
                + " WHERE newsId=" + news.getNewsId();

        NewsDButils dButils = new NewsDButils();
        try {
            dButils.getConnect();
            dButils.updateTable(sql);
            dButils.getClose();
            updateFinished = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return updateFinished;
    }

    /**
     * 查询
     */
    static List<News> selectNews(String keyword) {
        String sql;

        if (Pattern.matches("^Label:.*", keyword))            //按标签搜索
        {
            sql = "SELECT newsID, newsTitle, newsText, newsCount,newsLabel FROM news " +
                    "WHERE newsLabel REGEXP '" + keyword.substring(6) + "'";
        } else {                                                  //搜索标题
            sql = "SELECT newsID, newsTitle, newsText, newsCount,newsLabel FROM news " +
                    "WHERE newsTitle REGEXP '" + keyword + "'";
        }
        List<News> matchNews = new ArrayList<>();
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

    static News selectNews(int id) {
        String sql = "SELECT newsID, newsTitle, newsText, newsCount,newsLabel FROM news " +
                "WHERE newsID=" + id;
        ResultSet rs;
        News targetNews = null;
        NewsDButils dButils = new NewsDButils();
        try {
            dButils.getConnect();
            rs = dButils.selectTable(sql);
            while (rs.next()) {
                targetNews = new News(rs.getInt("newsId")
                        , rs.getString("newsTitle")
                        , rs.getString("newsText")
                        , rs.getInt("newsCount")
                        , rs.getString("newsLabel")
                );
            }
            dButils.getClose();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return targetNews;
    }
}
