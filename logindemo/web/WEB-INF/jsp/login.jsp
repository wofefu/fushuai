<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
    <%--<link rel="stylesheet" href="resources/css/login.css">--%>
    <style>
        .out{
            text-align: center;
            width: 500px;
            height: 600px;

            margin: 0 auto;
            padding-top: 30px;
            background: url('../img/p1.jpg') no-repeat;

        }
        .inside{

            width: 300px;
            margin: 0 auto;
        }
        .tb{
            color: brown;
            text-align: center;
        }
        #warn{
            font-size: 9px;
            color: brown;
            position: absolute;
            left: 30px;
        }
        a{
            float: right;
            font-size: 12px;
            color: brown;
        }
        .outt{
            padding-left: 20px;
            text-align: center;
            width: 300px;
            height: 300px;
            padding-top: 30px;
            background-color: beige;
            position: absolute;
            right: 20px;
            top: 50px;
        }

        td{
            text-align: center;
            padding: 10px;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="out">
    <div class="outt">
        <form action="login" method="post">
            <div class="inside">
                <table class="tb">
                    <tr>
                        <td style="font-size: 12px">用户名：</td>
                        <td><input type="text" name="name" value="${name}">
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="pwd"></td>
                    </tr>
                    <tr>
                        <td>
                            <p style="color: red;font-size: 10px;float: left">
                                ${requestScope.msg}
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="登录" style="width: 200px"></td>
                    </tr>
                </table>
                <p style="position: absolute;left: 50px;">
                    <span style="color: chocolate ;font-size: 9px">没账号？</span>
                    <a href="regist" style="float: right;font-size: 9px;">点我去注册</a>
                </p>
            </div>


        </form>
    </div>
</div>
</body>

</html>
