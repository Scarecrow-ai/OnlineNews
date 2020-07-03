<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'left.jsp' starting page</title>
    <script language="JavaScript" src="../js/jquery.js"></script>
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript">
        $(function () {
            //导航颜色切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active");
                $(this).addClass("active");
            });
            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
            //------------------
        });
    </script>
</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>
<dl class="leftmenu">
    <dd>
        <div class="title">
            <span><img src="../images2/leftico01.png"/></span>管理信息
        </div>
        <ul class="menuson">
            <!-- 在li标签里面添加（class="active"）会变为选中 -->
            <li><cite></cite><a href="../content/content1.jsp" target="rightFrame">用户管理</a><i></i></li>
            <li><cite></cite><a href="../content/content2.jsp" target="rightFrame">新闻管理</a><i></i></li>
            <li><cite></cite><a href="../content/content3.jsp" target="rightFrame">后台统计</a><i></i></li>

        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="../images2/leftico02.png"/></span>其他设置
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <l><cite></cite><a href="#">二级菜单</a><i></i></l>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="../images2/leftico03.png"/></span>编辑器
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="../images2/leftico04.png"/></span>日期管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
            <li><cite></cite><a href="#">二级菜单</a><i></i></li>
        </ul>
    </dd>
</dl>
</body>
</html>
