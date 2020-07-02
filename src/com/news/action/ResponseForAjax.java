package com.news.action;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResponseForAjax {
    static void sendAsJson(HttpServletResponse response, String str) {
        response.setContentType("application/json;charset=UTF-8");
        if (null != str)
            try {
                response.getWriter().write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    static void sendAsText(HttpServletResponse response, String str) {
        response.setContentType("text/html;charset=UTF-8");
        if (null != str)
            try {
                response.getWriter().write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
