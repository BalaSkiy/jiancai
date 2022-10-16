
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
<%--    <script type="text/jquery-3.4.1.js" src="jquery-3.4.1.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginForm">
        姓名:<input type="text" name="uname" id="uname" value="${messageModel.object.userName}"> <br>
        密码:<input type="password" name="upwd" id="upwd" value="${messageModel.object.userPwd}"> <br>
        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form>
</div>
</body>
<script type="text/javascript">
    $("#loginBtn").click(function () {
        //获取用户姓名和密码的值
        var uname=$("#uname").val();
        var upwd=$("#upwd").val();
        if(isEmpty(uname)){
            //如果姓名为空，提示用户（span标签赋值），并且return html()
            $("#msg").html("用户姓名不可为空");
            return;
        }
        //判断密码是否为空
        if(isEmpty(upwd)){
            //如果密码为空，提示用户（span标签赋值），并且return html()
            $("#msg").html("用户密码不可为空");

            alert("密码不一致");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#loginForm").submit();
    });
    //判断字符串是否为空
    function isEmpty(str) {
        if(str == null || str.trim() ==""){
            return true;
        }
        return false;
    }
</script>
</html>
