package com.news.dao.impl;

import com.news.dao.UserDao;
import com.news.entity.User;
import com.news.utils.DButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DButils implements UserDao {
    @Override
    public User selectID(User user) {
        Object params[] = {user.getUserId()};
        String sql = "select * from user where userId=? ";

        ResultSet rs = doQuery(sql, params);
        //将学生对象声明出来,否则会成为try-catch语句中的局部变量
        User user1 = new User();
        try {
            if (rs.next())//有这个用户
            {

                //构造用户对象

                user1.setUserId(rs.getInt(1));
                user1.setUserName(rs.getString(2));
                user1.setUserPhone(rs.getString(3));
                user1.setUserEmail(rs.getString(4));
                user1.setUserPwd(rs.getString(5));
                user1.setUserImg(rs.getString(6));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user1;
    }

    @Override
    public List<User> selectAll() {

        Object params[] = null;
        String sql = "select * from user";

        ResultSet rs = doQuery(sql, params);
        List<User> list = null;
        //将学生放在list集合中
        while (true) {
            try {
                if (!rs.next()) break;
                else rs.beforeFirst();//将光标送到第一行之前
                list = new ArrayList<User>();
                while (rs.next()) {
                    //将每一个学生记录保存在list集合中
                    User user = new User();
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setUserPhone(rs.getString(3));
                    user.setUserEmail(rs.getString(4));
                    user.setUserPwd(rs.getString(5));
                    user.setUserImg(rs.getString(6));

                    list.add(user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return list;
    }

    @Override
    public int update(User user) {

        Object params[] = {user.getUserName(), user.getUserPwd(),
                user.getUserPhone(), user.getUserEmail(), user.getUserImg(), user.getUserId()};

        String sql = "update user set userName=?,userPwd=?,userPhone=?,userEmail=?,userImg=? where userId=?";
        int i = doUpdate(sql, params);
        getClose();
        return i;
    }

    @Override
    public int delete(User user) {

        Object params[] = {user.getUserId()};

        String sql = "delete from user where userId=?";
        int i = doUpdate(sql, params);
        getClose();
        return i;
    }

    @Override
    public int insert(User user) {
        //给占位符赋值
        Object params[] = {null, user.getUserName(), user.getUserPhone(),
                user.getUserEmail(), user.getUserPwd(), user.getUserImg()};

        //要执行的sql语句
        String sql = "insert into user values(?,?,?,?,?,?)";
        int i = doUpdate(sql, params);

        //释放资源
        getClose();
        return i;
    }

    @Override
    public User selectName(User user) {
        Object params[] = {user.getUserName()};
        String sql = "select * from user where userName=? ";

        ResultSet rs = doQuery(sql, params);
        //将学生对象声明出来,否则会成为try-catch语句中的局部变量
        User user1 = new User();
        try {
            if (rs.next())//有这个学生
            {

                //构造用户对象

                user1.setUserId(rs.getInt(1));
                user1.setUserName(rs.getString(2));
                user1.setUserPhone(rs.getString(3));
                user1.setUserEmail(rs.getString(4));
                user1.setUserPwd(rs.getString(5));
                user1.setUserImg(rs.getString(6));

            } else user1 = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user1;
    }
}

