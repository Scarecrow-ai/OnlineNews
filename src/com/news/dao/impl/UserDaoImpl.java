package com.news.dao.impl;

import com.news.dao.UserDao;
import com.news.entity.User;
import com.news.utils.DButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends DButils implements UserDao {
    @Override
    public User selectID(User user) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int insert(User user) {
        //给占位符赋值
        Object params [] ={null,user.getUserName(),user.getUserPhone(),
                user.getUserEmail(),user.getUserPwd(),user.getUserImg()};

        //要执行的sql语句
        String sql="insert into user values(?,?,?,?,?,?)";
        int i= doUpdate(sql,params);

        //释放资源
        getClose();
        return i;
    }

    @Override
    public User selectName(User user) {
        Object params[]={user.getUserName()};
        String sql="select * from user where userName=? ";

        ResultSet rs =doQuery(sql,params);
        //将学生对象声明出来,否则会成为try-catch语句中的局部变量
        User user1 =new User();
        try {
            if(rs.next())//有这个学生
            {

                //构造学生对象

                user1.setUserId(rs.getInt(1));
                user1.setUserName(rs.getString(2));
                user1.setUserPhone(rs.getString(3));
                user1.setUserEmail(rs.getString(4));
                user1.setUserPwd(rs.getString(5));
                user1.setUserImg(rs.getString(6));

            }
            else user1=null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user1;
    }
}

