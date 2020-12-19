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
<h2>修改顾客信息</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th>编号</th><td>&nbsp;<input type="number" readonly="true" name="custId" id="custId" value="${sessionScope.customer.custId}"/></td>
    </tr>
    <tr>
        <th>顾客姓名</th><td>&nbsp;<input type="text" name="custName" id="custName" value="${sessionScope.customer.custName}"/></td>
    </tr>
    <tr>
        <th>身份证号</th><td>&nbsp;<input type="number" name="custPid" readonly="true" id="custPid" value="${sessionScope.customer.custPid}"/></td>
    </tr>
    <tr>
        <th>电话号码</th><td>&nbsp;<input type="number" name="custTel" id="custTel" value="${sessionScope.customer.custTel}"></td>
    </tr>
    <tr>
        <th>家庭地址</th><td>&nbsp;<textarea name="custAddress" id="custAddress" style="width:300px;height:80px;">${sessionScope.customer.custAddress}</textarea></td>
    </tr>
    <tr>
        <th></th><td>&nbsp;<button type="submit" onclick="addSubmit()">修改</button></td>
    </tr>
</table>
<script type="text/javascript">
    function addSubmit() {
        var params = {};
        params.custId=$("#custId").val();
        params.custName=$("#custName").val();
        params.custPid=$("#custPid").val();
        params.custTel=$("#custTel").val();
        params.custAddress=$("#custAddress").val();
        $.ajax({
            type:'post',
            url:'<%=basePath%>update.action',
            data:params,
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                window.location.href="<%=basePath%>getSiteInfo.action"
            },
            error:function(data){
                alert("出现异常情况，修改顾客信息失败!");
            }
        })
    }
</script>
</body>
</html>
