<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/11
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://g.alicdn.com/de/prismplayer/2.8.2/skins/default/aliplayer-min.css" />
    <script charset="utf-8" type="text/javascript" src="https://g.alicdn.com/de/prismplayer/2.8.2/aliplayer-min.js"></script>
</head>

<body>
<div class="prism-player" id="J_prismPlayer" style="width: 960px;height: 540px;"></div>
<script>



    let player = new Aliplayer({
        id: 'J_prismPlayer',

        height: '100%',
        autoplay: true,
        // isLive: true,
        //支持播放地址播放,此播放优先级最高
        source: 'http://push.chenchiding.com/kd27/18756759293.flv',
        definition: 'FD',
        useH5Prism:true,

    }, function(player) {
        console.log('播放器创建好了。')
        player.loadByUrl("http://push.chenchiding.com/kd27/1.flv");
    });

    // function tiaozhuan() {
    //     player.loadByUrl("http://push.chenchiding.com/kd27/18756759293.flv");
    //     // player._staus   判断是否在直播
    // }
</script>
</body>

</html>
