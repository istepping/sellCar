<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/20
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userRegister.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/sellCar/login/userLogin">返回登陆界面</a>
        </li>
    </ul>
</nav>
<div class="container mt-3">
    <h3 class="top red">注册账号</h3>
    <br>
    <p>欢迎注册<span class="red">神州汽车</span>账号！</p>
    <p>请在下面的输入框中填写你的注册信息：</p>

    <form action="/sellCar/login/userRegister/submit">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">用户名</span>
            </div>
            <input type="text" class="form-control" placeholder="Username" id="usr" name="username">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">用户密码</span>
            </div>
            <input type="password" class="form-control" placeholder="Password" id="password" name="password">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">确认你的密码</span>
            </div>
            <input type="password" class="form-control" placeholder="Check Your Password" id="check" name="check">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">你的手机号</span>
            </div>
            <input type="text" class="form-control" placeholder="phone" id="phone" name="phone">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">你的地址</span>
            </div>
            <input type="text" class="form-control" placeholder="Address" id="address" name="address">
        </div>
        <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#myModal">注册</button>
    </form>
</div>

</body>
</html>
