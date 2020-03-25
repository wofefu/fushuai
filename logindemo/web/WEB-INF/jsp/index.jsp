<%--suppress JSAnnotator --%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/6
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="resources/css/index.css">
    <script src="resources/js/jquery-3.4.1.min.js"></script>
    <script src="resources/js/index.js"></script>
    <style>
        .discuss {
            height: 100px;
            width: 200px;
            border: 1px solid red;
        }

        .aa {
            height: 40px;
            width: 500px;
            border: 1px solid red;
        }

        .content {
            width: 400px;
            height: 30px;
            padding: 10px;
            color: #828282;
            box-shadow: 0 0 10px #e4e4e4;
        }

        .main1 {
            /*border: 1px solid red;*/
            width: 300px;
            padding: 30px 0;
            margin-left: 400px;
        }

        .blog-icon1 {
            width: 50px;
            height: 50px;
            border-radius: 50px;

        }

        .my-icon1 {
            width: 50px;
            height: 50px;
            border-radius: 50px;
        }
    </style>
</head>
<body>
<div class="header">
    <div id="nicheng">${sessionScope.user.nickName},你今天代码写完了吗</div>
    <div><a href="update">个人中心</a></div>
</div>
<div class="main">
    <div class="publish-area">
        <div class="publish">
            <img class="my-icon" src='${sessionScope.user.icon}'>
            <div contenteditable="true" id="content" onfocus="checkContent()" onblur="initPlaceholder()">又写Bug了?</div>
        </div>
        <div class="publish-buttons">
            <button class="publish-btn" onclick="fabu()">发布</button>
        </div>
    </div>
    <div class="blogs">
        <c:forEach items="${requestScope.list}" var="Blog">
            <div class="blog">
                <div style="display: none;" class="blogID">
                    ${Blog.id}
                </div>
                <div class="blog-user">
                    <img class="blog-icon" src=${Blog.icon}>
                    <div class="blog-date">
                        <span class="name">${Blog.nickName}</span>
                        <span class="time"><fmt:formatDate value="${Blog.createTime}" pattern="YYYY-MM-dd"/></span>
                        <span class="time"><fmt:formatDate value="${Blog.createTime}" pattern="HH-mm"/></span>
                    </div>
                </div>
                <div class="blog-content">
                    <div class="blog-text">${Blog.content}</div>
                    <hr style="width: 100%">
                    <div class="blog-comment">
                        <c:choose>
                            <c:when test="${Blog.uId !=null}">
                                <img src="resources/img/dianzan.jpg"
                                     height="16" width="16"
                                     class="praise" onclick="dianzan(this,${Blog.id})">
                            </c:when>
                            <c:otherwise>
                                <img src="resources/img/p1.jpg"
                                     height="16" width="16"
                                     class="praise" onclick="dianzan(this,${Blog.id})">
                            </c:otherwise>
                        </c:choose>
                        <span id="praiseNum">${Blog.praiseNum}</span>
                        <span>赞</span>
                        <span onclick="pinglun(this,${Blog.id})">评论</span>
                    </div>
                </div>
            </div>

            <div class="main1" style="display: none">
                <div class="publish-area1">
                    <div class="publish1">
                        <img class="my-icon1" src=${sessionScope.user.icon}>
                        <div contenteditable="true" class="content"></div>
                    </div>
                    <div class="publish-buttons">
                        <button class="publish-btn" onclick="fabiao(this)">发表</button>
                    </div>
                </div>
                <div class="blogs">

                </div>

            </div>

        </c:forEach>

    </div>
</div>

<div class="pages">

    <button class="publish-btn" onclick="pre()">上一页</button>
    <span>当前第<span id="page">${requestScope.page}</span>页</span>
    <button class="publish-btn" onclick="NextPage()">下一页</button>
</div>

</div>
<div style="display: none">
    <form action="content" method="post">
        <textarea id="hidden-content" name="content"></textarea>
        <input type="submit" id="hidden-submit" value="提交">
    </form>
</div>

</body>
<script>
    // $(".praise").click(
    //     function () {
    //         var praiseNum=parseInt($(this).parent().find("span").eq(0).text());
    //         $(this).parent().find("span").eq(0).text(praiseNum+1);
    //         var blogId=parseInt($(this).parent().find("span").eq(2).text());
    //
    //         ajax-点赞
    //
    //         $.post("praise", {blogId: blogId, praiseNum: praiseNum + 1}, function (result) {
    //             alert(result.status)
    //             if (result.status == 1) {
    //                 alert("插入数据库成功")
    //             }
    //         });
    //
    //     }
    // )

    function dianzan(ele, id) {
        var req = new XMLHttpRequest();
        req.onreadystatechange = function () {
            if (req.status == 200 && req.readyState == 4) {
                var temp = parseInt($(ele).next().text())
                if (ele.getAttribute("src") == "resources/img/dianzan.jpg") {
                    $(ele).attr("src", "resources/img/p1.jpg");
                    $(ele).next().text(--temp);
                } else {
                    $(ele).attr("src", "resources/img/dianzan.jpg")
                    $(ele).next().text(++temp);
                }
            }
        }
        req.open("GET", "praise?blogId=" + id);
        req.send();
    }

    function pinglun(ele, blogId) {
        // $(ele).prev().css("display","none");
        $(ele).parents(".blog").next().toggle()
        // var content = $(ele).parents(".blog").next().find(".content").text();
        $.post("discuss", {blogId: blogId}, function (result, staus) {
            if (staus === "success") {
                // console.log(result);
                for (var i = 0; i < result.length; i++) {
                    $(ele).parents(".blog").next().find(".blogs").append(
                        "<div class='blog1'>" +
                        "<div class='blog-user'>" +
                        "<img class='blog-icon1' src=" + result[i].icon + ">" +
                        "<div>" + result[i].nickName + "</div>" +
                        "</div>" +
                        "<div class='blog-content'>" +
                        "<div class='blog-text'>" + result[i].content + "</div>" +
                        "<hr style='width: 100%'>" +
                        "</div>" +
                        "</div>"
                    )
                }
            }
        })
    }

    function fabiao(ele) {
        var content = $(ele).parent().prev().find(".content").text();
        // alert(content);
        $(ele).parents(".main1").find(".blogs").prepend(" <div class='blog1'>" +
            "                        <div class='blog-user'>" +
            "                            <img class='blog-icon1' src=${sessionScope.user.icon}>" + " <div>${sessionScope.user.nickName}</div>" +
            "                        </div>" +
            "                        <div class='blog-content'>" +
            "                            <div class='blog-text'>" + content + "</div>" +
            "                            <hr style='width: 100%'>" +
            "                        </div>" +
            "                    </div>");
        var blogId=$(ele).parents(".main1").prev().find(".blogID").text();
        console.log("微博id"+blogId);
        $.post("addDiscuss",{blogId:blogId,content:content},function (result,status) {
            if (status==="success") {
                $(ele).parent().prev().find(".content").text("");
                console.log("插入评论数据成功")
            }
        });
    }

</script>
</html>
