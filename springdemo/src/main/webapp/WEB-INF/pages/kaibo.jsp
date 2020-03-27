<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/16
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开播实名认证</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/kaibo" method="post">
    昵称：<input type="text" name="anchorName"><br>
    姓名：<input type="text" name="name"><br>
    手机号：<input type="text" name="phone"><br>
    身份证号：<input type="text" name="idcard"><br>
    <input type="submit">
</form>
</body>
</html>
