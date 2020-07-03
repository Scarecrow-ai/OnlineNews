<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	    <li><a href="#">用户管理</a></li>
	    </ul>
	</div>
	<div class="mainindex">
		<a href="../userServlet?caozuo=queryAll">查询</a>
		<a href="../addUser.html">添加</a>



		<table border="1">
			<tr>
				<th>ID</th><th>用户名</th><th>密码</th><th>电话</th><th>邮箱</th><th>头像地址</th>
			</tr>

			<c:forEach items="${sessionScope.userList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.userPwd}</td>
					<td>${user.userPhone}</td>
					<td>${user.userEmail}</td>
					<td>${user.userImg}</td>
					<td>
						<a href="../userServlet?caozuo=findUpdUserid&userID=${user.userId}">修改</a>
						<a href="../userServlet?caozuo=del&userID=${user.userId}">删除</a>
					</td>
				</tr>

			</c:forEach>
		</table>
    </div>
  </body>
</html>
