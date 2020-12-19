<%--
  Created by IntelliJ IDEA.
  User: PengChao
  Date: 2019/6/20
  Time: 12:46
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
</head>
<body id="page">
<h2>系统信息</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th><p>操作成功！</p>
            <p>
                <input name="Submit" type="button" class="bt" value="返回" onclick="history.go(-1);"/>
            </p></th>
    </tr>
</table>
</body>
</html>
