<%--
  Created by IntelliJ IDEA.
  User: heweizhi
  Date: 2020/3/19
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var $usernameInput = $("#username");
            $usernameInput.on("blur", function(){
                var username = $(this).val();
                $.getJSON("${pageContext.request.contextPath}/checkUsername", {username:username}, function(data){
                    if(data.code == '0'){
                        $("#usernameMsg").css("color", "green");
                    }else{
                        $("#usernameMsg").css("color", "red");
                    }

                    $("#usernameMsg").html(data.msg);
                });
            });
        });
    </script>
</head>
<body>
    <h1>欢迎注册</h1>
    <form action="javascript:void(0)">
        <input type="text" id="username" name="username">
        <span id="usernameMsg"></span>
    </form>
</body>
</html>
