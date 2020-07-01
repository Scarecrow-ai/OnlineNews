package com.news.action;

import com.news.dao.UserDao;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    UserDao dao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name1 =req.getParameter("userid");
        String pwd1 =req.getParameter("psw");


        User user1 =new User();
        user1.setUserName(name1);

        User user2=dao.selectName(user1);

        //判断是否存在该用户名
        if(user2==null)
        {
            resp.sendRedirect("SignError.jsp");
        }
        //判断存在该用户的情况下密码是否正确
        else if(user2.getUserPwd().equals("pwd1"))
        {
            req.getSession().setAttribute("userName",name1);

            resp.sendRedirect("main.html");
        }
        else {  resp.sendRedirect("SignError.jsp");}
    }





}
