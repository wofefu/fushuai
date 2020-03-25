<%--
  Created by IntelliJ IDEA.
  User: feng
  Date: 2020/1/3
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/index.css">
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="resources/js/vue.min.js"></script>
    <script src="resources/js/jquery.form.js"></script>
    <link rel="stylesheet" href="https://g.alicdn.com/de/prismplayer/2.8.7/skins/default/aliplayer-min.css"/>
    <script type="text/javascript" charset="utf-8"
            src="https://g.alicdn.com/de/prismplayer/2.8.7/aliplayer-min.js"></script>
<body>
<div>
    <div id="left">
        <div id="live">
            <%--            <span><a href="">进入直播间</a></span>--%>
        </div>
    </div>
    <div id="body">
        <div id="top">
            <ul id="topUl1">
                <li>&nbsp;</li>
                <li><a href="">TheLive</a></li>
                <li><a href="">全部</a>
                    <ul v-show="showTable" id="yTied">
                        <li><a href="">游戏</a></li>
                        <li><a href="">音乐</a></li>
                        <li><a href="">电影</a></li>
                    </ul>
                </li>

                <li v-show="!showTable"><a href="">游戏</a>
                    <ul>
                        <li><a href="">网游</a></li>
                        <li><a href="">手游</a></li>
                        <li><a href="">主机</a></li>
                    </ul>
                </li>
                <li v-show="!showTable"><a href="">音乐</a></li>
                <li v-show="!showTable"><a href="">电影</a></li>
            </ul>


            <div class="rightTop">
                <ul id="topUl2" v-show="!isLogin">
                    <li>&nbsp;</li>
                    <li v-on:click="login"><a>登录</a></li>
                    <li v-on:click="register"><a>注册</a></li>
                </ul>
                <ul id="topUl3" v-show="isLogin">
                    <li></li>
                    <li>
                        <div><img :src="user.icon" alt="bug" style="width: 50px;height: 50px;border-radius: 50px;">
                            <ul id="info">
                                <li><a href="toInfo" style="cursor: pointer;">个人中心</a></li>
                                <li>
                                    <div>
                                        <table>
                                            <tr>
                                                <td>关注</td>
                                                <td>粉丝</td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>1</td>
                                            </tr>
                                        </table>
                                    </div>
                                </li>
                                <li @click="logout">退出登录</li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <div id="searchbox" v-show="showSearchBox" @mouseleave="hiddenSearchResult" @mouseenter="showSearchResult">
                <div><input v-model="search.searchKeyWord" type="text" @input="searchByKeyWord"><img
                        src="resources/img/sosuo.png"
                        alt="bug"></div>
                <div id="searchResult">
                    <select name="orderBy" id="orderByType" v-model="search.orderByType">
                        <option value="looking">当前观众</option>
                        <option value="timing">开播时间</option>
                    </select>
                    <select name="status" id="status" v-model="search.status">
                        <option value="all">全部</option>
                        <option value="online">在线</option>
                    </select>
                    <table>
                        <tr v-for="(item,index) in searchResult" :key="index">
                            <td>{{item.nickname}}</td>
                            <td>{{item.roomName}}</td>
                            <td>{{item.anchorStatus}}</td>
                            <br>
                        </tr>
                    </table>

                </div>
            </div>
        </div>

        <div id="right">

            <div v-for="(item,index) in lives" @mouseenter="loadLive(item.roomUri)">
                <img :src="item.img" alt="" style="width: 200px;height:100px;z-index: 1;">
            </div>
            <br>
        </div>
        <div id="down">
        </div>
        <div id="back" v-show="ifTure">
            <div id="login" v-show="ifLogin">
                <img src="resources/img/cha.png" alt="bug" class="exitMiddle" @click="exitMiddle">
                <h2>登录</h2>
                <div class="inputBox">
                    <input type="text" v-model="username" required>
                    <label>用户名</label>
                </div>
                <div class="inputBox">
                    <input type="password" v-model="password" required>
                    <label>密码</label>
                </div>
                <button @click="loginVerify" class="buttonL">登录</button>
                <button v-on:click="register" class="buttonR">注册</button>
            </div>
            <div id="register" v-show="ifRegister">
                <%--            <img src="resources/img/cha.png" alt="bug" class="exitMiddle" @click="exitMiddle">--%>
                <h2>注册</h2>
                <form enctype="multipart/form-data" id="registerForm">
                    <div style="text-align: center;border-radius: 120px;">
                        <img src="icon" alt="用户头像" id="icon" @click="upload()" width="120px" height="120px"
                             style="border-radius: 60px;display: inline-block">
                        <input type="file" id="file" name="myicon" style="display: none">
                    </div>
                    <div class="inputBox">
                        <input type="text" name="username" v-model="username" required="">
                        <label>用户名</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="password" v-model="password" required="">
                        <label>密码</label>
                    </div>
                    <input type="submit" style="display: none">
                    <button @click="registerVerify" class="buttonL" type="button">注册</button>
                    <button @click="login" class="buttonR" type="button">登录</button>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    let app;
    var self;
    var player = new Aliplayer({
            id: 'live',
            source: "http://push.chenchiding.com/kd-27/182422895381.flv",
            "width": "100%",
            "height": "600px",
            "autoplay": true,
            "rePlay": false,
            "playsinline": true,
            "preload": true,
            "isLive": true,
            "definition": 'FD',
            "liveForceLoad": true,
            "controlBarVisibility": "hover",

        }, function () {
            console.log("The player is created");
            app = new Vue({
                el: "#body",
                data: {
                    username: '',
                    password: '',
                    isLogin: false,
                    user: {},
                    user_id: 1,
                    lives: [],
                    searchResult: [],
                    player: '',
                    path: '',
                    search: {
                        orderByType: '',
                        status: '',
                        searchKeyWord: '',
                        pageMax: 5,
                        pageIndex: 1,
                    },
                    showTable: false,
                    showSearchBox: true,
                    ifLogin: false,
                    ifRegister: false,
                    ifTure: false,
                },
                methods: {
                    createPlayer: function () {

                    },
                    loadLive: function (url) {
                        if (url === self.path) {

                        } else {
                            self.path = url;
                            console.log(url);
                            player.loadByUrl(url)
                        }
                    },
                    personInfo: function () {
                        $.post("toInfo", {user: self.user}
                        )
                    },
                    loadHotLive: function () {
                        $.ajax({
                            url: "select5Live",
                            type: "post",
                            data: {},
                            success: function (result) {
                                self.lives = result;
                                self.path = self.lives[0].roomUri;
                                if (player._isReady) {
                                    console.log(self.path);
                                    player.loadByUrl(self.path);
                                    console.log(player._status);
                                    player.play();
                                }
                            }
                        })
                    },
                    goToLive: function (path) {

                    },
                    hiddenSearchResult: function () {
                        $("#searchResult").hide();
                    },
                    showSearchResult: function () {
                        $("#searchResult").show();
                    },
                    searchByKeyWord: function () {
                        $("#searchResult").show();
                        $.ajax({
                            url: "searchByKeyWord",
                            type: "Post",
                            data: self.search,
                            success: function (result) {
                                console.log(result);
                                self.searchResult = result;
                            }
                        })
                    },
                    logout: function () {
                        self.user = '';
                        $.ajax({
                            url: "logout",
                            type: "Post",
                            success: function () {
                                self.isLogin = false;
                            }
                        })
                    },
                    exitMiddle: function () {
                        self.ifLogin = false;
                        self.ifRegister = false;
                        self.ifTure = false;
                    },
                    registerVerify: function () {
                        var tmp = document.getElementById("registerForm");
                        var form = new FormData(tmp);
                        $.ajax({
                            url: "registerVerify",
                            type: 'POST',
                            cache: false,
                            data: form,
                            processData: false,
                            contentType: false,
                            dataType: "JSON",
                            success: function (result) {
                                console.log(result);
                                self.user = result;
                                self.exitMiddle();
                                self.clearInput();
                                alert("注册成功");
                            },
                            error: function (err) {
                                alert("注册失败")
                            }
                        });
                    },
                    loginVerify: function () {
                        $.ajax({
                            url: "loginVerify",
                            type: 'post',
                            data: {
                                username: self.username,
                                password: self.password
                            },
                            success: function (result) {
                                console.log(result);
                                self.user = result;
                                self.clearInput();
                                self.isLogin = !self.isLogin;
                                self.exitMiddle();
                            },
                            dataType: "JSON",
                        })
                    },
                    clearInput: function () {
                        self.username = '';
                        self.password = '';
                    },
                    login: function () {
                        self.clearInput();
                        self.ifRegister = false;
                        self.ifLogin = !self.ifLogin;
                        self.ifTure = true;
                        self.clearInput();
                    },
                    register: function () {
                        self.clearInput();
                        self.username = '';
                        self.password = '';
                        self.ifLogin = false;
                        self.ifRegister = !self.ifRegister;
                        self.ifTure = true;
                    },
                    upload: function () {
                        var ele = document.getElementById("file");
                        ele.click();
                        ele.onchange = function () { // 文本框内容改变时触发
                            var files = this.files; // 获取文件的数量
                            self.readers(files[files.length - 1])
                        }
                    },
                    readers: function (fil) {
                        var reader = new FileReader(); // 异步读取存储在用户计算机上的文件
                        reader.readAsDataURL(fil); // 开始读取指定的Blob对象或File对象中的内容
                        reader.onload = function () {
                            // document.getElementById("dd").innerHTML += "<img src='"+reader.result+"'>";  // 添加图片到指定容器中
                            document.getElementById("icon").setAttribute("src", reader.result);
                        };
                    },
                },
                mounted() {
                    self = this;
                    setTimeout(self.loadHotLive, 3000);
                    setTimeout(player.play(), 5000);
                }
            });
        }
    );


    window.onresize = function () {
        //可用于设置自适应屏幕，根据获得的可视宽度（兼容性）判断是否显示
        var w = window.document.body.clientWidth;
        if (w < 1200) {
            app.showTable = true;
        }
        if (w > 1200) {
            app.showTable = false;
        }
        if (w < 800) {
            app.showSearchBox = false;
        }
        if (w > 800) {
            app.showSearchBox = true;
        }
    };
</script>

</html>
