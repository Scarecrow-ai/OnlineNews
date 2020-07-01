package com.news.dao;

import com.news.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加
     */
    public int insert(User user);

    /**
     * 删除
     */
    public int delete(User user);

    /**
     * 修改
     */
    public int update(User user);

    /**
     * 查询
     */
    public List<User> selectAll();

    /**
     * 以id作为条件进行查询
     */
    public User selectID(User user);

    /**
     * 以用户名作为条件进行查询
     */
    public User selectName(User user);
}
