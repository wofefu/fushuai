
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品详情页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/datailPage.css">
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
                        |&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/personal">个人中心</a>&nbsp;&nbsp;|&nbsp;&nbsp;
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
            <span class="topimg"><img src="${pageContext.request.contextPath}/resources/images/index/sh1.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/images/index/sh2.png"></span>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <span class="phone">手机版<img src="${pageContext.request.contextPath}/resources/images/index/s_tel.png"></span>
        </div>
    </div>
    <div class="header_sou">
        <div class="onedayshop"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/loginlogo.png" width="210px" height="72px" alt=""></a></div>
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


<div class="section">
    <div class="section_top">
        <div class="menu">
            <div class="left">
                <div class="classify">全部商品分类</div>
                <div class="left_nav" style="display: none">
                    <ul>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav1.png"></span>
                                <span class="f1">进口食品、生鲜</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav2.png"></span>
                                <span class="f1">食品、饮料、酒</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav3.png"></span>
                                <span class="f1">母婴、玩具、童装</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav4.png"></span>
                                <span class="f1">家居、家庭清洁、纸品</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav5.png"></span>
                                <span class="f1">美妆、个人护理、洗护</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav6.png"></span>
                                <span class="f1">女装、内衣、中老年</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav7.png"></span>
                                <span class="f1">鞋靴、箱包、腕表配饰</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav8.png"></span>
                                <span class="f1">男装、运动</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav9.png"></span>
                                <span class="f1">手机、小家电、电脑</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}/resources/images/index/nav10.png"></span>
                                <span class="f1">礼品、充值</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="div_menu">
                    <ul class="menu_right">
                        <li><a href="${pageContext.request.contextPath}/index" style="color: #FF3C3C">首页</a></li>
                        <li><a href="#" style="color: #FF3C3C">自营超市</a></li>
                        <li><a href="#">1号团</a></li>
                        <li><a href="#">1号超市</a></li>
                        <li><a href="#">女装</a></li>
                        <li><a href="#">美妆</a></li>
                        <li><a href="#">1号海购</a></li>
                        <li><a href="#">团购</a></li>
                    </ul>
                </div>
                <a href="#" class="right_img"><img src="${pageContext.request.contextPath}/resources/images/index/phone.png"></a>
            </div>
        </div>
    </div>

    <div class="section_navigation">
        <span>所有团购 > 包饰 > ${good.typeid} ></span>
        <span class="brand_bor">
                <span>冰韵 <em>天然白色正圆S925银扣珍珠项链</em></span>
            </span>
    </div>

    <div class="section_title">
        <div class="section_title_left">
            <div class="img_bor">
                <img src="${pageContext.request.contextPath}/resources/images/${good.picture}" width="390" height="390">
            </div>
            <div class="gundong">
                <div class="gundong_left"></div>
                <ul>
                    <li><img src="${pageContext.request.contextPath}/resources/images/datailPage/ps1.jpg"></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/datailPage/ps2.jpg"></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/datailPage/ps3.jpg"></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/datailPage/ps4.jpg"></li>
                </ul>
                <div class="gundong_right"></div>
            </div>
        </div>
        <div class="section_title_middle">
            <h3>${good.goodsname}</h3>
            <p class="p1">${good.introduce}</p>
            <p class="p2">本店价格：<span>￥${good.price}</span></p>
            <p class="p3">参考价：<span>￥${good.nowprice}</span></p>
            <div class="size">
                尺寸：<span class="size_1">43cm</span>
                <span class="size_2">45cm</span>
                <span class="size_2">50cm</span>
            </div>
            <div class="color_xz">
                颜色选择：<span class="size_2">粉色</span>
                <span class="size_1">白色</span>
            </div>
            <div class="share">
                <div class="share_text">
                    分享
                    <div class="share_text_imghidden">
                        <a href="#"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sh_1.gif" alt=""></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sh_2.gif" alt=""></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sh_3.gif" alt=""></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sh_4.gif" alt=""></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sh_5.gif" alt=""></a>
                    </div>
                </div>
                <div class="guanzhu"><a href="#">关注商品</a></div>
            </div>
            <div class="annuediv">
                <div class="annue">
                    <input type="text" name="num" value="1">
                    <input type="text">
                    <input type="text">
                </div>
                <div class="jiaru">
                    <a href="addgoodsinshopcar?memberid=${sessionScope.user.id}&&goodsid=${good.id}"><img src="${pageContext.request.contextPath}/resources/images/datailPage/j_car.png" alt=""></a>
                </div>
            </div>
        </div>
        <div class="section_title_right">
            <div class="right_img_1"><img src="${pageContext.request.contextPath}/resources/images/datailPage/sbrand.jpg" width="188" height="132"></div>
            <div class="rigth_text_1">
                <a href="#">进入品牌专区</a>
            </div>
        </div>
    </div>


    <div class="section_content_pro">
        <div class="section_content_pro_left">
            <div class="browsing_history">
                <div class="browsing_history_text">用户还喜欢</div>
            </div>
            <ul class="list">
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/productList/his_1.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/productList/his_2.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥768.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/productList/his_3.jpg" alt=""></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥668.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/productList/his_4.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/productList/his_5.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
            </ul>
        </div>
        <div class="section_content_pro_right">
            <div class="section_content_pro_right_top">
                <div class="bjys">
                    <div class="tuijian">推荐搭配</div>
                </div>
                <div class="scprt_content">
                    <div class="sc_one">
                        <div class="sc_one_img"><img src="${pageContext.request.contextPath}/resources/images/datailPage/mat_1.jpg"></div>
                        <div class="sc_one_name"><a href="#">粤通国际珠宝 999足金</a></div>
                        <div class="sc_one_price">
                                <span>
                                    <input type="checkbox" checked>
                                </span>
                            <span class="money_y">￥76</span>
                        </div>
                    </div>
                    <div class="jiajia"><img src="${pageContext.request.contextPath}/resources/images/datailPage/jia_b.gif" alt=""></div>
                    <div class="sc_one">
                        <div class="sc_one_img"><img src="${pageContext.request.contextPath}/resources/images/datailPage/mat_2.jpg"></div>
                        <div class="sc_one_name"><a href="#">粤通国际珠宝 999足金</a></div>
                        <div class="sc_one_price">
                                <span>
                                    <input type="checkbox">
                                </span>
                            <span class="money_y">￥76</span>
                        </div>
                    </div>
                    <div class="jiajia"><img src="${pageContext.request.contextPath}/resources/images/datailPage/jia_b.gif" alt=""></div>

                    <div class="sc_one">
                        <div class="sc_one_img"><img src="${pageContext.request.contextPath}/resources/images/datailPage/mat_3.jpg"></div>
                        <div class="sc_one_name"><a href="#">粤通国际珠宝 999足金</a></div>
                        <div class="sc_one_price">
                                <span>
                                    <input type="checkbox" checked>
                                </span>
                            <span class="money_y">￥76</span>
                        </div>
                    </div>

                    <div class="jiajia"><img src="${pageContext.request.contextPath}/resources/images/datailPage/equl.gif" alt=""></div>

                    <div class="sc_eq">
                        <div class="taocanjia">套餐价：￥<span>2000</span></div>
                        <div class="numnumnum">
                            <input type="text" value="1">
                        </div>
                        <div><img src="${pageContext.request.contextPath}/resources/images/datailPage/z_buy.gif"></div>
                    </div>
                </div>
            </div>
            <div class="section_content_pro_right_content">
                <div class="bjys_2">
                    <div class="bjys_2_1">商品属性</div>
                    <div>商品详细</div>
                    <div>商品评论</div>
                </div>
                <div class="bjys_content">
                    <div class="bc_one">
                        <div>商品名称：天然淡水珍珠</div>
                        <div>商品毛重：160.00g</div>
                        <div>镶嵌材质：纯银</div>
                    </div>
                    <div class="bc_one">
                        <div>商品编号：1546211</div>
                        <div>商品产地：法国</div>
                        <div>款式：项链</div>
                    </div>

                    <div class="bc_one">
                        <div>品牌： 珠韵首饰</div>
                        <div>珍珠形状：正圆</div>
                    </div>
                    <div class="bc_one">
                        <div>上架时间：${good.intime}</div>
                    </div>
                </div>
            </div>
            <div class="section_content_pro_right_bottom">
                <div class="shopdatail">
                    商品详细
                </div>
                <div class="bigimg">
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de2.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de3.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de4.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de5.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de6.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de7.jpg">
                    </div>
                    <div class="bigimg_img">
                        <img src="${pageContext.request.contextPath}/resources/images/datailPage/de8.jpg">
                    </div>
                </div>
            </div>
            <div class="section_content_pro_right_pinlun">
                <div class="shopdatail">
                    商品评论
                </div>
                <div class="baifenzhi">
                    <div class="baifenzhi_left">
                        <div class="baifenzhi_left_left">
                            <div class="baifenzhisss">
                                <span class="sp1">80.0%</span>
                                <br>
                                <span class="sp2">好评度</span>
                            </div>
                            <div class="ping1">
                                <div class="online1">
                                    <span>好评(80%)</span>
                                    <img src="${pageContext.request.contextPath}/resources/images/datailPage/pl.gif">
                                </div>
                                <div class="online1">
                                    <span>中评(20%)</span>
                                    <img src="${pageContext.request.contextPath}/resources/images/datailPage/pl.gif">
                                </div>
                                <div class="online1">
                                    <span>差评(0%)</span>
                                    <img src="${pageContext.request.contextPath}/resources/images/datailPage/pl.gif">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="baifenzhi_content">
                        购买过珠韵首饰 天然银扣珍珠项链的顾客，在收到商品才可以对该商品发表评论
                    </div>
                    <div class="baifenzhi_bottom">
                        <div>您可对已购商品进行评论</div>
                        <div><img src="${pageContext.request.contextPath}/resources/images/datailPage/btn_jud.gif"></div>
                    </div>

                </div>

                <table class="tablepinlun" style="width: 100%">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/resources/images/datailPage/peo1.jpg" class="tableimg">&nbsp;向死而生
                        </td>
                        <td>
                            颜色分类：<span>粉色</span>
                            <br>
                            型号：<span>43cm</span>
                        </td>
                        <td>
                            产品很好，香味很喜欢，必须给赞
                            <br>
                            <span>2015-09-24</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/resources/images/datailPage/peo2.jpg" class="tableimg">&nbsp;就是这么想的
                        </td>
                        <td>
                            颜色分类：<span>粉色</span>
                            <br>
                            型号：<span>43cm</span>
                        </td>
                        <td>
                            送朋友，他很喜欢，大爱。
                            <br>
                            <span>2015-09-24</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/resources/images/datailPage/peo3.jpg" class="tableimg">&nbsp;魔镜魔镜
                        </td>
                        <td>
                            颜色分类：<span>白色</span>
                            <br>
                            型号：<span>43cm</span>
                        </td>
                        <td>
                            大家都说不错
                            <br>
                            <span>2015-09-24</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/resources/images/datailPage/peo4.jpg" class="tableimg">&nbsp;那*****样
                            <br>
                            <span>(匿名用户)</span>
                        </td>
                        <td>
                            颜色分类：<span>白色</span>
                            <br>
                            型号：<span>43cm</span>
                        </td>
                        <td>
                            下次还会来买，推荐
                            <br>
                            <span>2015-09-24</span>
                        </td>
                    </tr>
                </table>
                <div class="page">
                    <a href="#" class="uppage">上一页</a>
                    <a href="#" class="numa" style="background: #ff4e00;
                        border: 1px solid #ff4e00; color: white;">1</a>
                    <a href="#" class="numa2">2</a>
                    <a href="#" class="numa3">3</a>
                    <span>...</span>
                    <a href="#" class="numa4">20</a>
                    <a href="#" class="uppage2">下一页</a>
                </div>
            </div>
        </div>
    </div>

</div>
<!--网页尾部-->
<div class="footer" style="margin-top: 60px;">
    <div class="btm_top">
        <ul class="btm_top_ul">
            <li>
                <a href="#"><img class="daa" src="${pageContext.request.contextPath}/resources/images/index/b1.png" width="62" height="62"></a>
                <div>
                    <h2>正品保障</h2>
                    <span>正品行货 放心购买</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/images/index/b2.png" width="62" height="62"></a>
                <div>
                    <h2>满38包邮</h2>
                    <span>满38包邮 免运费</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/images/index/b3.png" width="62" height="62"></a>
                <div>
                    <h2>天天低价</h2>
                    <span>天天低价 畅选无忧</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/images/index/b4.png" width="62" height="62"></a>
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
            <div><img src="${pageContext.request.contextPath}/resources/images/index/erweima.png" height="120" width="120"></div>
            <img src="${pageContext.request.contextPath}/resources/images/index/ss.png">
        </div>

    </div>
    <div class="btm_bottom">
        <div class="bottom_text">
            备案/许可证编号：蜀ICP备12009302号-1 Copyright© FS会员商城 2019-2020，All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group
            <br>
            <img src="${pageContext.request.contextPath}/resources/images/index/b_1.gif" />
            <img src="${pageContext.request.contextPath}/resources/images/index/b_2.gif" />
            <img src="${pageContext.request.contextPath}/resources/images/index/b_3.gif" />
            <img src="${pageContext.request.contextPath}/resources/images/index/b_4.gif" />
            <img src="${pageContext.request.contextPath}/resources/images/index/b_5.gif" />
            <img src="${pageContext.request.contextPath}/resources/images/index/b_6.gif" />
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/show.js"></script>
</body>
</html>
