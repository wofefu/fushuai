<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到FS会员商城</title>
    <link rel="stylesheet" href="resources/css/public2.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>

<body>
<!--网页头部-->
<div class="header">
    <div class="header_top">
        <div class="header_top_left">
            <span>送货至：全国</span>
        </div>
        <div class="header_top_right">
            <div class="r1">你好！
               <c:choose>
                   <c:when test="${sessionScope.user.userName==null}">
                         <span>请<a href="login">登录</a>&nbsp;<a href="register"
                                                               style="color: #FF3C3C">免费注册</a>&nbsp;&nbsp;</span>
                   </c:when>
                   <c:otherwise>
                       ${sessionScope.user.userName}
                       |&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/personal">个人中心</a>&nbsp;&nbsp;|&nbsp;&nbsp
                   </c:otherwise>
               </c:choose>

            </div>
            <ul>
                <li class="one"><a href="#">收藏夹</a></li>
                <li class="two">
                    <a href="#">客户服务</a>
                    <div class="fuwu">
                        <div>意见反馈</div>
                        <div>在线客服</div>
                        <div>商家合作</div>
                    </div>
                </li>
                <li class="three"><a href="#">网站导航</a></li>
            </ul>
            <span>&nbsp;|&nbsp;&nbsp;<a href="#">关注我们</a></span>
            <span class="topimg"><img src="resources/images/index/sh1.png" alt="">
                    <img src="resources/images/index/sh2.png"></span>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <span class="phone">手机版<img src="resources/images/index/s_tel.png"></span>
        </div>
    </div>
    <div class="header_sou">
        <div class="onedayshop"><a href="#"><img src="resources/images/loginlogo.png" width="210px" height="72px"
                                                 alt=""></a>
        </div>
        <div class="sousuo">
            <form action="#">
                <input type="search" placeholder="请输入关键字">
                <input type="submit" value="搜 索">
            </form>
            <div class="ss">
                <a href="#">咖啡</a>
                <a href="#">iphone 6S</a>
                <a href="#">新鲜美食</a>
                <a href="#">蛋糕</a>
                <a href="#">日用品</a>
                <a href="#">连衣裙</a>
            </div>
        </div>
        <div class="shoppingcart">
            <div class="cart"><a href="shopcar">购物车</a></div>
        </div>
    </div>
</div>
<!--网页中间部分-->
<div class="section">
    <!--商品分类、轮播图快讯-->
    <div class="section_top">
        <div class="menu">
            <div class="left">
                <div class="classify">全部商品分类</div>
                <div class="left_nav">
                    <ul>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav1.png"></span>
                                <span class="f1">进口食品、生鲜</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav2.png"></span>
                                <span class="f1">食品、饮料、酒</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav3.png"></span>
                                <span class="f1">母婴、玩具、童装</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav4.png"></span>
                                <span class="f1">家居、家庭清洁、纸品</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav5.png"></span>
                                <span class="f1">美妆、个人护理、洗护</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav6.png"></span>
                                <span class="f1">女装、内衣、中老年</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav7.png"></span>
                                <span class="f1">鞋靴、箱包、腕表配饰</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav8.png" alt=""></span>
                                <span class="f1">男装、运动</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav9.png"></span>
                                <span class="f1">手机、小家电、电脑</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="resources/images/index/nav10.png" alt=""></span>
                                <span class="f1">礼品、充值</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="div_menu">
                    <ul class="menu_right">
                        <li><a href="#" style="color: #FF3C3C">首页</a></li>
                        <li><a href="#" style="color: #FF3C3C">自营超市</a></li>
                        <li><a href="#">1号团</a></li>
                        <li><a href="#">1号超市</a></li>
                        <li><a href="#">女装</a></li>
                        <li><a href="#">美妆</a></li>
                        <li><a href="#">1号海购</a></li>
                        <li><a href="#">团购</a></li>
                    </ul>
                </div>
                <a href="#" class="right_img"><img src="resources/images/index/phone.png"></a>
            </div>
        </div>
        <div class="slideshow">
            <div class="slideshow_img">
                <img src="resources/images/index/ban1.jpg" width="740" height="401">
                <a href="#" class="img_leftbi"></a>
                <a href="#" class="img_righttbi"></a>
            </div>
            <ul class="num">
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
            </ul>

        </div>
        <div class="newslist">
            <div class="news_head">
                <h3>快讯</h3>
                <span><a href="#">更多 ></a></span>
            </div>
            <ul>
                <li><span>【特惠】</span><a href="#">掬一轮明月 表无尽惦念</a></li>
                <li><span>【公告】</span><a href="#">好奇金装成长裤新品上市</a></li>
                <li><span>【特惠】</span><a href="#">大牌闪购 · 抢！</a></li>
                <li><span>【公告】</span><a href="#">发福利 买车就抢千元油卡</a></li>
                <li><span>【公告】</span><a href="#">家电低至五折</a></li>
            </ul>
            <div class="moneybao">
                <h3>1号钱包</h3>
                <p>收益日结，收益赚High！</p>
                <img src="resources/images/index/oneAD.jpg" alt=""/>
            </div>
        </div>
    </div>
    <div class="hostmai">
        <div class="hostmai_left">
            <img src="resources/images/index/l_img.jpg" alt="">
            <div class="text_centent">
                <span class="price">￥53.00</span>
                <span class="fr">16R</span>
            </div>
        </div>
        <div class="hostmai_right">
            <ul class="hostmai_right_ul">
                <li>
                    <div class="left_top">
                        <img src="resources/images/index/hot.png" alt="">
                    </div>
                    <div class="content_img">
                        <img src="resources/images/index/hot1.jpg" width="160" height="136">
                    </div>
                    <div class="name">
                        <a href="#">
                            <h2>德国进口</h2>
                            德亚全脂纯牛奶200ml*48盒
                        </a>
                    </div>
                    <div class="ul_price">
                        <strong>￥<span>189</span></strong> &nbsp; <span class="r">26R</span>
                    </div>
                </li>
                <li>
                    <div class="left_top">
                        <img src="resources/images/index/hot.png" alt="">
                    </div>
                    <div class="content_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/p_big.jpg" width="260"
                             height="136">
                    </div>
                    <div class="name">
                        <a href="detailPage?id=1">
                            <h2>冰韵</h2>
                            天然白色正圆S925银扣珍珠项链
                        </a>
                    </div>
                    <div class="ul_price">
                        <strong>￥<span>3886</span></strong> &nbsp; <span class="r">25R</span>
                    </div>
                </li>
                <li>
                    <div class="left_top">
                        <img src="resources/images/index/hot.png" alt="">
                    </div>
                    <div class="content_img">
                        <img src="resources/images/index/hot3.jpg" width="160" height="136">
                    </div>
                    <div class="name">
                        <a href="#">
                            <h2>倩碧特惠组合套装</h2>
                            倩碧补水组合套装8折促销
                        </a>
                    </div>
                    <div class="ul_price">
                        <strong>￥<span>368</span></strong> &nbsp; <span class="r">18R</span>
                    </div>
                </li>
                <li>
                    <div class="left_top">
                        <img src="resources/images/index/hot.png" alt="">
                    </div>
                    <div class="content_img">
                        <img src="resources/images/index/hot4.jpg" width="160" height="136">
                    </div>
                    <div class="name">
                        <a href="#">
                            <h2>品利特级橄榄油</h2>
                            750ml*4瓶装组合 西班牙原装进口
                        </a>
                    </div>
                    <div class="ul_price">
                        <strong>￥<span>280</span></strong> &nbsp; <span class="r">30R</span>
                    </div>
                </li>
            </ul>
            <a href="#" class="leftbi"></a>
            <a href="#" class="righttbi"></a>
        </div>
    </div>
    <div class="advertising">
        <img src="resources/images/index/mban_2.jpg">
    </div>
    <div class="content">
        <div class="content_title_left">
            <span class="lou">1F</span>
            <span class="content_text">
                    进口<strong>·</strong>生鲜
                </span>
            <div class="content_title_right">
                <a href="#">进口咖啡</a>
                <a href="#">进口酒</a>
                <a href="#">进口母婴</a>
                <a href="#">新鲜蔬菜</a>
                <a href="#">新鲜水果</a>
            </div>
        </div>
        <div class="main">
            <div class="main_left">
                <div class="main_left_img">
                    <img src="resources/images/index/fre_r.jpg" width="211" height="286">
                    <a href="#" class="main_img_left_code"></a>
                    <a href="#" class="main_img_right_code"></a>
                </div>
                <div class="main_left_text">
                    <div class="main_left_text_a">
                        <a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a
                            href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a
                            href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
                    </div>
                </div>
            </div>
            <div class="main_middle">
                <ul>
                    <li>
                        <div class="middke_name"><a href="#">贝思客 草莓先生&蓝莓小姐</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/fre_1.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">微笑果园SMILE 智利进口绿奇异果</a></div>
                        <div class="middke_price"><span>￥84.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/fre_2.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#">
                            <img src="resources/images/index/fre_3.jpg" width="185"
                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥24.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/fre_4.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 纯牛奶</a></div>
                        <div class="middke_price"><span>￥142.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/fre_5.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">莫斯利安</a></div>
                        <div class="middke_price"><span>￥62.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/fre_6.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                </ul>
            </div>
            <div class="main_right">
                <div class="img_one">
                    <a href="#"><img src="resources/images/index/fre_b1.jpg" width="260" height="220"></a>
                </div>
                <div class="img_two">
                    <a href="#"><img src="resources/images/index/fre_b2.jpg" width="260" height="220"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="content_title_left">
            <span class="lou">2F</span>
            <span class="content_text">
                    个人美妆
                </span>
            <div class="content_title_right">
                <a href="#">洗发护发</a>
                <a href="#">面膜</a>
                <a href="#">洗面奶</a>
                <a href="#">香水</a>
                <a href="#">沐浴露</a>
            </div>
        </div>
        <div class="main">
            <div class="main_left">
                <div class="main_left_img">
                    <img src="resources/images/index/make_r.jpg" width="211" height="286">
                    <a href="#" class="main_img_left_code"></a>
                    <a href="#" class="main_img_right_code"></a>
                </div>
                <div class="main_left_text">
                    <div class="main_left_text_a">
                        <a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a
                            href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a
                            href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
                    </div>
                </div>
            </div>
            <div class="main_middle">
                <ul>
                    <li>
                        <div class="middke_name"><a href="#">贝思客 草莓先生&蓝莓小姐</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_1.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">微笑果园SMILE 智利进口绿奇异果</a></div>
                        <div class="middke_price"><span>￥84.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_2.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_3.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥24.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_4.jpg" width="185"
                                                                 height="155" alt="d"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 纯牛奶</a></div>
                        <div class="middke_price"><span>￥142.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_5.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">莫斯利安</a></div>
                        <div class="middke_price"><span>￥62.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/make_6.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                </ul>
            </div>
            <div class="main_right">
                <div class="img_one">
                    <a href="#"><img src="resources/images/index/make_b1.jpg" width="260" height="220"></a>
                </div>
                <div class="img_two">
                    <a href="#"><img src="resources/images/index/make_b2.jpg" width="260" height="220"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="content_title_left">
            <span class="lou">3F</span>
            <span class="content_text">
                    母婴玩具
                </span>
            <div class="content_title_right">
                <a href="#">营养品</a>
                <a href="#">孕妈背带裤</a>
                <a href="#">儿童玩具</a>
                <a href="#">婴儿床</a>
                <a href="#">喂奶器</a>
            </div>
        </div>
        <div class="main">
            <div class="main_left">
                <div class="main_left_img">
                    <img src="resources/images/index/baby_r.jpg" width="211" height="286">
                    <a href="#" class="main_img_left_code"></a>
                    <a href="#" class="main_img_right_code"></a>
                </div>
                <div class="main_left_text">
                    <div class="main_left_text_a">
                        <a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a
                            href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a
                            href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
                    </div>
                </div>
            </div>
            <div class="main_middle">
                <ul>
                    <li>
                        <div class="middke_name"><a href="#">贝思客 草莓先生&蓝莓小姐</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_1.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">微笑果园SMILE 智利进口绿奇异果</a></div>
                        <div class="middke_price"><span>￥84.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_2.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥98.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_3.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 进口美食</a></div>
                        <div class="middke_price"><span>￥24.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_4.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">新鲜美味 纯牛奶</a></div>
                        <div class="middke_price"><span>￥142.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_5.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                    <li>
                        <div class="middke_name"><a href="#">莫斯利安</a></div>
                        <div class="middke_price"><span>￥62.00</span></div>
                        <div class="middke_img"><a href="#"><img src="resources/images/index/baby_6.jpg" width="185"
                                                                 height="155"></a></div>
                    </li>
                </ul>
            </div>
            <div class="main_right">
                <div class="img_one">
                    <a href="#"><img src="resources/images/index/baby_b1.jpg" width="260" height="220"></a>
                </div>
                <div class="img_two">
                    <a href="#"><img src="resources/images/index/baby_b2.jpg" width="260" height="220"></a>
                </div>
            </div>
        </div>
    </div>

</div>

<!--网页尾部-->
<div class="footer">
    <div class="btm_top">
        <ul class="btm_top_ul">
            <li>
                <a href="#"><img class="daa" src="resources/images/index/b1.png" width="62" height="62"></a>
                <div>
                    <h2>正品保障</h2>
                    <span>正品行货 放心购买</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/images/index/b2.png" width="62"
                                 height="62"></a>
                <div>
                    <h2>满38包邮</h2>
                    <span>满38包邮 免运费</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="resources/images/index/b3.png" width="62" height="62"></a>
                <div>
                    <h2>天天低价</h2>
                    <span>天天低价 畅选无忧</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="resources/images/index/b4.png" width="62" height="62"></a>
                <div>
                    <h2>准时送达</h2>
                    <span>收货时间由你做主</span>
                </div>
            </li>
        </ul>
    </div>
    <div class="btm_middle">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>

        <div class="f_r">
            <a href="#" class="weibo">新浪微博</a>
            <a href="#" class="teng">腾讯微博</a>
            <p>
                服务热线：<br>
                <span>400-123-4567</span>
            </p>
        </div>

        <div class="erwei">
            <div><img src="resources/images/index/erweima.png" height="120" width="120"></div>
            <img src="resources/images/index/ss.png">
        </div>

    </div>
    <div class="btm_bottom">
        <div class="bottom_text">
            备案/许可证编号：蜀ICP备12009302号 Copyright© FS会员商城 2019-2020，All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group
            <br>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_1.gif"/>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_2.gif"/>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_3.gif"/>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_4.gif"/>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_5.gif"/>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_6.gif"/>
        </div>
    </div>
</div>

</body>
</html>
