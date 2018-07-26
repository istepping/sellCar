<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/20
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--@author 杨圳达&黄伟-->
<!--@time 2018/7/22-->
<!--@apiNote 订单管理界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理界面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager/allOrders.css">
    <script>
        function gotoHome() {
            self.location.href="/managerCar/managerHome?mId=${mId}";//填写返回登陆界面网址
        }
        function gotoURL() {
            self.location.href="/sellCar/login/managerLogin";//填写返回登陆界面网址
        }
        function getEvent(){
            if(window.event){
                return window.event;
            }
            var f = arguments.callee.caller;
            do{
                var e = f.arguments[0];
                if(e && (e.constructor === Event || e.constructor===MouseEvent || e.constructor===KeyboardEvent)){
                    return e;
                }
            }while(f=f.caller);
        }
        function receiveOrder() {
            var oId=getEvent().target.id;
            console.log("oId="+oId);
            var mySelect=document.getElementById("select"+oId);
            var index=mySelect.selectedIndex;
            if(index==0){
                $.ajax({
                    type:"GET",
                    url:"${pageContext.request.contextPath}/managerCar/orders/receiveOrder.action",
                    data:{mId:${mId},oId:oId},
                    dataType:"json",
                    success:function(data){
                        console.log("ajax请求成功");
                        if(data.model.result=="success"){
                            alert("接单成功!");
                        }
                        else {
                            alert("接单失败!");
                        }
                    },
                    fail:function () {
                        console.log("ajax请求失败!");
                    }
                });
            }
            else{
                $.ajax({
                    type:"GET",
                    url:"${pageContext.request.contextPath}/managerCar/orders/rejectOrder.action",
                    data:{mId:${mId},oId:oId},
                    dataType:"json",
                    success:function(data){
                        console.log("ajax请求成功");
                        if(data.model.result=="success"){
                            alert("取消成功!");
                        }
                        else {
                            alert("取消失败!");
                        }
                    },
                    fail:function () {
                        console.log("ajax请求失败!");
                    }
                });
            }
        }
    </script>
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <div class="welcome">您好，</div>
        <li class="nav-item active">
            <a class="nav-link name" href="#"><span>${manager.getmName()}</span>管理员</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="javascript:gotoHome();">返回首页</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link disabled" data-toggle="modal" data-target="#out" href="#">管理员注销</a>
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
<div class="container mt-3">
    <h3 class="top red">订单管理平台</h3>
    <br>
    <p>欢迎来到<span class="red">神州汽车</span>订单管理界面！</p>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active c" data-toggle="tab" href="#list">总订单</a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div id="list" class="container tab-pane active"><br>
            <div class="container">
                <p>平台全部订单信息如下：</p>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="table-danger">
                        <tr>
                            <th>序号</th>
                            <th>订单号</th>
                            <th>用户名</th>
                            <th>用户账号</th>
                            <th>用户地址</th>
                            <th>订单商品编号</th>
                            <th>订单商品名称</th>
                            <th>订单时间</th>
                            <th>订单价格</th>
                            <th>订单状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <!--循环输出订单信息-->

                        <c:forEach items="${orders}" var="order" varStatus="status">
                            <tbody>
                            <tr>
                                <th>${status.index+1}</th>
                                <td>${order.getoId()}</td>
                                <td>${order.getuName()}</td>
                                <td>${order.getuPhone()}</td>
                                <td>${order.getuAddress()}</td>
                                <td>${order.getcId()}</td>
                                <td>${order.getcBrand()}</td>
                                <td>${order.getoTime()}</td>
                                <td>${order.getcPrice()}</td>
                                <td>${order.getoStateInfo()}</td>
                                <td>
                                    <select name="order" class="custom-select-sm" id="select${order.getoId()}">
                                        <option value="1">接单</option>
                                        <option value="2">不接单</option>
                                    </select> <button type="button" class="btn btn-danger" data-toggle="modal" id="${order.getoId()}" onclick="receiveOrder()">提交</button>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
