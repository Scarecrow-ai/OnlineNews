<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/3
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet?caozuo=upd&userID=${sessionScope.selectuser.userId}" method="post">
  用户名: <input type="text" name="userName" value="${sessionScope.selectuser.userName}"><br>
    密码：<input type="text" name="userPWD" value="${sessionScope.selectuser.userPwd}"><br>
    电话：<input type="text" name="userPhone" value="${sessionScope.selectuser.userPhone}"><br>
    邮箱：<input type="text" name="userEmail" value="${sessionScope.selectuser.userEmail}"><br>
 头像地址：<input type="text" name="userImg" value="${sessionScope.selectuser.userImg}"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>
