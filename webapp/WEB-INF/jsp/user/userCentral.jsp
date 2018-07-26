<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/16
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--@author 杨圳达&黄伟-->
<!--@time 2018/7/18-->
<!--@apiNote 个人中心界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userCentral.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script>
        function gotoURL() {
            self.location.href="/sellCar/login/userLogin";//填写返回登陆界面网址
        }
        function change_password(){
            var old_password=document.getElementById("old_password").value;
            var new_password=document.getElementById("new_password").value;
            //调用
            // changeUserPassword(old_password.toString(),new_password.toString());       修改密码函数
            //alert("旧密码："+old_password+" 新密码："+new_password);
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/sell/userCentral/changeUserPassword.action",
                data:{uId:${user.getuId()},password:$("#old_password").val(),newPassword:$("#new_password").val()},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("修改成功!");
                    }
                    else {
                        alert("操作失败!密码可能输入错误");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
        }
        function change_personalData(){
            // var xmlhttp;
            // if (window.XMLHttpRequest)
            // {// code for IE7+, Firefox, Chrome, Opera, Safari
            //     xmlhttp=new XMLHttpRequest();
            // }
            // else
            // {// code for IE6, IE5
            //     xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            // }
            var phone=document.getElementById("usr").value;
            var address=document.getElementById("address").value;
            // changeUserPassword(old_password.toString(),new_password.toString());       修改信息函数
            //alert("手机号："+phone+" 地址："+address);
            $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/sell/userCentral/changeUserInfo.action",
            data:{uId:${user.getuId()},phone:$("#usr").val(),address:$("#address").val()},
            dataType:"json",
            success:function(data){
            console.log("ajax请求成功");
            if(data.model.result=="success"){
            alert("修改成功!");
            }
            else {
            alert("操作失败!手机号格式可能输入错误");
            }
            },
            fail:function () {
            console.log("ajax请求失败!");
            }
            });
        }
        function payForOrder() {
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/sell/userCentral/payForOrder.action",
                data:{uId:${user.getuId()},oId:$("#number1").val()},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("付款成功!");
                    }
                    else {
                        alert("付款失败!可能余额不足");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
        }
        function cancelOrder() {
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/sell/userCentral/cancelBuy.action",
                data:{uId:${user.getuId()},oId:$("#number2").val()},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("取消成功!");
                    }
                    else {
                        alert("操作失败!");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
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
        function changeCollect() {
            var cId=getEvent().target.id;
            console.log("cId="+cId);
            var mySelect=document.getElementById("select"+cId);
            var index=mySelect.selectedIndex;
            if(index==0){
                $.ajax({
                    type:"GET",
                    url:"${pageContext.request.contextPath}/sell/userCentral/buy.action",
                    data:{uId:${user.getuId()},cId:cId},
                    dataType:"json",
                    success:function(data){
                        console.log("ajax请求成功");
                        if(data.model.result=="success"){
                            alert("下单成功!");
                        }
                        else {
                            alert("下单失败!");
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
                    url:"${pageContext.request.contextPath}/sell/userCentral/cancelCollect.action",
                    data:{uId:${user.getuId()},cId:cId},
                    dataType:"json",
                    success:function(data){
                        console.log("ajax请求成功");
                        if(data.model.result=="success"){
                            alert("取消成功!");
                        }
                        else {
                            alert("操作失败!");
                        }
                    },
                    fail:function () {
                        console.log("ajax请求失败!");
                    }
                });
            }
        }
    </script>
<body>

<!--<导航栏>-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <div class="welcome">您好，</div>
        <li class="nav-item active">
            <a class="nav-link name" href="#">${user.getuName()}</a>
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
<!--</导航栏>-->

<div class="container blank">
    <h2 class="co">个人中心</h2>
    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active c" data-toggle="tab" href="#个人资料">个人资料</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#我的订单">我的订单</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#我的收藏">我的收藏</a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div id="个人资料" class="container tab-pane active"><br>
            <div>
                <h4>个人资料</h4>
                <br>
                <div>用户id：<span>${user.getuId()}</span></div><br>
                <div>用户名：<span>${user.getuName()}</span></div><br>
                <div>手机号：<span>${user.getuPhone()}</span></div><br>
                <button class="btn btn-danger btn-primary" data-toggle="collapse" data-target="#demo1">修改密码</button>
                <div id="demo1" class="collapse">
                    <br>
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" placeholder="请输入您的旧密码" id="old_password" name="旧密码">
                    </div>
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" placeholder="请输入您的新密码" id="new_password" name="新密码">
                    </div>
                    <a href="javascript:change_password();"><button type="button" class="btn btn-danger" id="submit1">提交</button></a>
                </div><br>
                <div>我的地址：<span>${user.getuAddress()}</span></div><br>
                <button class="btn btn-danger btn-primary" data-toggle="collapse" data-target="#demo2">修改资料</button>
                <div id="demo2" class="collapse">
                    <br>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="请输入您的新手机号" id="usr" name="username">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="请输入您的新地址" id="address" name="address">
                    </div>
                    <a href="javascript:change_personalData();"><button type="button" class="btn btn-danger"id="submit2">提交</button></a>
                </div><br>
            </div>
        </div>

        <div id="我的订单" class="container tab-pane fade"><br>
            <h4>我的订单</h4>
            <br>
            <div class="container">
                <p>您的历史订单信息如下：</p>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>订单号</th>
                            <th>用户名</th>
                            <th>用户手机</th>
                            <th>用户地址</th>
                            <th>订单商品编号</th>
                            <th>订单商品名称</th>
                            <th>订单时间</th>
                            <th>订单价格</th>
                            <th>订单状态</th>
                        </tr>
                        </thead>
                        <!--循环导入订单信息-->
                        <!--样例-->
                        <!--<tbody>-->
                        <!--<tr>-->
                        <!--<th>1</th>-->
                        <!--<td>123456</td>-->
                        <!--<td>Eric Young</td>-->
                        <!--<td>132132132</td>-->
                        <!--<td>大连理工大学软件学院生活区</td>-->
                        <!--<td>23456</td>-->
                        <!--<td>大众</td>-->
                        <!--<td>2018/7/16</td>-->
                        <!--<td>20万</td>-->
                        <!--<td>完成</td>-->
                        <!--</tr>-->
                        <!--</tbody>-->
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
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <button class="btn btn-danger l b" data-toggle="collapse" data-target="#demo">订单付款</button>
            <button class="btn btn-danger b" data-toggle="collapse" data-target="#demo0">取消订单</button>
            <div id="demo" class="collapse">
                <br>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="请输入您要确认的订单号" id="number1" name="订单号">
                </div>
                <button type="button" class="btn btn-danger" data-toggle="modal" onclick="payForOrder()">提交</button>
            </div>
            <div id="demo0" class="collapse">
                <br>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="请输入您要取消的订单号" id="number2" name="订单号">
                </div>
                <button type="button" class="btn btn-danger" data-toggle="modal" onclick="cancelOrder()">提交</button>
            </div>
        </div>
        <div id="我的收藏" class="container tab-pane fade"><br>
            <h4>我的收藏</h4>
            <br>
            <div class="container">
                <p>您的收藏商品信息如下：</p>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>选择</th>
                        </tr>
                        </thead>
                        <!--循环导入收藏栏信息-->
                        <!--样例-->
                        <!--<tbody>-->
                        <!--<tr>-->
                        <!--<th>1</th>-->
                        <!--<td>23456</td>-->
                        <!--<td>大众</td>-->
                        <!--<td>20万</td>-->
                        <!--<td>18</td>-->
                        <!--</tr>-->
                        <!--</tbody>-->
                        <c:forEach items="${cars}" var="car" varStatus="status">
                        <tbody>
                        <tr>
                            <th>${status.index+1}</th>
                            <td>${car.getcId()}</td>
                            <td>${car.getcBrand()}</td>
                            <td>${car.getcPrice()}</td>
                            <td>${car.getcNum()}</td>
                            <td>
                                <select name="cars" class="custom-select-sm" id="select${car.getcId()}">
                                <option value="下单">下单</option>
                                <option value="取消">取消</option>
                                </select> <button type="button" id="${car.getcId()}" class="btn btn-danger" data-toggle="modal" onclick="changeCollect()">提交</button>
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
