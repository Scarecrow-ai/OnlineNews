

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'content1.jsp' starting page</title>
    <link href="../css/content.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="../mainWeb/main.jsp">首页</a></li>
	    <li><a href="#">新闻管理</a></li>
	    </ul>
	</div>
	<div class="mainindex">
		<a href="../newsServlet?caozuo=queryAll">查询</a>


		<table border="1">
			<tr>
				<th>新闻ID</th><th>标题</th><th>内容</th><th>浏览次数</th><th>标签</th>
			</tr>

			<c:forEach items="${sessionScope.newsList}" var="news">
				<tr>
					<td>${news.newsId}</td>
					<td>${news.newsTitle}</td>
					<td>${news.newsText}</td>
					<td>${news.newsCount}</td>
					<td>${news.newsLabel}</td>
					<td>
						<a href="../newsServlet?caozuo=findUpdNewsid&newsID=${news.newsId}">修改</a>
						<a href="../newsServlet?caozuo=del&newsID=${news.newsId}">删除</a>
					</td>
				</tr>

			</c:forEach>
		</table>
    </div>
  </body>
</html>
