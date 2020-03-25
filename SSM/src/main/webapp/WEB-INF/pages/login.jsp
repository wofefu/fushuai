<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/load.css">
</head>
<body>
<header id="headNav">
    <div class="innerNav clear">
        <a class="fl" href="#"><img src="${pageContext.request.contextPath}/resources/images/loginlogo.png" alt=""/></a>
        <div class="headFont fr">
            <span>您好，欢迎光临FS会员商城！<a href="#">请登录</a></span>
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
<section id="secBody">
    <div class="innerBody clear">
        <img class="fl" src="${pageContext.request.contextPath}/resources/images/loadimg.png" height="500" width="500"/>
        <div class="tableWrap fr">
            <form action="login" method="post">
                <div class="tableTap clear">
                    <h3 class="fl">FS会员商城登录</h3>
                    <a class="fr" href="${pageContext.request.contextPath}/register">注册账号</a>
                </div>
                <div class="tableItem">
                    <i class="userHead"></i>
                    <input type="text" placeholder="手机号" name="tel" required />
                </div>
                <div class="tableItem">
                    <i class="userLock"></i>
                    <input type="password" placeholder="密码" name="password" required/>
                </div>
                <div class="tableAuto clear">
                    <a class="autoMatic fl" href="#">
                        <input class="loadGiet"  type="checkbox"/>自动登录</a>
                    <a class="fr" href="#">忘记密码？</a>
                </div>
                <input type="submit" class="tableBtn" value="登录">
            </form>
            <h2 class="moreWeb">更多合作网站账号登录</h2>
            <div class="outType clear">
                <ul class="loadType clear">
                    <li class="fl"><a href="#"></a></li>
                    <li class="fl"><a href="#"></a></li>
                    <li class="fl"><a href="#"></a></li>
                    <li class="fl"><a href="#"></a></li>
                    <li class="loadMore fr">更多合作网站<i></i></li>
                </ul>
            </div>
            <ul class="typeWeb clear">
                <li class="fl"><i></i><a href="#">百度</a></li>
                <li class="fl"><i></i><a href="#">百度</a></li>
                <li class="fl"><i></i><a href="#">百度</a></li>
                <li class="fl"><i></i><a href="#">百度</a></li>
                <li class="fl"><i></i><a href="#">百度</a></li>
            </ul>
        </div>
    </div>
</section>
<footer id="footNav">
    <p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
    <p>Copyright © FS会员商城 2019-2020，All Rights Reserved</p>
</footer>
</body>
</html>
