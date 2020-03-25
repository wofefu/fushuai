<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的微博</title>
    <script src="resources/js/jquery-3.4.1.min.js"></script>
    <script src="resources/js/vue.js"></script>
    <link rel="stylesheet" href="resources/css/personal.css">
    <link rel="stylesheet" href="resources/css/userdata.css">
    <link rel="stylesheet" href="resources/css/index.css">
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
        <div class="menu"><span onclick="location.href='update'">个人资料</span></div>
        <div class="menu">
            <span onclick="toUploadPhoto()">修改头像</span></div>
        <div class="menu active"><span>我的微博</span></div>
    </div>

    <div class="editarea">
        <div class="user-data">${count.num1}条微博</div>
        <div class="user-data">被赞过${count.num2}次</div>
        <div class="user-data">点过${count.num3}次赞</div>
        <div id="vue-area">
            <div class="blogs">
                <div class="blog" v-for="(Blog,index) in blogs" :key="index">
                    <div class="blog-user">
                        <img class="blog-icon" v-bind:src="Blog.icon">
                        <div class="blog-date">
                            <span class="name">{{Blog.nickName}}</span>
                            <span class="time">{{Blog.createTime}}</span>
                        </div>
                    </div>
                    <div class="blog-content">

                        <div class="blog-text">{{Blog.content}}</div>
                        <hr style="width: 100%">
                        <div class="blog-comment">
                            <span id="praiseNum">{{Blog.praiseNum}}</span>
                            <span>赞</span>
                        </div>
                    </div>
                    <div>
                        <button @click="delBlog(Blog.id,index)">删除</button>
                    </div>
                </div>
            </div>
            <div style="text-align: center">
                <button @click="loadMore()" v-if="hasMore">加载更多</button>
                <span v-if="!hasMore">没有更多了</span>
            </div>
        </div>
    </div>
</div>
</body>
<script>function toUploadPhoto() {
    location.href = "icon";
}</script>
<script>

    var app = new Vue({
        el: "#vue-area",
        data: {
            blogs: [],
            minBlogId: -1,
            hasMore: true
        },
        methods: {
            loadData: function () {
                var self = this;
                var url="myBlog?minBlogId="+this.minBlogId;
                $.get(url, function (result) {
                    self.blogs = self.blogs.concat(result);
                    if (result.length <5) {
                        self.hasMore = false
                    } else {
                       self.minBlogId=  self.blogs[self.blogs.length-1].id
                    }
                });
            },
            loadMore: function () {
                //加载更多的方法
                this.loadData();
            },
            delBlog: function (id,index) {
                var self = this;
                $.post("delete",{blogId:id},function (result,staus) {
                    if (staus==="success"){
                        self.blogs.splice(index,1);
                    }
                })
            }
        },
        mounted: function () {

            this.loadData();
        }
    })

</script>
</html>
