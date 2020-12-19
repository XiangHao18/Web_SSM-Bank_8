<%--
  Created by IntelliJ IDEA.
  User: PengChao
  Date: 2019/6/20
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>管理界面</title>
    <link href="<%=basePath%>static/css/home_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>static/js/script.js"></script>
</head>

<body id="index">
<h1>银行日常交易系统主界面</h1>
<div id="userInfo">你好，顾客：${sessionScope.customer.custName},欢迎使用本银行系统！</div>
<ul id="globalNav">
    <h2>管理菜单</h2>
    <li><a href="getPage1.action" target="frameBord">开户</a></li>
    <li><a href="getPage2.action" target="frameBord">银行卡</a></li>
    <li><a href="getPage3.action" target="frameBord">账户转账</a></li>
    <li><a href="getPage4.action" target="frameBord">账户存款</a></li>
    <li><a href="getPage5.action" target="frameBord">账户取款</a></li>
    <li><a href="getPage6.action" target="frameBord">交易记录</a></li>
    <li><a href="getPage7.action" target="frameBord">顾客信息</a></li>
    <li><a href="logout.action">安全退出</a></li>
</ul>
<iframe id="frameBord" name="frameBord" frameborder="0" width="100%" height="100%" src="<%=basePath%>getPage7.action"></iframe>
</body>
</html>
