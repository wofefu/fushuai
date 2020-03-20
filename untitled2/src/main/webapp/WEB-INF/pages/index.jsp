<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/6 0006
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我是一个jsp页面 我被拿来充当视图</h1>
<button onclick="alert('就问你6不6?')">我这个按钮的存在 意味着这是一个页面 而不是方法映射返回字符串了 </button>
<h3>姓名:${requestScope.name}</h3>
<h3>年龄:${requestScope.age}</h3>
<h3>地址:${requestScope.add}</h3>
</body>
</html>
