package com.news.action;

import com.news.dao.NewsDao;
import com.news.entity.News;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsDetail")
public class NewsDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        News targetNews = NewsDao.selectNews(newsId);

        updateNewsCount(targetNews);

        JSONObject newsDetail = new JSONObject();
        newsDetail.put("newsTitle", targetNews.getNewsTitle());
        newsDetail.put("newsText", targetNews.getNewsText());
//        String titleHTML = "<h1><a href=\"javascript:;\">" + targetNews.getNewsTitle() + "</a></h1>";
//        ResponseForAjax.sendAsJson(resp, titleHTML + targetNews.getNewsText());
        ResponseForAjax.sendAsJson(resp, newsDetail.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void updateNewsCount(News news) {
        News result = new News(news.getNewsId(), news.getNewsTitle(), news.getNewsText(), news.getNewsCount() + 1, news.getNewsLabel());
        NewsDao.update(result);
    }
}

