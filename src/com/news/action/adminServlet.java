package com.news.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("adminId");
        String password = req.getParameter("password");
        System.out.println(id);
        System.out.println(password);

        if (id.equals("admin") && password.equals("12345")) {
            resp.sendRedirect("mainWeb/main.jsp");
        } else {
            resp.sendRedirect("adminSign.jsp");
        }
    }
}
