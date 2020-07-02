package com.news.action;

import com.news.dao.ReviewDao;
import com.news.dao.impl.ReviewDaoImpl;
import com.news.entity.Review;
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
        int newsid = 0;
        String username = null;
        String text = null;

        Review review = new Review();
        review.setNewsId(newsid);
        review.setUserName(username);
        review.setText(text);

        dao.insert(review);

        List<Review> list = dao.selectnewsId(newsid);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);
        resp.getWriter().write(jsonArray.toString());


    }
}
