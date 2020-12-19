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
    <style type="text/css">
        #searchForm {
            background:url(<%=basePath%>../images/searchBg.gif) #FFFFCC no-repeat right center;
            border:1px dotted #CCC;
            margin:8px;
            padding:8px;
        }
    </style>
</head>
<body id="page">
<h2>银行转账</h2>
<form id="searchForm">
    汇率公告：1.00美元≈6.00人民币，不同卡之间转账系统会自动转换汇率。
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th>银行卡号：</th><td><input type="number" name="cardId" id="cardId"></td>
    <tr/><tr>
        <th>转账卡号：</th><td><input type="number" name="TcardId" id="TcardId"></td>
    <tr/><tr>
        <th>转账金额：</th><td><input type="number" name="Tmoney" id="Tmoney"></td>
    <tr/><tr>
        <th>支付密码：</th><td><input type="password" name="password" id="password"></td>
    <tr/><tr>
        <th>确认密码：</th><td><input type="password" name="Tpassword" id="Tpassword"></td>
    <tr/><tr>
        <th></th><td><button type="submit" onclick="addSubmit()">提交转账</button></td>
    </tr>
</table>
<script type="text/javascript">
    function addSubmit() {
        var params = {};
        params.cardId=$("#cardId").val();
        params.password=$("#password").val();
        var Tpassword=$("#Tpassword").val();
        var Tmoney=$("#Tmoney").val();
        var TcardId=$("#TcardId").val();
        if (params.password!=Tpassword){
            alert("两次密码不相同")
        }else {
            $.ajax({
                type: 'post',
                url: '<%=basePath%>findBankcard.action',
                data: params,
                dataType: "json",
                // contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (data.password != params.password){
                        alert("密码错误！")
                    } else if (data.balance < Tmoney) {
                        alert("余额不足！")
                    } else {
                        $.ajax({
                            type: 'post',
                            url: '<%=basePath%>Transfer.action',
                            data: {"cardId":params.cardId,"Tmoney":Tmoney,"TcardId":TcardId},
                            dataType: "json",
                            // contentType: "application/json; charset=utf-8",
                            success: function (data) {
                                if (data.msg == true) {
                                    alert("转账成功！")
                                } else {
                                    alert("转账失败！")
                                }
                            },
                            error: function (data) {
                                alert("出现异常情况，转账失败!");
                            }
                        })
                    }
                },
                error: function (data) {
                    alert("出现异常情况，转账失败!!");
                }
            })
        }
    }
</script>
</body>
</html>
