<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改头像</title>
    <link rel="stylesheet" href="resources/css/personal.css">
</head>

<body>
<div class="header">
    <div><img src="${sessionScope.user.icon}" alt="" class="icon">
        <span>${sessionScope.user.nickName}</span>
    </div>

    <div class="logout" ><span onclick="location.href='index'">首页</span><span onclick="location.href='logout'">注销</span></div>
</div>

<div class="main">
    <div class="aside">
        <div class="menu"><span onclick="location.href='update'">个人资料</span></div>
        <div class="menu active">
            <span>修改头像</span></div>
        <div class="menu">
            <span onclick="Count()">我的微博</span></div>
    </div>

    <div class="editarea">
        <form action="icon" method="post" enctype="multipart/form-data"
        onsubmit="return checkFile()">



            <div class="info-item" style="margin-top: 40px;flex-direction: column;">
                <img id="icon" src="${sessionScope.user.icon}" alt="bug" style="width: 150px;height: 150px;border-radius: 75px" onclick="chooseFile()">
                <input id="file" type="file" name="icons" value="${sessionScope.user.nickName}" style="display: none" >

            </div>


            <div class="info-item" style="margin-top: 40px">

                <button id="update">提交修改</button>

            </div>
        </form>
    </div>


</div>
</body>
<script>function chooseFile(){
    var ele = document.getElementById("file");
    ele.click();



    ele.onchange = function(){  // 文本框内容改变时触发
        var files = this.files; // 获取文件的数量

            readers(files[files.length-1])

    }
    function readers(fil){
        var reader = new FileReader();  // 异步读取存储在用户计算机上的文件
        reader.readAsDataURL(fil); // 开始读取指定的Blob对象或File对象中的内容
        reader.onload = function(){
            // document.getElementById("dd").innerHTML += "<img src='"+reader.result+"'>";  // 添加图片到指定容器中
            document.getElementById("icon").setAttribute("src",reader.result);
        };
    }
}
       function checkFile() {
           var ele=document.getElementById("file");
           if (ele.files.length==0){
               alert("没有选择文件")
               return false;
           }else {
               return true;
           }
       }
function Count() {
    location.href = "count";
}
</script>
</html>
