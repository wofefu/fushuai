<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/20
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <link rel="stylesheet" href="./css/public2.css">
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/productList.css">
</head>
<body>
<!--网页头部-->
<div class="header">
    <div class="header_top">
        <div class="header_top_left">
            <span>送货至：全国</span>
        </div>
        <div class="header_top_right">
            <div class="r1">你好！请<a href="login">登录</a>&nbsp;<a href="register" style="color: #FF3C3C">免费注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
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
            <span class="topimg"><img src="${pageContext.request.contextPath}resources/images/index/sh1.png">
                    <img src="${pageContext.request.contextPath}resources/images/index/sh2.png"></span>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <span class="phone">手机版<img src="${pageContext.request.contextPath}resources/images/index/s_tel.png"></span>
        </div>
    </div>
    <div class="header_sou">
        <div class="onedayshop"><a href="#"><img src="${pageContext.request.contextPath}resources/images/loginlogo.png" width="210px" height="72px"></a></div>
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
            <div class="cart">购物车</div>
        </div>
    </div>
</div>
<!--网页中间部分-->
<div class="section">
    <div class="section_top">
        <div class="menu">
            <div class="left">
                <div class="classify">全部商品分类</div>
                <div class="left_nav" style="display: none">
                    <ul>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav1.png"></span>
                                <span class="f1">进口食品、生鲜</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav2.png"></span>
                                <span class="f1">食品、饮料、酒</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav3.png"></span>
                                <span class="f1">母婴、玩具、童装</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav4.png"></span>
                                <span class="f1">家居、家庭清洁、纸品</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav5.png"></span>
                                <span class="f1">美妆、个人护理、洗护</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav6.png"></span>
                                <span class="f1">女装、内衣、中老年</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav7.png"></span>
                                <span class="f1">鞋靴、箱包、腕表配饰</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav8.png"></span>
                                <span class="f1">男装、运动</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav9.png"></span>
                                <span class="f1">手机、小家电、电脑</span>
                            </div>
                        </li>
                        <li>
                            <div class="fj">
                                <span class="navimg"><img src="${pageContext.request.contextPath}resources/images/index/nav10.png"></span>
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
                <a href="#" class="right_img"><img src="${pageContext.request.contextPath}resources/images/index/phone.png"></a>
            </div>
        </div>
    </div>
    <div class="section_navigation">
        <span>全部 > 珠宝饰品 > 珍珠项链 ></span>
        <span class="brand_bor">
                <span>品牌：<em>珠韵首饰</em></span>
            </span>
    </div>
    <div class="section_classify">
        <table>
            <tr>
                <td>&nbsp; 品牌：</td>
                <td>
                    <a href="#" style="color: #ff4e00;">珠韵首饰/ZHUYUN JEWELLERY</a>
                    <a href="#">施华洛世奇/Swarovski</a>
                    <a href="#">海瞳</a>
                    <a href="#">周大福/CHOW TAI FOOK</a>
                    <a href="#">京润珍珠</a>
                    <a href="#">佰色传情 /BRI.R</a>
                    <a href="#">迈姿/Maizi</a>
                    <a href="#">Ginasy Jewelry</a>
                    <a href="#">心鑫圆</a>
                    <a href="#">银斯妮/yin si ni silver</a>
                    <a href="#">迈姿/Maizi</a>
                    <a href="#">Ginasy Jewelry</a>
                    <a href="#">蛟蓓</a>
                    <a href="#">芭比/Barbie</a>
                    <a href="#">珍福祥</a>
                    <a href="#">珍福祥</a>
                </td>
            </tr>
            <tr>
                <td>&nbsp; 价格：</td>
                <td>
                    <a href="#">0-199</a>
                    <a href="#" style="color: #ff4e00;">200-399</a>
                    <a href="#">400-599</a>
                    <a href="#">600-899</a>
                    <a href="#">900-1299</a>
                    <a href="#">1300-1399</a>
                    <a href="#">1400以上</a>
                </td>
            </tr>
            <tr>
                <td>珍珠颜色：</td>
                <td>
                    <a href="#">混彩</a>
                    <a href="#">黑色系</a>
                    <a href="#">粉色系</a>
                    <a href="#">白色系</a>
                    <a href="#">金色系</a>
                    <a href="#">紫色系</a>
                </td>
            </tr>
            <tr>
                <td>珍珠分类：</td>
                <td>
                    <a href="#">天然海水珍珠</a>
                    <a href="#">养殖海水珍珠</a>
                    <a href="#">养殖淡水珍珠</a>
                    <a href="#">天然淡水珍珠</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="section_content_pro">
        <div class="section_content_pro_left">
            <div class="browsing_history">
                <span class="browsing_history_text">浏览历史</span>
                <span class="clear"><a href="#">清空</a></span>
            </div>
            <ul class="list">
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/his_1.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/his_2.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥768.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/his_3.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥668.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/his_4.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
                <li>
                    <div class="list_img"><a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/his_5.jpg"></a></div>
                    <div class="list_name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="list_price"><span>￥368.00</span></div>
                </li>
            </ul>
        </div>
        <div class="section_content_pro_right">
            <div class="pro_right_top">
                    <span>
                        <a href="#" style="background: #ff4e00;color: white;">默认</a>
                        <a href="#">
                            <span>销量</span>
                            <span class="up"></span>
                            <span class="down"></span>
                        </a>
                        <a href="#">
                            <span>价格</span>
                            <span class="up"></span>
                            <span class="down"></span>
                        </a>
                        <a href="#">新品</a>
                    </span>
                <span class="discover1">
                        共发现120件
                    </span>
            </div>
            <div class="pro_right_content">
                <ul class="prc_ul">
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_1.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_2.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥598.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">佰色传情淡水珍珠项链圆8-9mm</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_3.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥440.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">京润 【魅惑】海水珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_4.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥680.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">心鑫圆 天然珍珠项链淡水套装</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_5.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥670.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳 明星款 玛瑙天然淡水珍珠</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_6.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥2198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">京润 【简爱】 淡水珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_7.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥5298.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">
                                海瞳 罕见7-8mm高亮泽 表皮光滑 </a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_8.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥212.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#"> 媲美海水珠天然浅粉金色珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_9.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥618.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">无暇品质(925银玫瑰花型银扣)</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_10.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥260.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">珍珠吊坠925银镀金淡水珍珠</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_11.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳 淡水珍珠项链锁骨链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_12.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥698.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_13.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#"> 超强光珍珠吊坠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_14.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_15.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_16.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_17.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_18.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                        <div class="prc_ul_img">
                            <a href="#"><img src="${pageContext.request.contextPath}resources/images/productList/per_19.jpg" width="210" height="185"></a>
                        </div>
                        <div class="prc_ul_price">
                            <span>￥198.00</span>
                        </div>
                        <div class="prc_ul_name">
                            <a href="#">海瞳7-8mm水滴形天然珍珠项链</a>
                        </div>
                        <div class="prc_ul_carbg">
                            <a href="#" class="ss11">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                </ul>
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
                <a href="#"><img class="daa" src="${pageContext.request.contextPath}resources/images/index/b1.png" width="62" height="62" alt=""></a>
                <div>
                    <h2>正品保障</h2>
                    <span>正品行货 放心购买</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}resources/images/index/b2.png" width="62" height="62"></a>
                <div>
                    <h2>满38包邮</h2>
                    <span>满38包邮 免运费</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}resources/images/index/b3.png" width="62" height="62"></a>
                <div>
                    <h2>天天低价</h2>
                    <span>天天低价 畅选无忧</span>
                </div>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}resources/images/index/b4.png" width="62" height="62"></a>
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
            <div><img src="${pageContext.request.contextPath}resources/images/index/erweima.png" height="120" width="120"></div>
            <img src="${pageContext.request.contextPath}resources/images/index/ss.png">
        </div>

    </div>
    <div class="btm_bottom">
        <div class="bottom_text">
            备案/许可证编号：蜀ICP备12009302号-1 Copyright© FS会员商城 2019-2020，All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group
            <br>
            <img src="${pageContext.request.contextPath}resources/images/index/b_1.gif" />
            <img src="${pageContext.request.contextPath}resources/images/index/b_2.gif" />
            <img src="${pageContext.request.contextPath}resources/images/index/b_3.gif" />
            <img src="${pageContext.request.contextPath}resources/images/index/b_4.gif" />
            <img src="${pageContext.request.contextPath}resources/images/index/b_5.gif" />
            <img src="${pageContext.request.contextPath}resources/images/index/b_6.gif" />
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}resources/js/show.js"></script>
</body>
</html>
