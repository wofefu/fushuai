<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品添加</title>
</head>
<body>
<form action="addGood" method="post">
    <p>类型ID:<input type="text" name="typeid"></p>
    <p>产品名称:<input type="text" name="goodsname"></p>
    <p>产品描述:<input type="text" name="introduce"></p>
    <p>原始价格:<input type="text" name="price"></p>
    <p>最新价格:<input type="text" name="nowprice"></p>
    <p>图片:<input type="text" name="picture"></p>
    <p>添加时间:<input type="text" name="intime"></p>
    <p>是否是最新商品:<input type="text" name="newgoods"></p>
    <p>
        <input type="button" value="保存" onclick="Regist()">
    </p>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    function Regist() {
        $("form").submit();
    }
</script>
</html>
