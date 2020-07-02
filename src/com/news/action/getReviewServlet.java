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

@WebServlet("/getReview")
public class getReviewServlet extends HttpServlet {
    ReviewDao dao = new ReviewDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strid = req.getParameter("newsId");
        Integer newsid = Integer.parseInt(strid);
        List<Review> list = dao.selectnewsId(newsid);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);
        resp.getWriter().write(jsonArray.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
