<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="../../resources/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://g.alicdn.com/de/prismplayer/2.8.7/skins/default/aliplayer-min.css" />
    <script type="text/javascript" charset="utf-8" src="https://g.alicdn.com/de/prismplayer/2.8.7/aliplayer-min.js"></script>
    <title>Document</title>
</head>
<body>
<div id="live"></div>
<input type="text" id="path">${requestScope.path}
</body>
<script>
    var str=;
    var player = new Aliplayer({
            "id": "live",
            "source":str,
            "width": "100%",
            "height": "500px",
            "autoplay": true,
            "isLive": true,
            "rePlay": false,
            "playsinline": true,
            "preload": true,
            "controlBarVisibility": "hover",
            "useH5Prism": true
        }, function (player) {
            console.log("The player is created");
        }
    );
</script>
</html>