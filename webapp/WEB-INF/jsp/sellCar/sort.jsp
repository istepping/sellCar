<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%--
Created by IntelliJ IDEA.
User: 黄伟 杨圳达
Date: 2018/7/18
Time: 21:06
To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>汽车分类</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/carSort/sort.css" rel="stylesheet">
    <script>
        function gotoURL() {
            self.location.href="/sellCar/login/userLogin";//填写返回登陆界面网址
        }
    </script>
</head>

<body bgcolor="#FOFFFF">
<!--导航栏-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/sell/home?uId=${uId}">商城首页</a>
        </li>
        <!-- Dropdown -->
        <li class="nav-item dropdown active">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                汽车分类
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/sell/sort?cCatalog=SUV&uId=${uId}">SUV</a>
                <a class="dropdown-item" href="/sell/sort?cCatalog=sportCar&uId=${uId}">跑车</a>
                <a class="dropdown-item" href="/sell/sort?cCatalog=NEV&uId=${uId}">新能源车</a>
            </div>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/sell/userCentral/me?uId=${uId}">个人中心</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link disabled" data-toggle="modal" data-target="#myModal" href="/sell/userCentral/logOut">用户注销</a>
            <!-- 模态框 -->
            <div class="modal fade tip" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- 模态框头部 -->
                        <div class="modal-header">
                            <h4 class="modal-title">系统提示</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- 模态框主体 -->
                        <div class="modal-body">
                            您确认要离开吗？
                        </div>
                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="gotoURL();">确定</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</nav>
<div class="title"><h1><a class="box">${cCatalog}</a></h1></div>
<div class="car">
<c:forEach items="${cars}" var="car">
        <div class="body">
            <div class="img">
                <img src="${car.getcUrl()}" height="200px" width="300px"/>
            </div>
            <div class="name">
                <p>${car.getcBrand()}</p>
            </div>
            <div class="info">
                <div class="info_price"><p>${car.getcPrice()}</p></div>
                <div class="info_buy"><a href="/sell/detail?id=${car.getcId()}&uId=${uId}">购买</a></div>
            </div>
        </div>
</c:forEach>
</div>
</body>

