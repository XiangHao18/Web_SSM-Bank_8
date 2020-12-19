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
        .card{
            font-family: Georgia;
            width: 400px;
            height: 240px;
            background-color:#53e3a6;
            margin-top: 5%;
            margin-left: 8%;
            margin-right: 4%;
            float: left;
            border-radius:5px 5px 0 0;
        }
        .card strong{
            padding-top: 20px ;
            padding-left: 20px;
            font-size:40px;
        }
        .card_content{
            padding-left: 20px;
            padding-right: 20px;
            width: 330px;
            height: 150px;
            font-size: 20px;
            float: right;
        }
        .card_content span a{
            width: 400px;
            height: 30px;
            float: right;
            font-family: STHeiti;
        }
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
<h2>全部银行卡</h2>
<form id="searchForm">
    挂失银行卡号：
    <input name="cardId" id="cardId" type="text" size="19" />
    <input name="Submit" type="submit" class="bt"  onclick="reportLossBankcard()" value="挂失" />
</form>
<div id="box"></div>
<script type="text/javascript">
    function reportLossBankcard(){
        $.ajax({
            type:'post',
            url:'<%=basePath%>reportLossBankcard.action',
            data:"cardId="+$("#cardId").val(),
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                if (data!=null) {
                    window.location.href = "<%=basePath%>getPage2.action"
                }else{
                    alert("挂失银行卡失败!");
                }
            },
            error:function(data){
                alert("出现异常情况，挂失银行卡失败!");
            }
        })
    }

    $(function () {
        $.post("findBankcardAll.action?custId="+${sessionScope.customer.custId}, function (data) {
            var prows = "";
            var type = "";
            for (var i = 0; i < data.length; i++) {
                if (data[i].currencyType=="人民币") type="￥";
                if (data[i].currencyType=="美元") type="$";

                var d = new Date(data[i].createDate);
                var newDate = new Date(d.getTime() - d.getTimezoneOffset() * 60000).toISOString().replace("T", " ").replace(/\..+$/,"");
                prows += "<div class='card'>\n" +
                    "        <strong>"+data[i].depositType+"</strong>\n" +
                    "        <div class='card_content'>\n" +
                    "            <br><br>\n" +
                    "            <p>CardID :"+data[i].cardId+"</p>\n" +
                    "            <p>CreateTime :"+newDate+"</p>\n" +
                    "            <p>Balance :"+data[i].balance+type+"</p>\n" +
                    "            <p>Owner :${sessionScope.customer.custName}</p>\n" +
                    "        </div>\n" +
                    "        <span><a href='#' onclick='+delSubmit(\""+data[i].cardId+"\",\""+data[i].custId+"\");'>Delete This Card</a></span>\n" +
                    "    </div>";
            }
            $("#box").append(prows);
        })
    })
    function delSubmit(cardId,custId) {
        var params = {};
        params.cardId=cardId.toString();
        params.custId=custId;
        $.ajax({
            type:'post',
            url:'<%=basePath%>deleteBankcard.action',
            data:params,
            dataType:"json",
            // contentType: "application/json; charset=utf-8",
            success:function (data) {
                alert(data.msg);
                window.location.href="<%=basePath%>getPage2.action"
            },
            error:function(data){
                alert("出现异常情况，删除银行卡失败!");
            }
        })
    }
</script>
</body>
</html>
