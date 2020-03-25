<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/22
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册失败</title>
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        a:hover{
            color: #b01d1d;
        }
    </style>
</head>
<body>
<h1>实名认证未通过</h1>
<p>请重新<a href="${pageContext.request.contextPath}/register">注册</a></p>
</body>
</html>
