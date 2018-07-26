
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--@author 杨圳达&黄伟-->
<!--@time 2018/7/15-->
<!--@apiNote 车辆管理界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员首页</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/manager/managerHome.css"  rel="stylesheet">
    <script>
        function gotoURL() {
            self.location.href="/sellCar/login/managerLogin";//填写返回登陆界面网址
        }
    </script>

</head>

<body  class="bottom">
<!--导航栏-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <div class="welcome">您好，</div>
        <li class="nav-item active">
            <a class="nav-link name" href="#"><span>${manager.getmName()}</span> 管理员</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link disabled"  data-toggle="modal" data-target="#out"
               href="#">管理员注销</a>
        </li>
        <!-- 模态框 -->
        <div class="modal fade tip" id="out">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <h4 class="modal-title">系统提示</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- 模态框主体 -->
                    <div class="modal-body" style="color: black">
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
    </ul>
</nav>
<div class="type">
    <div class="car">
        <%--<div class="image"><img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2136061505,4046282825&fm=27&gp=0.jpg" height="400px" width="300px"></div>--%>
        <div class="text"><a  href="/managerCar/addCar?mId=${mId}" >车辆管理</a></div>
    </div>
    <div class="order">
        <%--<div class="image"><img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3561565621,665011732&fm=27&gp=0.jpg" height="400px" width="300px"></div>--%>
        <div class="text"><a  href="/managerCar/allOrder?mId=${mId}" >订单管理</a></div>
    </div>


</div>

</body>

