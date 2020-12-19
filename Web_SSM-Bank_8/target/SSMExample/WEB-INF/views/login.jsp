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
    <title> 登 录 | 银 行 日 常 交 易 系 统 </title>
    <link type="text/css" media="all" href="<%=basePath%>static/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        if (window != top)
            top.location.href = location.href;
    </script>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <div class="form">
                <h1>系&nbsp;统&nbsp;登&nbsp;录</h1>
                <br><br><br>
                <p>请 输 入 身 份 证 号 码<input type="number" id="custPid" name="custPid"/></p>
                <button type="submit" id="login-button" onclick="logSubmit()">&nbsp;登&nbsp;录&nbsp;系&nbsp;统&nbsp;</button>
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
<script type="text/javascript">
    function logSubmit() {
        var custPid=$("#custPid").val();
        $.ajax({
            type:'post',
            url:'<%=basePath%>login.action',
            data:"custPid="+custPid,
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                if (data.custPid==custPid) 
                    window.location.href="<%=basePath%>getHome.action";
                else alert("身份证错误，或者不存在！");
            },
            error:function(data){
                alert("出现异常情况，登录失败!");
            }
        })
    }
</script>
</html>
