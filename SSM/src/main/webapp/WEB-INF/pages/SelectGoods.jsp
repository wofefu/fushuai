<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>商品详情</title>
    <style>
        table{
            text-align: center;
            width: 745px;
            height:700px;
        }
        .Member-list-td-h2{
            background-color: #ebebeb;
        }
        .a{
            margin: 0 auto;
            width: 1000px;
            height: 1000px;
        }
        .b{

            height: 250px;
            width: 1000px;
        }
        .c{

            height: 700px;
            width: 250px;
            background-color:cornflowerblue;
            color: white;
            font-size: 10px;
            font-weight: 300;
        }
        .cc{
            border: 1px solid white;
            height: 50px;
            width: 250px;
            text-align: center;
            line-height: 50px;
        }
        .cd{
            border-bottom:1px dashed black;
            height: 50px;
            width: 250px;
            text-align: center;
            line-height: 50px;
        }
        .d{
            height: 750px;
            width: 745px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/gonggoong.css">
</head>
<body>
<div class="a">
    <div class="b left">
        <img src="${pageContext.request.contextPath}/resources/images/loadimg.png" height="250" width="992" border="1px solid green"/>
    </div>
    <div class="c left">
        <div class="cc left" id="shangpin">商品管理</div>
        <div class="cd left" id="addThing">添加商品</div>
        <div class="cd left" id="MyOrder">订单管理</div>
        <div class="cd left" id="vip">会员管理</div>
        <div class="cd left">公告管理</div>
        <div class="cc left tuichu">退出后台</div>
    </div>
    <div class="d left">
        <table cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td>类型ID</td>
                <td>商品名</td>
                <td>产品描述</td>
                <td>原始价格</td>
                <td>最新价格</td>
                <td>删除</td>
            </tr>

                <c:forEach var="Goods" items="${requestScope.list}">
            <tr>
                    <td>${Goods.typeid}</td>
                    <td>${Goods.goodsname}</td>
                    <td>${Goods.introduce}</td>
                    <td>${Goods.price}</td>
                    <td>${Goods.nowprice}</td>
                    <td id="${Goods.id}">
                        <p class="del">删除</p>
                    </td>
            </tr>
                </c:forEach>

        </table>
        <!--<div th:include="/page :: mypage"></div>-->
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(".del").click(
        function () {
            let id=$(this).parent().attr("id");
            alert(id);
            location.href="removeGoods?id="+id;
        }
    )
    $("#addThing").click(
        function () {
            location.href="addGoods";
        })
    $("#shangpin").click(function () {
        location.href="selectGoods";
    })
    $("#vip").click(
        function () {
            location.href="userlist";
        }
    )
    $("#MyOrder").click(
        function () {
            location.href="MyOrder";
        }
    )
    $(".tuichu").click(function () {
        location.href="index";
    })
</script>
</html>
