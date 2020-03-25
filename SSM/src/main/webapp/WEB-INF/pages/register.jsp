<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <link  href="${pageContext.request.contextPath}/resources/css/base.css" rel="stylesheet">
    <link  href="${pageContext.request.contextPath}/resources/css/register.css" rel="stylesheet">
</head>
<body>
<header id="headNav">
    <div class="innerNav clear">
        <a class="fl" href="#"><img src="${pageContext.request.contextPath}/resources/images/loginlogo.png" alt=""></a>

        <div class="headFont fr">
            <span>您好，欢迎光临FS会员商城！<a href="login">请登录</a></span>
            <a class="helpLink" href="#"><i class="runbun"></i>帮助中心<i class="turnb"></i></a>
        </div>
        <div class="outHelp">
            <ul class="helpYou" style="display: none;">
                <li><a href="#">包裹跟踪</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">在线退换货</a></li>
                <li><a href="#">在线投诉</a></li>
                <li><a href="#">配送范围</a></li>
            </ul>
        </div>
    </div>
</header>
<section id="secTab">
    <div class="innerTab">
        <h2>FS会员商城注册</h2>
        <form action="register" method="post">
            <div class="tableItem">
                <span class="userPhone">用户名</span>
                <input type="text" placeholder="用户名" name="userName"/>
            </div>
            <div class="tableItem">
                <span class="userPhone">真实姓名</span>
                <input type="text" placeholder="真实姓名" name="trueName">
            </div>
            <div class="tableItem">
                <span class="setPass">设置密码</span>
                <input type="passWord" placeholder="密码" name="passWord"/>
            </div>
            <div class="tableItem">
                <span class="userPhone">城市</span>
                <input type="text" placeholder="城市" name="city"/>
            </div>
            <div class="tableItem">
                <span class="userPhone">具体地址</span>
                <input type="text" placeholder="具体地址" name="address"/>
            </div>
            <div class="tableItem">
                <span class="userPhone">手机号</span>
                <input type="text" placeholder="手机号" name="tel"/>
            </div>
            <div class="tableItem">
                <span class="carNo">身份证号</span>
                <input type="text" placeholder="身份证号" name="carNo"/>
            </div>
            <p class="clickRegist">点击注册，表示您同意FS会员商城 <a href="#">《服务协议》</a></p>
            <input class="tableBtn" type="submit" value="同意协议并注册">
            <!--<button class="tableBtn">同意协议并注册</button>-->
        </form>
    </div>
</section>
<footer id="footNav">
    <div class="foot_div">
        <p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
    </div>
    <p>Copyright © FS会员商城 2019-2020，All Rights Reserved</p>
</footer>
</body>
</html>
