package com.news.dao;

import com.news.entity.Review;
import com.news.entity.User;

import java.util.List;

public interface ReviewDao {
    /**
     * 添加
     */
    public int insert(Review review);

    /**
     * 删除
     */
    public int delete(Review review);
    /**
     * 查询
     */
    public List<Review> selectnewsId(int id);
}
