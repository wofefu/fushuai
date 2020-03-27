<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/8
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/login.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"/>
</head>
<body>
sadf
<%--wo${name}--%>
<%--   <c:forEach items="${list}" var="num">--%>
<%--       ${num}--%>
<%--   </c:forEach>--%>
${u.username}

<%--<form action="${pageContext.request.contextPath}/login" method="post">--%>
<%--    <input type="text" name="username">--%>
<%--    <input type="password" name="password">--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<div id="app">
    <form method="post" id="form">
        <input type="text" name="username" v-model="person.username"/><br />
        <input type="text" name="age"  v-model="person.age"/><br/>
        <input type="button" value="提交" @click="duixiang()"/>
    </form>
    <span @click="query()">显示用户基本信息</span>
    <div>
        <div>{{user.username}}</div>
        <div>{{user.date}}</div>
    </div>
</div>
</body>
<script>
    new Vue({
        el: "#app",
        data: {
            user: [],
            person:{
                username:"xiao",
                age:"15"
            },
        },
        methods: {

            query: function () {
                self = this;
                $.post("lesson", function (result) {
                    console.log(result);
                    self.user = result;
                })
            },
            duixiang: function () {
                self = this;
                $("#form").serialize();//不是一个对象
                console.log(JSON.stringify(self.person))
                $.ajax({
                    url: '${pageContext.request.contextPath}/test',
                    type: 'post',

                    contentType: 'application/json',
                    // contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    // 前端传的是对象 直接接收
                    //前端传的是json字符串    contentType: 'application/json',  public ModelAndView login(@RequestBody User user, HttpSession session)self.person
                    //
                    data:JSON.stringify(self.person), //将对象转换成json字符串
                    success: function (data) {
                        console.log(data);
                    }
                })
            },
            duixiang1:function () {
                self = this;
                $("#form").serialize();//不是一个对象
                console.log(JSON.stringify(self.person))
                $.ajax({
                    url: '${pageContext.request.contextPath}/test1',
                    type: 'post',

                    // contentType: 'application/json',
                    // contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    // 前端传的是对象 直接接收
                    //前端传的是json字符串    contentType: 'application/json',  public ModelAndView login(@RequestBody User user, HttpSession session)self.person
                    //
                    data:  $("#form").serialize(), //将对象转换成json字符串
                    success: function (data) {
                        console.log(data);
                    }
                })
            },
            duixiang2:function () {
                self = this;
                $("#form").serialize();//不是一个对象
                console.log(JSON.stringify(self.person))
                $.ajax({
                    url: '${pageContext.request.contextPath}/test1',
                    type: 'post',

                    // contentType: 'application/json',
                    // contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    // 前端传的是对象 直接接收
                    //前端传的是json字符串    contentType: 'application/json',  public ModelAndView login(@RequestBody User user, HttpSession session)self.person
                    //
                    data:  self.person, //将对象转换成json字符串
                    success: function (data) {
                        console.log(data);
                    }
                })
            }
        },
        mounted: function () {
            // this.query();
        }
    })

</script>
</html>
