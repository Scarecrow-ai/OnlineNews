<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/3
  Time: 6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="newsServlet?caozuo=upd&newsID=${sessionScope.selectnews.newsId}" method="post">
    <h1>新闻id为${sessionScope.selectnews.newsId}</h1>
    标题：<input type="text" name="newsTitle" value="${sessionScope.selectnews.newsTitle}"><br>
    内容：<input type="text" name="newsText" value="${sessionScope.selectnews.newsText}"><br>
    热度：<input type="text" name="newsCount" value="${sessionScope.selectnews.newsCount}"><br>
    标签：<input type="text" name="newsLabel" value="${sessionScope.selectnews.newsLabel}"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>
