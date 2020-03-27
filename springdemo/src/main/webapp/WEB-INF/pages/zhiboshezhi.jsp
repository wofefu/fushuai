<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/17
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置属于自己的直播样式</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/all/zhiboshezhi"
      method="post" enctype="multipart/form-data">
    房间标题：<input type="text" name="title"><br>
    房间背景图： <input type="file" name="file"><br>
    <input type="submit" value="开播">
</form>
</body>
</html>
