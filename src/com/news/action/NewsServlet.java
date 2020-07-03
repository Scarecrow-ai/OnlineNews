package com.news.action;

import com.news.dao.NewsDao;
import com.news.entity.News;
import com.news.entity.User;
import com.news.utils.NewsDButils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/newsServlet")

public class NewsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求的编码为utf-8
        req.setCharacterEncoding("utf-8");

        //获取用户操作
        String caozuo = req.getParameter("caozuo");

        //判断用户想要进行的行为
        if (caozuo.equals("queryAll")) {
            System.out.println("用户的操作为" + caozuo);
            queryAll(req, resp);
        } else if (caozuo.equals("del")) {
            delNews(req, resp);
        } else if (caozuo.equals("findUpdNewsid")) {
            findUpdNewsid(req, resp);
        } else if (caozuo.equals("upd")) {
            updNews(req, resp);
        }
    }


    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //调用查询所有学生的服务
        List<News> newsList = NewsDao.selectAll();


        //将查询到的新闻添加到web容器中
        req.getSession().setAttribute("newsList", newsList);

        //跳转到指定的页面
        resp.sendRedirect("content/content2.jsp");
    }

    private void delNews(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取要删除的新闻id
        String strid = req.getParameter("newsID");
        Integer id = Integer.parseInt(strid);
        NewsDao.delete(id);

        //调用查询的函数，更新容器中的值
        queryAll(req, resp);
    }

    private void findUpdNewsid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String strid = req.getParameter("newsID");
        Integer id = Integer.parseInt(strid);

        News news = NewsDao.selectNews(id);

        //将用户对象存入到web容器
        req.getSession().setAttribute("selectnews", news);
        resp.sendRedirect("updNews.jsp");
    }

    private void updNews(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String strid = req.getParameter("newsID");
        Integer id = Integer.parseInt(strid);


        String title = req.getParameter("newsTitle");

        String text = req.getParameter("newsText");
        String strcount = req.getParameter("newsCount");
        Integer count = Integer.parseInt(strcount);
        String label = req.getParameter("newsLabel");

        News news = new News(id, title, text, count, label);

        NewsDao.update(news);

        queryAll(req, resp);
    }


}
