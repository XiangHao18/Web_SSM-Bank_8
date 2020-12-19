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
    <script type="text/javascript" src="<%=basePath%>static/js/script.js"></script>
</head>
<body id="page">
<h2>银行开户</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <th>银行卡号:</th><td>&nbsp;<span>系统默认生成</span></td>
    </tr>
    <tr>
        <th>顾客编号:</th><td>&nbsp;<input type="text" readonly="true" name="custId" id="custId" value="${sessionScope.customer.custId}"/></td>
    </tr>
    <tr>
        <th>开户时间:</th><td>&nbsp;<span>默认为当前时间</span></td>
    </tr>
    <tr>
        <th>开户金额:</th><td>&nbsp;<input type="number" name="createMoney" id="createMoney"></td>
    </tr>
    <tr>
        <th>货币类型:</th>
        <td>&nbsp;
            <select id="currencyType" >
            <option>人民币</option>
            <option>美元</option>
        </select>
        </td>
    </tr>
    <tr>
        <th>存款类型:</th>
        <td>&nbsp;
            <select id="depositType" >
                <option>存蓄卡</option>
                <option>借记卡</option>
            </select>
        </td>
    </tr>
    <tr>
        <th>支付密码:</th><td>&nbsp;<input type="password" name="password" id="password"></td>
    </tr>
    <tr>
        <th></th><td>&nbsp;<button type="submit" onclick="addSubmit()">提交开户</button></td>
    </tr>
</table>
<script type="text/javascript">
    function addSubmit() {
        var d = new Date();
        var params = {};
        //params.cardId=$("#cardId").val();  后台随机生成
        params.custId=$("#custId").val();
        params.createDate=new Date(d.getTime() - d.getTimezoneOffset() * 60000).toISOString().replace("T", " ").replace(/\..+$/,"");
        params.createMoney=$("#createMoney").val();
        params.currencyType=$("#currencyType").val();
        params.depositType=$("#depositType").val();
        params.balance=params.createMoney;
        params.password=$("#password").val();
        params.reportLoss="0";//0为不挂失1为挂失
        $.ajax({
            type:'post',
            url:'<%=basePath%>insertBankcard.action',
            data:params,
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                if (data!=null) {
                    alert("您银行卡号为："+data.cardId);
                    window.location.href = "<%=basePath%>getSiteInfo.action"
                }else{
                    alert("出现异常情况，开户失败!");
                }
            },
            error:function(data){
                alert("出现异常情况，开户失败!");
            }
        })
    }
</script>
</body>
</html>
