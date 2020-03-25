function pre() {
    var temp = parseInt(document.getElementById("page").innerText);
    if (temp == 1) {
        return;
    }
    window.location.href = "index?page=" + (temp - 1);
}

function NextPage() {
    var temp = parseInt(document.getElementById("page").innerText);
    window.location.href = "index?page=" + (temp + 1);
}

function fabu() {
    var content = document.getElementById("content").innerText;
    // document.getElementById("hidden-content").value=content;
    document.getElementById("hidden-content").innerText = content;
    document.getElementById("hidden-submit").click();
    // window.location.href = "content?content=" + content;
}

function initPlaceholder() {
    if ($("#content").text().trim().length === 0) {
        $("#content").css('color', '#828282');
        $("#content").text('又写Bug了?');
    }
}

function checkContent() {
    if ($("#content").text() === '又写Bug了?') {
        $("#content").text('');
        $("#content").css('color', '#4f4f4f')
    }
}

function dianzan(ele, id) {
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.status == 200 && req.readyState == 4) {
            var temp = parseInt($(ele).next().text())
            if (ele.getAttribute("src") == "resources/img/dianzan.jpg") {
                $(ele).attr("src", "resources/img/p1.jpg")
                $(ele).next().text(--temp);
            } else {
                $(ele).attr("src", "resources/img/dianzan.jpg")
                $(ele).next().text(++temp);
            }
        }
    }
    req.open("GET", "praise?blogId=" + id);
    req.send();
}