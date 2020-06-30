package com.news.dao;

import com.news.entity.News;

import java.util.List;

public interface NewsDao {
    /**
     * 添加
     */
     public int insert (News news);
    /**
     * 删除
     */
     public int delete (News news);
    /**
     * 修改
     */
     public int update (News news);
    /**
     * 查询
     */
     public List<News> selectAll();
    /**
     * 通过浏览次数查询
     */
     public List<News> selectCount();
    /**
     * 通过标签查询国内或国外新闻
     */
     public List<News> selectLabel();
    /**
     * 通过关键词查询
     */
     public List<News> selectKey();
    /**
     * 通过id查询返回一个新闻对象
     *
     */
     public News selectId();
}
