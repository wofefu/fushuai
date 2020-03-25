<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单核对</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/bootstrap-modal.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/sweetalert.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/order-detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/swiper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopcar/iconfont.css">
</head>
<body>
<!-- personal -->
<div id="personal">
    <div class="self-info center">
        <div class="intro fr">
            <div class="uc-box uc-main-box">
                <div class="uc-content-box order-view-box">
                    <div class="box-hd">
                        <h1 class="title">我的订单</h1>
                        <div class="more clearfix">
                            <div class="actions">
                                <a id="saveOrder" class="btn btn-small btn-primary" title="提交订单">提交订单</a>
                            </div>
                        </div>
                    </div>
                    <div class="box-bd">
                        <div class="uc-order-item uc-order-item-pay">
                            <div class="order-detail">
                                <div class="order-summary">
                                    <div class="order-progress">
                                        <ol class="progress-list clearfix progress-list-5">
                                            <li class="step step-done">
                                                <div class="progress"><span class="text">购物车</span></div>
                                                <div class="info"></div>
                                            </li>
                                            <li class="step step-active">
                                                <div class="progress"><span class="text">下单</span></div>
                                                <div class="info"></div>
                                            </li>
                                            <li class="step">
                                                <div class="progress"><span class="text">付款</span></div>
                                                <div class="info"></div>
                                            </li>
                                            <li class="step">
                                                <div class="progress"><span class="text">出库</span></div>
                                                <div class="info"></div>
                                            </li>
                                            <li class="step">
                                                <div class="progress"><span class="text">交易成功</span></div>
                                                <div class="info"></div>
                                            </li>
                                        </ol>
                                    </div>
                                </div>
                                <table class="order-items-table">
                                    <tbody>
                                    <c:forEach items="${requestScope.list}" var="item">
                                        <tr>
                                            <td class="col col-thumb">
                                                <div class="figure figure-thumb">
                                                    <a href="detailPage?id=${item.id}>
                                                          <img src=""/>
                                                    <img src="resources/images/${item.picture}"  width="80"
                                                         height="80" alt="">
                                                    </a>
                                                </div>
                                            </td>
                                            <td class="col col-name">
                                                <p class="name">
                                                    <a target="_blank" href="detailPage?id=${item.id}"
                                                      > ${item.goodsname}</a>
                                                </p>
                                            </td>
                                            <td class="col col-price"><p class="price">
                                                    ${item.nowprice}元 x ${item.num}</p></td>
                                            <td class="col col-actions">
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="editAddr" class="order-detail-info">
                                <h3>收货信息</h3>
                                <table class="info-table">
                                    <tbody>
                                    <tr>
                                        <th>收货地址：</th>
                                        <td id="newaddress" class="user_address_label">
                                            ${sessionScope.user.address}
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="actions">
                                    <a class="btn btn-small btn-line-gray J_editAddr"
                                       href="javascript:openUpdateModal();">修改</a>
                                </div>
                            </div>
                            <div id="editTime" class="order-detail-info">
                                <h3>支付方式</h3>
                                <table class="info-table">
                                    <tbody>
                                    <tr>
                                        <th>支付方式：</th>
                                        <td>在线支付</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="actions">
                                </div>
                            </div>
                            <div class="order-detail-total">
                                <table class="total-table">
                                    <tbody>
                                    <tr>
                                        <th>商品总价：</th>
                                        <td><span class="num">${requestScope.moneytotal}</span>元</td>
                                    </tr>
                                    <tr>
                                        <th>运费：</th>
                                        <td><span class="num">0</span>元</td>
                                    </tr>
                                    <tr>
                                        <th class="total">应付金额：</th>
                                        <td class="total"><span class="num">${requestScope.moneytotal}</span>元
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="personalInfoModal" tabindex="-1" role="dialog"
             aria-labelledby="personalInfoModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h6 class="modal-title" id="personalInfoModalLabel">地址修改</h6>
                    </div>
                    <div class="modal-body">
                        <form id="personalInfoForm">
                            <div class="form-group">
                                <input type="hidden" id="userId" value="${sessionScope.user.id}">
                                <label for="address" class="control-label">收货地址:</label>
                                <input type="text" class="form-control" id="address" name="address"
                                       placeholder="请输入收货地址" value="${sessionScope.user.address}"
                                       required="true">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="saveButton">确认</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/css/shopcar/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/shopcar/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap3.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
<script type="text/javascript">
    $('#saveOrder').click(function () {
        let userAddress = $(".user_address_label").html();
        if (userAddress == '' || userAddress == '无') {
            swal("请填写收货信息", {
                icon: "error",
            });
            return;
        }
        if (userAddress.trim().length < 10) {
            swal("请输入正确的收货信息", {
                icon: "error",
            });
            return;
        }
        window.location.href = 'index';
    });

    function openUpdateModal() {
        $('#personalInfoModal').modal('show');
    }

    //绑定modal上的保存按钮
    $('#saveButton').click(function () {
        let address = $("#address").val();
        let userId = $("#userId").val();
        $("#newaddress").html(address);
        let data = {
            "id": userId,
            "address": address
        };
        $.ajax({
            type: 'POST',//方法类型
            url: '${pageContext.request.contextPath}/updateInfo',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $('#personalInfoModal').modal('hide');
                    window.location.reload();
                } else {
                    $('#personalInfoModal').modal('hide');
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                swal('操作失败', {
                    icon: "error",
                });
            }
        });
    });
</script>
</body>
</html>
