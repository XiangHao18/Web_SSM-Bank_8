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
        #searchForm input {
            height:20px;
            font-size:12px;
            padding:0;
        }
    </style>
</head>
<body id="page">
<h2>添加学生</h2>
<form id="searchForm" action="findTransactionAll.action" method="post">
    银行卡号：
    <input name="cardId" type="text" size="19" />
    <input name="Submit" type="submit" class="bt" value="查询" />
</form>
<table id="iboxs" width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th>编号</th>
        <th>银行卡号</th>
        <th>交易日期</th>
        <th>交易类型</th>
        <th>交易金额</th>
        <th>备注信息</th>
    </tr>
    <c:forEach var="list" items="${sessionScope.Tlist}" varStatus="len">
        <tr>
            <td>${len.count}</td>
            <td>${list.cardId}</td>
            <td><fmt:formatDate value="${list.transanctionDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${list.transanctionType}</td>
            <td>${list.transanctionPay}</td>
            <td>${list.remarks}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
