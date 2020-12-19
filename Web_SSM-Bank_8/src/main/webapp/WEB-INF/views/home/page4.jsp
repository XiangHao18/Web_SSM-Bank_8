<%--
  Created by IntelliJ IDEA.
  User: PengChao
  Date: 2019/6/17
  Time: 9:18
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理界面</title>
    <link href="<%=basePath%>static/css/home_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.8.3.min.js"></script>
</head>
<body id="page">
<h2>账户存款</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th>银行卡号：</th><td><input type="number" name="cardId" id="cardId"></td>
    <tr/><tr>
        <th>存入金额：</th><td><input type="number" name="balance" id="balance"></td>
    <tr/><tr>
        <th>支付密码：</th><td><input type="password" name="password" id="password"></td>
    <tr/><tr>
        <th>确认密码：</th><td><input type="password" name="Tpassword" id="Tpassword"></td>
    <tr/><tr>
        <th></th><td><button type="submit" onclick="addSubmit()">提交存入</button></td>
    </tr>
</table>
<script type="text/javascript">
    function addSubmit() {
        var params = {};
        params.cardId=$("#cardId").val();
        params.balance=$("#balance").val();
        params.password=$("#password").val();
        var Tpassword = $("#Tpassword").val();
        if (Tpassword!=params.password){
            alert("两次密码不相同")
        }else {
            $.ajax({
                type: 'post',
                url: '<%=basePath%>updateAddBankcard.action',
                data: params,
                dataType: "json",
                // contentType: "application/json; charset=utf-8",
                success: function (data) {
                    alert(data.msg);
                },
                error: function (data) {
                    alert("出现异常情况，存入失败!");
                }
            })
        }
    }
</script>
</body>
</html>
