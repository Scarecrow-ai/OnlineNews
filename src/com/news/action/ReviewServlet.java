package com.news.action;

import com.news.dao.ReviewDao;
import com.news.dao.impl.ReviewDaoImpl;
import com.news.entity.Review;
import com.news.entity.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {

    ReviewDao dao = new ReviewDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前台传递的评论内容以及新闻id

        req.setCharacterEncoding("UTF-8");
        String strid = req.getParameter("newsId");
        Integer newsid = Integer.parseInt(strid);
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        String username = user.getUserName();

        //创建实体化对象
        Review review = new Review();

        review.setNewsId(newsid);
        review.setUserName(username);
        review.setText(text);

        dao.insert(review);

        resp.sendRedirect("detail_page_test.html?newsId=" + newsid);
    }
}
