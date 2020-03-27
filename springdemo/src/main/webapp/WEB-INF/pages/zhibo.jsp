<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/10
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>游戏直播_全部直播_斗鱼直播</title>
    <style type="text/css">
        html {
            margin: 0;
            padding: 0;
        }

        .left {
            float: left;
        }

        .right {
            float: right;
        }

        .allHead {
            background: #0F0502;
        }

        .head {
            width: 80%;
            margin: 0 auto;
            height: 60px;
            text-align: center;
            font-size: 20px;
            line-height: 60px;
        }

        .head .aa {
            padding: 0px 5px;
        }

        a {
            text-decoration: none;
            color: white;
        }

        .conter {
            margin-top: -18px;
            width: 100%;
            background-color: #F2F5F6;
            height: 1600px;
        }

        .conter .a {
            width: 20%;
            height: 600px;
        }

        .conter .b {
            width: 80%;
            height: 600px;
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
            margin: 10px;
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

        .fenlei ul li {
            list-style: none;
            float: left;
            margin-left: 10px;
            font-size: 16px;
            background: white;
            color: #A8AAB1;
            height: 30px;
            width: 100px;
            text-align: center;
            line-height: 30px;
            border-radius: 15px;
        }

        .fenlei ul li:hover {
            border: 3px solid #FF5D23;
            color: #FF5D23;
        }

        .wangyou ul li {
            list-style: none;
            float: left;
            font-size: 12px;
            background: white;
            text-align: center;
            margin-left: 30px;
            margin-top: 30px;
        }

        .wangyou ul li img {
            height: 100px;
            width: 100px;
        }

        .wangyou ul li:hover {
            color: #FF5D23;
            transform: scale(1.1);
        }
    </style>
</head>

<body>
<div class="allHead">
    <div class="head">
        <div class="left aa">
            <img src="${pageContext.request.contextPath}/resources/img/t4.png" style="margin: 2px;" />
        </div>
        <div class="left aa">
            <a href="">首页</a>
        </div>
        <div class="left aa">
            <a href="">直播</a>
        </div>
        <div class="left aa">
            <a href="">分类</a>
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
            <a href="">开播</a>
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
</div>
<div class="conter">
    <div class="fenlei">
        <ul>
            <p style="font-weight: 100; height: 20px;"></p>
            <p style="font-weight: 100; font-size: 30px;">全部分类</p>
            <li>推荐分类</li>
            <li>网游竞技</li>
            <li>单击热游</li>
            <li>手游休闲</li>
            <li>娱乐天地</li>
            <li>颜值</li>
            <li>语音互动</li>
            <li>正能量</li><br />
        </ul>
    </div>
    <div class="wangyou left">
        <h4 style="margin-left: 40px; color: #666666; font-weight: 100;">推荐分类</h4>
        <ul>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/a.png" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/08dcd21b98a6b71bb1d37b0c30376734.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/2ac33e6745b82a1412fda74353362e65.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/58234eb001b58e4b0b71d6aa4a818ebe.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/6b1ca7930ebf10c660f46dfda64a3f64.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/83647da52bbb6f459706f99e0655764f.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/a274c2feced94f2e543ffdd7abc7718b.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/df342455752c64f99dd7bd9518968f46.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/e3156f581df48b385f67fd1cc775f022.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
        </ul>
    </div>
    <div class="wangyou left">
        <h4 style="margin-left: 40px; color: #666666; font-weight: 100;">网游竞技</h4>
        <ul>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/08dcd21b98a6b71bb1d37b0c30376734.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/0bf17ac009cccd010676f650eb36083b.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/26dcbc48176c50af34948385545ae6da.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/38de3e53bea36b535b85674ab90c1f9e.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/3de8cf9f376ef5ee1bbb930868f7f402.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/5b18b5d30d3617fcfe75f2850eba8a3a.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/7e189c7fedb3aa96e84d9fefcc892ec1.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/833456ab222d1cdc2de8e40ffeca7a64.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/83647da52bbb6f459706f99e0655764f.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/90130d625c93d7151246d35eda06c507.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/94a11dcbc856f63006b8ed23e5216e9f.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/98b39f8048ab05b59df170c0779338bb.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/998e401fc6fcb9f9b27f66e4a7600f86.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/9f5a009b07f519a36602964f4103c6b9.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/a274c2feced94f2e543ffdd7abc7718b.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/a6a703fe378c76ba566bf76c8fbd26c5.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/be6223542ee0120ce55583432784037b.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/wangyou/db6d77a6cb58b0ff66276d412bd66111.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
        </ul>
    </div>
    <div class="wangyou left">
        <h4 style="margin-left: 40px; color: #666666; font-weight: 100;">单机热游</h4>
        <ul>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/2caac3eb966840c7d8ec1f91e6ba4151.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/f985c06df7c1d768f5f5cdf62f0118c9.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/2d00311f230050dedb6a57e773a3c425.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/3fece84c7ceef3bafbe90167cdc8ed47.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/48cbf98cf191da40a4579e7e3dd11e8a.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/4b4d86a608c006fd5a667f4e2703d8d6.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/508e2cf1922564a9684c7808fc7f3dfe.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/529f420942dcd325824b04a649177aa6.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/55c9b3966795a214c2f8dabd63269105.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/65013edab78764b692f883de1537b85b.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/6b1ca7930ebf10c660f46dfda64a3f64.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/88edc1f2ed60f600ad246c585dcfb596.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/9c2fb81cd943a4f1ad511d8cb339a584.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/9cbb7456da548f49bdaac37c199e71f5.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/c10ec6d95732013b30a0b8dc6e9245c5.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/c867f1c241bf0e4ba892174ee4ed4232.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/d19b35ea855a0d22f9cf51f2796b7f92.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/resources/img/danji/e91779ba2084aa3462ab349aaa9d2554.webp" />
                <p>英雄联盟</p>
                <p>2819.2万</p>
            </li>
        </ul>
    </div>
</div>

</body>

</html>
