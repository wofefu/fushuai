<%--
  Created by IntelliJ IDEA.
  User: feng
  Date: 2020/1/12
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/info.css">
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="resources/js/vue.min.js"></script>
    <script src="resources/js/jquery.form.js"></script>
</head>

<body>
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

            <ul id="topUl3" v-show="isLogin">
                <li></li>
                <li>
                    <div><img :src="icon" alt="bug" style="width: 50px;height: 50px;border-radius: 50px;">
                        <ul id="info">
                            <li>个人中心</li>
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
                    src="../../resources/img/sosuo.png" alt="bug"></div>
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
    <div id="main">
        <div id="main_left">
            <ul>
                <li style="background-color: dimgrey">个人中心</li>
                <li @click="showMyInfo">我的信息</li>
                <li @click="showSource">账号安全</li>
                <li v-show="!isStreamer" @click="showCertification">主播认证</li>
                <li v-show="isStreamer" @click="showStreamerManage">直播管理</li>
                <li v-show="isAdmin" @click="showRequestForms">认证审核</li>
                <li v-if="isStreamer"></li>
            </ul>
        </div>
        <div id="main_right">
            <div id="myInfo" v-show="myInfo">
                <form id="infoForm" enctype="multipart/form-data">
                    <table>
                        <div style="background-color: dimgrey;border-bottom-style: solid;border-width: 01px;height: 48px;">
                            我的信息
                        </div>
                        <div style="text-align: center;border-radius: 120px;">
                            <img :src="user.icon" alt="用户头像" id="icon" @click="changeImp('file','icon')" width="
                            120px" height="120px" style="border-radius: 60px;display: inline-block">
                            <input type="file" id="file" name="myIcon" style="display: none">
                        </div>
                        <tr>
                            <td class="lefttd">昵称:</td>
                            <td><input type="text" name="username" v-model="user.username">
                            </td>
                        </tr>
                        <tr>
                            <td>用户id</td>
                            <td><input type="text" name="userId" readonly v-model="user.userId"></td>
                        </tr>
                        <tr>
                            <td class="lefttd" id="user.myWord">个性签名:</td>
                            <td>
                                <textarea name="myWord" id="" cols="30" rows="3"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="lefttd">性别:</td>
                            <td>
                                <input type="radio" name="gender" value="1">男
                                <input type="radio" name="gender" value="-1">女
                                <input type="radio" name="gender" value="0">保密
                            </td>
                        </tr>
                        <tr>
                            <td class="lefttd">出生日期:</td>
                            <td><input type="date" name="birthday" value="user.birthday"></td>
                        </tr>
                    </table>
                </form>
                <button @click="modifyInfo">保存</button>
            </div>
            <div id="source" v-show="source" style="display: none">
                <form>
                    请输入旧密码: <input type="password" v-model="p1" required>
                    <br>
                    请输入新密码: <input type="password" v-model="p2">
                    <br>
                    请重复新密码: <input type="password" v-model="p3">
                    <br>
                    <button @click="modifyPassword" type="button">提交</button>
                </form>
            </div>
            <div id="Certification" v-show="certification & !isStreamer">

                <form enctype="multipart/form-data" id="cetify">
                    <table>
                        <tr>
                            <td class="lefttd">姓名:</td>
                            <td><input type="text" name="idCardName"></td>
                        </tr>
                        <tr>
                            <td class="lefttd">身份证号:</td>
                            <td><input type="text" name="idCardNo"></td>
                        </tr>
                    </table>
                    <div id="image">
                        <img src="https://static.hdslb.com/account/img/img2.png?1" alt="bug1" id="img1"
                             @click="changeImp('file1','img1')" style="width: 180px;height: 120px;">
                        <input type="file" name="file1" id="file1" v-show="false">
                        <img src="https://static.hdslb.com/account/img/img3.png?1" alt="bug2" id="img2"
                             @click="changeImp('file2','img2')" style="width: 180px;height: 120px;">
                    </div>
                    <input type="file" name="file1" id="file2" v-show="false">
                </form>
                <button @click="getCertificatesResult">提交</button>
            </div>
            <div id="streamerManage" v-show="isStreamer&&streamerManage">
                <form enctype="multipart/form-data" id="liveInfo">
                    <table>
                        <tr>
                            <td>直播间标签</td>
                            <td><input type="text" name="roomTag" v-model="live.roomTag"></td>
                        </tr>
                        <tr>
                            <td>直播间名称</td>
                            <td><input type="text" name="roomName" v-model="live.roomName"></td>
                        </tr>
                        <tr>
                            <td>主播名称</td>
                            <td><input type="text" name="nickname" v-model="live.nickname"></td>
                        </tr>
                        <tr>
                            <td>直播间地址</td>
                            <td>{{live.roomUri}}</td>
                        </tr>
                        <tr>
                            <td>直播间状态</td>
                            <td cowspan="2"><input type="radio" name="anchorStatus" value="开播">开播
                                <input type="radio" name="status" value="下播">下播
                            </td>
                        </tr>
                        <tr>
                            <td>直播间图片</td>
                            <td>
                                <input type="file" name="img1"></input>
                            </td>
                        </tr>
                        <tr>
                            <td>直播保存录像</td>
                            <td cowspan="2"><input type="radio" name="recording" value="是">是<input type="radio"
                                                                                                name="record" value="否">否
                            </td>
                        </tr>

                    </table>
                </form>
                <button @click="sendNewLiveInfo">保存</button>
            </div>
            <div id="manageRequest" v-show="isAdmin&&requestForms">
                <div>
                    <table>
                        <tr>
                            <td>表单id</td>
                            <td>申请人姓名</td>
                            <td>申请人身份证号码</td>
                            <td>用户id</td>
                            <td>api验证结果</td>
                            <td>照片</td>
                            <td>操作</td>
                        </tr>
                        <tr v-for="(item,index) in requestFormList" :key="index">
                            <td>{{item.id}}</td>
                            <td>{{item.realName}}</td>
                            <td>{{item.idCard}}</td>
                            <td>{{item.userId}}</td>
                            <td>{{item.apiResult}}</td>
                            <td @click="watchImg(index)">点我查看</td>
                            <td cowspan="2"><span @click="agreeRequest(index)">同意</span><span @click="disagree(index)">不同意</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div v-show="showImg">
                <img :src="facadeImg" alt="" height="200px" width="300px">
                <img :src="backImg" alt="" height="200px" width="300px">
            </div>
        </div>
    </div>
</div>
<input type="text" id="user" style="display: none" value="${user}">
<input type="text" id="icon1" style="display: none" value="${user.icon}">
<input type="text" id="home" style="display: none" value="${user.home}">
<input type="text" id="gender" style="display: none" value="${user.gender}">
<input type="text" id="userId" style="display: none" value="${user.userId}">
<input type="text" id="birthday" style="display: none" value="${user.birthday}">
<input type="text" id="roleList" style="display: none" value="${user.roleList}">
<input type="text" id="password" style="display: none" value="${user.password}">
<input type="text" id="username" style="display: none" value="${user.username}">
</body>
<script type="text/javascript">
    var roleList = "${user.roleList}";
    var role = "${user}";
    var self;
    var app = new Vue({
        el: "#body",
        data: {
            showImg: false,
            facadeImg: '',
            backImg: '',
            myInfo: true,
            source: false,
            streamerManage: false,
            certification: false,
            requestForms: false,
            isLogin: true,
            user: {
                userId: '',
                gender: '',
                home: '',
                icon: '',
                birthday: '',
                attentions: '',
                liveId: '',
                roleList: [],
                username: '',
                password: '',

            },

            p1: '',
            p2: '',
            p3: '',
            requestFormList: [],
            lives: [],
            live: {},
            searchResult: [],
            fileId: '',
            imgId: '',
            isAdmin: false,
            isStreamer: false,
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
            certificatesResult1: '',
            certificatesResult2: '',
        },
        methods: {
            sendNewLiveInfo:function(){
                var  form = new  FormData(document.getElementById("liveInfo"));
                form.append("userId",self.user.userId);
                $.ajax({
                    url:"updateLiveInfo",
                    type:"Post",
                    cache: false,
                    data: form,
                    processData: false,
                    contentType: false,
                    dataType: "JSON",
                    success:function (result) {
                        console.log(result);
                        self.live=result;
                    }
                })
            },
            agreeRequest: function (index) {
                console.log(index);
                let userId1 = self.requestFormList[index].userId;
                let requestId = self.requestFormList[index].id;
                $.ajax({
                    url: "addLive",
                    type: "post",
                    data: {
                        userId: userId1,
                        requestId: requestId
                    },
                    success: function () {
                        self.requestFormList.splice(index, 1)
                    }
                })
            },
            disagree: function (index) {
                let requestId = self.requestFormList[index].id;
                console.log(index);
                console.log(requestId);
                $.ajax({
                    url: "disagree",
                    type: "post",
                    data: {
                        requestId: requestId
                    },
                    success: function () {
                        self.requestFormList.splice(index, 1)
                    }
                })
            },
            watchImg: function (index) {
                self.showImg = !self.showImg;
                self.facadeImg = self.requestFormList[index].facadePath;
                self.backImg = self.requestFormList[index].backPath;
            },
            getCertificatesResult: function (str) {
                var form = new FormData(document.getElementById("cetify"));
                form.append("userId", self.userId);
                $.ajax({
                    url: "certification",
                    type: "post",
                    cache: false,
                    data: form,
                    processData: false,
                    contentType: false,
                    dataType: "JSON",

                    success: function (result) {
                        alert(result)
                    }
                })
            },
            modifyPassword: function () {
                if (self.p1 !== self.password) {
                    console.log("密码错误")
                } else {
                    if (self.p2 !== self.p3) {
                        console.log("密码不一致")
                    } else {
                        $.ajax({
                            url: "modifyPassword",
                            type: "post",
                            data: {
                                userId: self.userId,
                                password: self.p2
                            },
                            success: function () {
                                console.log("修改成功");
                                self.password = self.p2;
                            }
                        })
                    }
                }
            },
            modifyInfo: function () {
                var tmp = document.getElementById("infoForm");
                var form = new FormData(tmp);
                $.ajax({
                    url: "modifyInfo",
                    type: 'Post',
                    cache: false,
                    data: form,
                    processData: false,
                    contentType: false,
                    dataType: "JSON",
                    success: function (result) {
                        self.user = result;
                    }
                })
            },
            showStreamerManage: function () {
                self.myInfo = false;
                self.source = false;
                self.certification = false;
                self.requestForms = false;
                self.streamerManage = true;
                $.ajax({
                    url: "searchLive",
                    type: "post",
                    data: {userId: self.user.userId},
                    success: function (result) {
                        self.live = result
                    }
                })
            },
            showRequestForms: function () {
                self.myInfo = false;
                self.source = false;
                self.certification = false;
                self.requestForms = true;
                self.streamerManage = false;
                $.ajax({
                    url: "allRequestForm",
                    type: "Post",
                    success: function (result) {
                        self.requestFormList = result;
                    }
                })
            },
            showMyInfo: function () {
                self.myInfo = true;
                self.source = false;
                self.certification = false;
                self.streamerManage = false;
                self.requestForms = false;
            },
            showSource: function () {
                self.myInfo = false;
                self.streamerManage = false;
                self.source = true;
                self.certification = false;
                self.requestForms = false;
            },
            showCertification() {
                self.myInfo = false;
                self.streamerManage = false;
                self.source = false;
                self.certification = true;
                self.requestForms = false;
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
            changeImp: function (file, img) {
                self.fileId = file;
                self.imgId = img;
                self.upload();
            },
            upload: function () {
                var ele = document.getElementById(self.fileId);
                console.log(ele);
                document.getElementById(self.fileId).click();
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
                    document.getElementById(self.imgId).setAttribute("src", reader.result);
                };
            },
        },
        mounted() {
            console.log(roleList.length);
            self = this;
            self.user.userId = document.getElementById("userId").value;
            self.user.username = document.getElementById("username").value;
            self.user.gender = document.getElementById("gender").value;
            self.user.home = document.getElementById("home").value;
            self.user.birthday = document.getElementById("birthday").value;
            self.user.roleList = document.getElementById("roleList").value;
            self.user.icon = document.getElementById("icon1").value;
            self.user.password = document.getElementById("password").value;
            if (roleList.search("STREAMER") !== -1) {
                self.isStreamer = true;
            }
            if (roleList.search("SUPERADMIN") !== -1) {
                self.isAdmin = true;
            }
        }
    });
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
