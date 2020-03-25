<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/personal.css">
</head>

<body>
<div class="header">
    <div>
        <span>${sessionScope.user.userName}</span>
    </div>

    <div class="logout"><span onclick="location.href='index'">首页</span><span onclick="location.href='logout'">注销</span>
    </div>
</div>

<div class="main">
    <div class="aside">
        <div class="menu active"><span>个人资料</span>
        </div>
        <div class="menu">
            <span onclick="MyOrder()">我的订单</span>
        </div>
        <div class="menu">
            <span onclick="shoppingCar()">我的购物车</span>
        </div>
    </div>

    <div class="editarea">
        <form action="${pageContext.request.contextPath}/update" method="post">
            <div class="info-item" style="margin-top: 40px">
                <span>昵称</span>
                <input type="text" name="username" value="${sessionScope.user.userName}">

            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>真实姓名</span>
                <input type="text" name="truename" value="${sessionScope.user.trueName}">
            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>密码</span>
                <input type="text" name="password" value="${sessionScope.user.passWord}">
            </div>
            <div class="info-item" style="display: none">
                <span>id</span>
                <input type="text" name="id" value="${sessionScope.user.id}">
            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>电话</span>
                <input type="text" name="tel" value="${sessionScope.user.tel}">
            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>身份证号</span>
                <input type="text" name="carno" value="${sessionScope.user.carNo}">
            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>城市</span>
                <input type="text" name="city" value="${sessionScope.user.city}">

            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>地址</span>
                <input type="text" value="${sessionScope.user.address}" name="address">
            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>邮箱</span>
                <input type="text" value="${sessionScope.user.email}" name="email">
            </div>
            <div class="info-item" style="margin-top: 40px">

                <button id="update">提交修改</button>
                <div>
                    ${requestScope.msg}
                </div>
            </div>
        </form>
    </div>


</div>
</body>
<script>function shoppingCar() {
    location.href = "shopcar";
}

function MyOrder() {
    location.href = "shopcarsettle";
}

</script>
</html>
