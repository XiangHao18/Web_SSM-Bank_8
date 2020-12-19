<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/22
  Time: 20:51
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
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="renderer" content="webkit">
    <meta name="applicable-device" content="pc,mobile">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title> 主 页 | 银 行 日 常 交 易 系 统 </title>
    <link type="text/css" media="all" href="<%=basePath%>static/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath%>static/js/script.js"></script>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <div class="form">
                <h1>银行日常交易系统</h1>
                <p>作者 ： 彭超 ( Silly )</p><br><br>
                <p>     本系统是基于SSM 框架搭建的银行日常交易内测系统，有着顾客开户，顾客转账，顾客查询交易记录等等实用功能。</p>
                <p>     This system is based on the SSM framework to build a daily trading system for banks, with customer functions such as account opening, customer transfer, customer inquiry transaction records, etc.</p>
                <br><br>
                <button type="submit" id="login-button" onclick="getReg()">&nbsp;注&nbsp;册&nbsp;顾&nbsp;客&nbsp;</button>
                <button type="submit" id="login-button" onclick="getLog()">&nbsp;进&nbsp;入&nbsp;系&nbsp;统&nbsp;</button>
            </div>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
</body>
</html>
