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
    <title> 注 册 | 银 行 日 常 交 易 系 统</title>
    <link type="text/css" media="all" href="<%=basePath%>static/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <div class="form">
                <h1>注&nbsp;册&nbsp;顾&nbsp;客</h1>
                <p>顾&nbsp;客&nbsp;姓&nbsp;名<input type="text" id="custName" name="custName"/></p>
                <p>身&nbsp;份&nbsp;证&nbsp;号<input type="number" id="custPid" name="custPid"/></p>
                <p>电&nbsp;话&nbsp;号&nbsp;码<input type="number" id="custTel" name="custTel"/></p>
                <p>家&nbsp;庭&nbsp;地&nbsp;址<input type="text" id="custAddress" name="custAddress"/></p>
                <button type="submit" id="login-button" onclick="regSubmit()">&nbsp;提&nbsp;交&nbsp;注&nbsp;册&nbsp;&nbsp;</button>
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
    function regSubmit() {
        var params = {};
        params.custName=$("#custName").val();
        params.custPid=$("#custPid").val();
        params.custTel=$("#custTel").val();
        params.custAddress=$("#custAddress").val();
        $.ajax({
            type:'post',
            url:'<%=basePath%>regist.action',
            data:params,
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                if (data!=null) {
                    alert("注册成功!");
                    window.location.href = "<%=basePath%>getLog.action"
                }else{
                    alert("出现异常情况，注册顾客失败!");
                }
            },
            error:function(data){
                alert("出现异常情况，注册顾客失败!");
            }
        })
    }
</script>
</html>
