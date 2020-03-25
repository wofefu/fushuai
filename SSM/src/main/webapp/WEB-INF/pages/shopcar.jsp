<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/15
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FS会员商城-购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/cart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/sweetalert.css"/>
</head>
<body>

<div id="cart">
    <div class="banner_x center">
        <a href="${pageContext.request.contextPath}/index" target="_blank">
            <div class="logo fl">
                <img src="${pageContext.request.contextPath}/resources/images/loginlogo.png" alt=""/>
            </div>
        </a>

        <div class="wdgwc fl ml20">购物车</div>
        <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
        <div class="clear"></div>
    </div>
    <div class="cart_line"></div>
    <div class="cart_bg">
        <c:choose>
            <c:when test="${empty list}">
                <div class="list center">
                    <!-- todo 无购物项时 换背景图 -->
                    当前没有想要的商品加入购物车
                </div>
            </c:when>
            <c:otherwise>
                <div class="list center">
                    <div class="top2 center">
                        <div class="sub_top fl">
                        </div>
                        <div class="sub_top fl">商品名称</div>
                        <div class="sub_top fl">单价</div>
                        <div class="sub_top fl">数量</div>
                        <div class="sub_top fl">小计</div>
                        <div class="sub_top fr">操作</div>
                        <div class="clear"></div>
                    </div>
                    <c:forEach items="${list}" var="item">
                        <div class="content2 center">
                            <div class="sub_content fl ">
                            </div>
                            <div class="sub_content cover fl"><img src="resources/images/${item.picture}" alt=""></div>
                            <div class="sub_content fl ft20">${item.goodsname}</div>
                            <div class="sub_content fl">${item.nowprice}元</div>
                            <div class="sub_content fl">
                                <input class="goods_count" id="${item.carid}" type="number"
                                       onclick="updateItem(${item.carid})"
                                       value="${item.num}" step="1" min="1"
                                       max="5">
                            </div>
                            <div class="sub_content fl">${item.num*item.nowprice}元</div>
                            <div class="sub_content fl"><a href="#"
                                                           onclick="deleteItem(${item.carid})">×</a>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="pre_order mt20 center">
            <div class="tips fl ml20">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/index">继续购物</a></li>
                    <li>|</li>
                    <li>共${numtotal}件商品</li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="order_div fr">
                <div class="order_total fl">合计（不含运费）：<span>${moneytotal}元</span></div>
                <div class="order_button fr">
                    <c:choose>
                        <c:when test="${numtotal == 0}">
                            <input class="order_button_c" type="button" name="tip"
                                   onclick="tip()"
                                   value="去结算"/>
                        </c:when>
                        <c:otherwise>
                            <input class="order_button_d" type="button" name="settle"
                                   onclick="settle()"
                                   value="去结算"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/css/shopcar/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/shopcar/sweetalert.min.js"></script>
<script type="text/javascript">

    /**
     * 购物车中数量为0时提示
     */
    function tip() {
        swal("购物车中无数据，无法结算", {
            icon: "error",
        });
    }

    /**
     * 跳转至结算页面
     }     */
    function settle() {
        window.location.href = "shopcarsettle";
    }

    /**
     *更新购物项
     *
     * todo 判断是否与原值相同
     */
    function updateItem(id) {
        let domId = 'goodsCount' + id;
        let goodsCount = $("#" + domId).val();
        if (goodsCount > 5) {
            swal("单个商品最多可购买5个", {
                icon: "error",
            });
            return;
        }
        if (goodsCount < 1) {
            swal("数量异常", {
                icon: "error",
            });
            return;
        }
        let data = {
            "cartItemId": id,
            "goodsCount": goodsCount
        };
        $.ajax({
            type: 'PUT',
            url: '/shop-cart',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    window.location.reload();
                } else {
                    swal("操作失败", {
                        icon: "error",
                    });
                }
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
    }

    /**
     * * 删除购物项
     * @param id
     */
    function deleteItem(id) {
        swal({
            title: "确认弹框",
            text: "确认要删除数据吗?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((flag) => {
                if (flag) {
                    $.ajax({
                        type: 'DELETE',
                        url: '/shop-cart/' + id,
                        success: function (result) {
                            if (result.resultCode == 200) {
                                window.location.reload();
                            } else {
                                swal("操作失败", {
                                    icon: "error",
                                });
                            }
                        },
                        error: function () {
                            swal("操作失败", {
                                icon: "error",
                            });
                        }
                    });
                }
            }
        );
    }
</script>
</html>

