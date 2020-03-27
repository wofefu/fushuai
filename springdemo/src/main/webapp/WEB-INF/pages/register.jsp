<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/10
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <style type="text/css">
        body {
            background-image: url(${pageContext.request.contextPath}/resources/img/denglu/b96457e735102ae0fea3e7414b6853b28ac76f4d17bb4-1F44gp_fw658.jpg);
            background-size: cover;
            background-repeat: no-repeat;
        }

        .all {
            /*background-color: #5F9EA0;*/
            width: 40%;
            margin: 5% auto;
        }

        .head {
            margin: 0 auto;
            width: 80%;
            text-align: center;
            font-size: 30px;
            font-weight: 300;
            color: wheat;
        }

        .head img {
            width: 25%;
            height: 25%;
            border-radius: 60%;
            margin-top: 5%;
            margin-left: 5%;
        }
        .center input{
            height: 40px;
            width: 50%;
            margin-top: 40px;
            margin-bottom: 30px;
            text-align: center;
            margin-left: 27%;
        }
        a{
            text-decoration: none;
            color: black;
        }

    </style>
</head>

<body>
<div class="all">
    <div class="head">
        <p><img src="${pageContext.request.contextPath}/resources/img/douyu1.png"></p>
        <p>已有账号？<a href="${pageContext.request.contextPath}/public/login">立即登录</a></p>
    </div>
    <div class="center">
        <form action="${pageContext.request.contextPath}/public/register" method="post">
            <input type="text" name="username" placeholder="请输入用户名"/><br />
            <input type="text" name="password" placeholder="请输入您的密码"/><br />
            <input type="submit" value="立即注册" style="background-color: #4CCCFA; border-style: none;"/>
        </form>
    </div>
</div>
</body>
</html>
