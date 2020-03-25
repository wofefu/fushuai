<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>会员管理</title>
    <style>
        table {
            text-align: center;
            width: 745px;
            height: 700px;
        }

        .Member-list-td-h2 {
            background-color: #ebebeb;
        }

        .a {
            margin: 0 auto;
            width: 1000px;
            height: 1000px;
        }

        .b {

            height: 250px;
            width: 1000px;
        }

        .c {
            height: 700px;
            width: 250px;
            background-color: cornflowerblue;
            color: white;
            font-size: 10px;
            font-weight: 300;
        }

        .cc {
            border: 1px solid white;
            height: 50px;
            width: 250px;
            text-align: center;
            line-height: 50px;
        }

        .cd {
            border-bottom: 1px dashed black;
            height: 50px;
            width: 250px;
            text-align: center;
            line-height: 50px;
        }

        .d {
            height: 750px;
            width: 700px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/gonggoong.css">
</head>
<body>
<div class="a">
    <div class="b left">
        <img src="${pageContext.request.contextPath}/resources/images/loadimg.png" height="250" width="992"
             border="1px solid green"/>
    </div>
    <div class="c left">
            <div class="cc left" id="shangpin">商品管理</div>
        <div class="cd left" id="addThing">添加商品</div>
        <div class="cd left" id="MyOrder">订单管理</div>
        <div class="cd left">会员管理</div>
        <div class="cd left">公告管理</div>
        <div class="cc left tuichu">退出后台</div>
    </div>
    <div class="d left">
        <table cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td>昵称</td>
                <td>真实姓名</td>
                <td>城市</td>
                <td>电话</td>
                <td>ID</td>
                <td>删除</td>
            </tr>

            <c:forEach items="${list}" var="member">
                <tr>
                    <td>${member.userName}</td>
                    <td>${member.trueName}</td>
                    <td>${member.city}</td>
                    <td>${member.tel}</td>
                    <td>${member.id}</td>
                    <td id="${member.id}">
                        <p class="del">删除</p>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(".del").click(
        function () {
            let id = $(this).parent().attr("id");
            alert(id);
            location.href = "remove?id=" + id;
        }
    )
    $("#MyOrder").click(
        function () {
            location.href = "MyOrder";
        })
    $("#addThing").click(
        function () {
            location.href = "addGoods";
        })
    $("#shangpin").click(function () {
        location.href = "selectGoods";
    })
    $(".tuichu").click(function () {
        location.href = "index";
    })
</script>
</html>
