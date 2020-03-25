<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%--<link rel="stylesheet" href="resources/css/login.css">--%>
    <style>
        .out{
            text-align: center;
            width: 500px;
            height: 600px;

            margin: 0 auto;
            padding-top: 30px;
            background: url("../img/p1.jpg") no-repeat;

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
    <script>
        function f(){
            var i=document.getElementById("ins").value;

            if(i.length<4||i.length>10){
                var s= document.getElementById("hezi").innerHTML="用户名长度要求4-10位";
            }else{

                var s= document.getElementById("hezi").innerHTML=""; document.getElementById("ses").removeAttribute("disabled")
            }
        }
        function cl() {
            document.getElementById("warn").innerHTML="";

        }

        function ff(){
            var i=document.getElementById("ses").value;
            if(i.length<4||i.length>10){
                var s= document.getElementById("hezi2").innerHTML="密码长度要求4-10位";

            }else{
                document.getElementById("hezi2").innerHTML="";


            }
        }
        function su() {
            var i=document.getElementById("ses").value;
            if(i.length>=3){
                document.getElementById("bt").removeAttribute("disabled");
            }

        }


    </script>
</head>
<body>
<div class="out">
    <div class="outt">
        <form action="regist" method="post">
            <p>注册</p>
            <table>
                <tr>
                    <td>
                        <p id="warn">
                            ${warn}
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="name" onblur="f()" id="ins" onfocus="cl()" required></td>

                </tr>
                <tr style="width: 10px;height: 10px">
                    <td>
                        <p id="hezi" style="color: red;font-size: 8px"></p>
                    </td>
                </tr>
                <tr>
                    <td> 密码：</td>
                    <td><input type="password" name="pwd" id="ses" disabled onblur="ff()" onkeypress="su()" required>
                    </td>

                </tr>
                <tr style="width: 10px;height: 10px">
                    <td>
                        <p id="hezi2" style="color: red;font-size: 8px"></p>
                    </td>
                </tr>

                <tr>

                    <td colspan="2">
                        <input type="submit" id="bt" disabled style="width: 250px">
                    </td>
                </tr>
            </table>

            <a href="login">登录</a>


        </form>
    </div>
</div>
</body>
</html>
