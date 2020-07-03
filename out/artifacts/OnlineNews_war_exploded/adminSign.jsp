<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/2
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- font files  -->
    <link href='http://fonts.useso.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
    <!-- /font files  -->
    <!-- css files -->
    <link href="css/index2.css" rel='stylesheet' type='text/css' media="all" />
    <!-- /css files -->
</head>
<body>
<h1>后&nbsp台&nbsp信&nbsp息&nbsp管&nbsp理</h1>

<div class="content1">
    <h2>登&nbsp&nbsp&nbsp&nbsp录</h2>
    <form action="admin" method="POST" >
        <input type="text" name="adminId" placeholder="请输入管理员账号">
        <input type="password" name="password" placeholder="请输入管理员密码">
        <div class="button-row">
            <input type="submit" class="sign-in" value="登录">
            <input type="button" class="reset" value="修改">
            <div class="clear"></div>
        </div>
    </form>
</div>
<div class="clear"></div>

<div class="footer">

</div>

</body>
</html>