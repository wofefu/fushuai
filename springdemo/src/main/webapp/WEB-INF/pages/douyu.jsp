<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/10
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>斗鱼-每个人的直播平台</title>
    <style type="text/css">
        .left {
            float: left;
        }

        .right {
            float: right;
        }

        body {
            background-image: url(${pageContext.request.contextPath}/resources/img/denglu/timgb.jpg);
            background-size: cover;
            background-repeat: no-repeat;
        }

        #head {
            width: 80%;
            margin: 0 auto;
        }

        a {
            text-decoration: none;
            color: white;
        }

        .a {
            /*	background: midnightblue;*/
            width: 100%;
            height: 50px;
            text-align: center;
            font-size: 20px;
            line-height: 50px;
        }

        .aa {
            padding: 0px 5px;
        }

        .aa img {
            height: 40px;
            width: 40px;
            border-radius: 20px;
            margin-top: 5px;
        }

        .b {
            width: 80%;
            height: 600px;
        }

        .b video {
            width: 100%;
            height: 600px;
        }

        .c {
            /*background: cadetblue;*/
            width: 20%;
            height: 600px;
        }

        .cc {
            height: 80px;
            margin: 10px 5px 10px 10px;
        }

        .c img {
            height: 80px;
            width: 100%;
        }

        #tupian div:hover {
            border: 3px solid gold;
            cursor: pointer;
        }

        .bar7 form {
            height: 32px;
        }

        .bar7 input {
            width: 250px;
            border-radius: 42px;
            border: 2px solid #324B4E;
            background: #F9F0DA;
            transition: .3s linear;
            float: right;
        }

        .bar7 input:focus {
            width: 200px;
        }

        .bar7 button {
            background: none;
            top: -2px;
            right: 20px;
        }

        .bar7 button:before {
            content: "Search";
            font-family: FontAwesome;
            color: #324b4e;
            height: 32px;
            line-height: 32px;
        }

        div.search {
            padding: 9px 0;
        }

        form {
            position: relative;
            width: 200px;
            margin: 0 auto;
        }

        input,
        button {
            border: none;
            outline: none;
        }

        input {
            width: 100%;
            height: 32px;
            padding-left: 13px;
        }

        button {
            height: 32px;
            width: 42px;
            cursor: pointer;
            position: absolute;
        }
    </style>
    <link rel="stylesheet" href="https://g.alicdn.com/de/prismplayer/2.8.2/skins/default/aliplayer-min.css"/>
    <script charset="utf-8" type="text/javascript"
            src="https://g.alicdn.com/de/prismplayer/2.8.2/aliplayer-min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>

<body>
<div id="head">
    <div class="left a">
        <div class="left aa">
            <img src="${pageContext.request.contextPath}/resources/img/douyu1.png"/>
        </div>
        <div class="left aa">
            <a href="">首页</a>
        </div>
        <div class="left aa">
            <a href="${pageContext.request.contextPath}/all/zhiboshezhi">直播</a>
        </div>
        <div class="left aa">
            <a href="${pageContext.request.contextPath}/all/zhibo">分类</a>
        </div>
        <div class="left aa">
            <a href="">视频</a>
        </div>
        <div class="left aa">
            <a href="">鱼吧</a>
        </div>

        <div class="right aa">
            <a href="">关注</a>
        </div>
        <div class="right aa">
            <a href="${pageContext.request.contextPath}/kaibo">开播</a>
        </div>
        <div class="right aa">
            <a href="">客户端</a>
        </div>
        <div class="search bar7 right aa">
            <form>
                <input type="text" placeholder="主播、房间、分类" name="crid">
                <button type="submit"></button>
            </form>
        </div>
    </div>
    <div class="left b">
        <%--        <video src="${pageContext.request.contextPath}/resources/img/1122.mp4" controls></video>--%>
        <div class="prism-player" id="J_prismPlayer" style="width: 100%;height: 600px;"></div>
    </div>
    <div id="qiehuan">
        <div id="tupian" class="left c">
            <div class="left cc">
                <img src="${pageContext.request.contextPath}/resources/img/denglu/timgd.jpg" @click="qie1()">
            </div>
            <div class="left cc">
                <img src="${pageContext.request.contextPath}/resources/img/denglu/ti.jpg" @click="qie2()">
            </div>
            <div class="left cc" >
                <img src="${pageContext.request.contextPath}/resources/img/denglu/timga.jpg" @click="qie3()">
            </div>
            <div class="left cc">
                <img src="${pageContext.request.contextPath}/resources/img/denglu/timgc.jpg" @click="qie4()">
            </div>
            <div class="left cc">
                <img src="${pageContext.request.contextPath}/resources/img/denglu/timgb.jpg" @click="qie5()">
            </div>
            <div class="left cc">
                <img src="${pageContext.request.contextPath}/resources/img/renwu.jpeg" @click="qie6()">
            </div>
        </div>
    </div>
</div>
</body>
<script>
    let app;
    let play;
    player = new Aliplayer({
        id: 'J_prismPlayer',

        height: '100%',
        autoplay: true,
        // isLive: true,
        //支持播放地址播放,此播放优先级最高
        source: 'http://push.chenchiding.com/kd27/18756759293.flv',
        useH5Prism: true,
        definition: 'FD'

    }, function (player) {
        console.log('播放器创建好了。')
        app = new Vue({
            el: "#qiehuan",
            data: {},
            methods: {
                qie1: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/1.flv");
                },
                qie2: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/2.flv");
                },
                qie3: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/3.flv");
                },
                qie4: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/4.flv");
                },
                qie5: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/5.flv");
                },
                qie6: function () {
                    // let url = e.target.innerHTML;
                    // console.log(e.target.innerHTML);
                    player.loadByUrl("http://push.chenchiding.com/kd27/6.flv");
                },

            }
        })
    });

</script>
</html>
