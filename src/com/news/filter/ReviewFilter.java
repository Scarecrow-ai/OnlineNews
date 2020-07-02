package com.news.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReviewFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //得到HttpServletRequest对象
        HttpServletRequest requ = (HttpServletRequest) servletRequest;
        //获取session中的值
        String username = (String) requ.getSession().getAttribute("user");
        //判断session中是否有值
        if (username != null) {
            //如果有值,则继续执行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //如果没有值,那麽重定向到登录页面
            HttpServletResponse respon = (HttpServletResponse) servletResponse;//得到HttpServletResponse对象
            respon.sendRedirect("index.html");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
