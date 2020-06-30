package com.news.entity;

import com.news.dao.UserDao;

import java.util.List;

public class User  {

    private int userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPwd;
    private String userImg;

    public int getUserId(){return userId;}
    public String getUserName(){return userName;}
    public String getUserPhone(){return userPhone;}
    public String getUserEmail(){return userEmail;}
    public String getUserPwd(){return userPwd;}
    public String getUserImg(){return userImg;}

    public void setUserId(int id)
    {
        this.userId=id;
    }

    public  void  setUserName(String name)
    {
        this.userName=name;
    }

    public void setUserPhone(String phone)
    {
        this.userPhone=phone;
    }

    public void setUserEmail(String email)
    {
        this.userEmail=email;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
