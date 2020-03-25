<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="stylesheet" href="resources/css/personal.css">
</head>

<body>
<div class="header">
    <div><img src="${sessionScope.user.icon}" alt="" class="icon">
        <span>${sessionScope.user.nickName}</span>
    </div>

    <div class="logout"><span onclick="location.href='index'">首页</span><span onclick="location.href='logout'">注销</span>
    </div>
</div>

<div class="main">
    <div class="aside">
        <div class="menu active"><span>个人资料</span></div>
        <div class="menu">
            <span onclick="toUploadPhoto()">修改头像</span></div>
        <div class="menu">
            <span onclick="Count()">我的微博</span></div>
    </div>

    <div class="editarea">
        <form action="update" method="post">
            <div class="info-item" style="margin-top: 40px">
                <span>昵称</span>
                <input type="text" name="nickName" value="${sessionScope.user.nickName}">

            </div>

            <div class="info-item" style="margin-top: 40px">
                <span>性别</span>
                <div>
                    <c:choose>
                        <c:when test="${sessionScope.user.gender == '男'}">
                            <input type="radio" value="男" name="gender" checked>男
                        </c:when>
                        <c:otherwise>
                            <input type="radio" value="男" name="gender">男
                        </c:otherwise>
                    </c:choose><c:choose>
                    <c:when test="${sessionScope.user.gender=='女'}">
                        <input type="radio" value="女" name="gender" checked>女
                    </c:when>
                    <c:otherwise>
                        <input type="radio" value="女" name="gender">女
                    </c:otherwise>
                </c:choose>
                </div>

            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>生日</span>
                <input type="date" value="${sessionScope.user.birthday}" name="birthday">

            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>家乡</span>
                <input type="text" name="hometown" value="${sessionScope.user.hometown}">

            </div>
            <div class="info-item" style="margin-top: 40px">
                <span>职业</span>
                <input type="text" value="${sessionScope.user.job}" name="job">

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
<script>function toUploadPhoto() {
    location.href = "icon";
}

function Count() {
    location.href = "count";
}
</script>
</html>
