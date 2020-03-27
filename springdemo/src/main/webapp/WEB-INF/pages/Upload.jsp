<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/10
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Upload"
      method="post" enctype="multipart/form-data">
    <input type="text" name="name"><br>
    <input type="file" name="files"><br>
    <input type="file" name="files"><br>
    <input type="file" name="files"><br>
    <input type="submit">

</form>
</body>
</html>
