package com.news.dao.impl;

import com.news.dao.ReviewDao;
import com.news.entity.Review;
import com.news.utils.ReviewDButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl extends ReviewDButils implements ReviewDao {
    @Override
    public int insert(Review review) {
        //给占位符赋值
        Object params[] = {null, review.getNewsId(), review.getUserName(), review.getText()};

        //要执行的sql语句
        String sql = "insert into review values(?,?,?,?)";
        int i = doUpdate(sql, params);

        //释放资源
        getClose();
        return i;
    }

    @Override
    //通过新闻的id来查询评论，并返回一个评论list集合

    public List<Review> selectnewsId(int id) {
        Object params[] = {id};
        String sql = "select * from review where newsId=?";
        ResultSet rs = doQuery(sql, params);
        List<Review> list = null;
        //将评论放在list集合中

        try {


            list = new ArrayList<Review>();
            while (rs.next()) {
                //将每一条评论保存在list集合中
                Review review = new Review();
                review.setReviewId(rs.getInt(1));
                review.setNewsId(rs.getInt(2));
                review.setUserName(rs.getString(3));
                review.setText(rs.getString(4));
                list.add(review);
            }
        } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



        return list;

    }

    @Override
    //通过reviewId删除评论
    public int delete(Review review) {
        Object params[] = {review.getReviewId()};

        String sql = "delete from review where reviewId=?";
        int i = doUpdate(sql, params);
        getClose();
        return i;
    }
}
