<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--@author 杨圳达 黄伟-->
<!--@time 2018/7/15-->
<!--@apiNote 商品详情界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>售车系统</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/carDetail.css">
    <script>
        function change_img1(){
            var pic=document.getElementById("car");
            pic.src="${image.getiUrl1()}";
        }
        function change_img2(){
            var pic=document.getElementById("car");
            pic.src="${image.getiUrl2()}";
        }
        function change_img3(){
            var pic=document.getElementById("car");
            pic.src="${image.getiUrl3()}";
        }
        function change_img4(){
            var pic=document.getElementById("car");
            pic.src="${image.getiUrl4()}";
        }
        function gotoURL() {
            self.location.href="/sellCar/login/userLogin";//填写返回登陆界面网址
        }
        function collect(){
            console.log("收藏");
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/sell/userCentral/collect.action",
                data:{uId:${uId},cId:${car.getcId()}},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("收藏成功!");
                    }
                    else {
                        alert("您已经收藏该商品，请勿重复收藏!");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
        }
        function order(){
            console.log("收藏");
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/sell/userCentral/buy.action",
                data:{uId:${uId},cId:${car.getcId()}},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("下单成功!");
                    }
                    else {
                        alert("下单失败!可能库存不足");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
        }
    </script>
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/sell/home?uId=${uId}">商城首页</a>
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

<!--<nav>-->
<!--<div class="container-fluid a" style="flex: 1">-->
<!--<div class="nav">-->
<!--<div class="nav">-->
<!--<div><a href="#">商城首页</a></div>-->
<!--</div>-->
<!--</div>-->
<!--<div style="flex: 2"></div>-->

<!--<div class="nav">-->
<!--<div class="nav" style="flex: 1"><a href="#">设置</a></div>-->
<!--<div class="nav" style="flex: -1">-->
<!--<a href="#">-->
<!--个人中心-->
<!--<b class="caret"></b>-->
<!--</a>-->
<!--&lt;!&ndash;<ul>&ndash;&gt;-->
<!--&lt;!&ndash;<li><a href="#">我的订单</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;<li><a href="#">我的收藏</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;<li><a href="#">我的地址</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;<li><a href="#">个人设置</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;<li><a href="#">注销</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;</ul>&ndash;&gt;-->
<!--</div>-->
<!--</div>-->
<!--</div>-->
<!--</nav>-->


<div class="body">
    <div class="body_left">

        <div class="body_left_car">
            <a href="#" target="_blank"><img src="${image.getiUrl1()}" style="width:100%" id="car" ></a>
        </div>
        <div class="body_left_change">
            <img src="${image.getiUrl1()}" class="body_left_change_img" onclick="change_img1()"/>
            <img src="${image.getiUrl2()}" class="body_left_change_img" onclick="change_img2()" />
            <img src="${image.getiUrl3()}" class="body_left_change_img" onclick="change_img3()"/>
            <img src="${image.getiUrl4()}" class="body_left_change_img" onclick="change_img4()"/>
        </div>

    </div>

    <div class="body_right">
        <div class="body_right_info_1">
            <h2>${car.getcBrand()}</h2>
            <p>活动促销，整车优惠！！！</p>
        </div>
        <div class="body_right_info_2">
            <p>参考价格：<span class="important">${car.getcPrice()}</span></p>
            <!--<p>11.99万元</p>-->
        </div>
        <div class="body_right_info_3"> 库存量:<span>${car.getcNum()}</span></div>
        <div class="body_right_info_4">
            <button class="btn btn-danger but btn-primary" data-toggle="modal" data-target="#mModal" >收藏</button>
            <!-- 模态框 -->
            <div class="modal fade tip" id="mModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- 模态框头部 -->
                        <div class="modal-header">
                            <h4 class="modal-title">系统提示</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- 模态框主体 -->
                        <div class="modal-body">
                            收藏该商品?
                        </div>
                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-first" data-dismiss="modal" onclick="collect()">确定</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal" >取消</button>
                        </div>

                    </div>
                </div>
            </div>

            <button class="btn btn-danger but" data-toggle="modal" data-target="#buyModal" >购买</button>

            <div class="modal fade tip" id="buyModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- 模态框头部 -->
                        <div class="modal-header">
                            <h4 class="modal-title">系统提示</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- 模态框主体 -->
                        <div class="modal-body">
                            确认下单?
                        </div>
                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-first" data-dismiss="modal" onclick="order()">确定</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<div class="container">
    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active c" data-toggle="tab" href="#home">购买流程</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#menu1">参考配置</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#menu2">用户协议</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active"><br>
            <h3>购买流程</h3>
            <img src="${pageContext.request.contextPath}/resources/img/2000.jpg"/>
        </div>
        <div id="menu1" class="container tab-pane fade"><br>
            <h3>参考配置</h3><br>
            <h4>基本信息</h4><br>
            <p>厂商：神州汽车</p>
            <p>车辆类型：<span>${car.getcCatalog()}</span></p>
            <p>车辆颜色：<span>${car.getcColor()}</span></p>
            <p>车辆库存：<span>${car.getcNum()}</span>辆</p>
            <p>车辆品牌：<span>${car.getcBrand()}</span></p>

        </div>
        <div id="menu2" class="container tab-pane fade"><br>
            <h3>用户协议</h3>
            <ul>
                <li>请确保参与人年满18周岁，具备完全行为能力；您参加本活动的行为应符合相关法律法规规定，且不会给任何第三人造成权利损失，否则神州汽车有权取消您参加活动的资格，并拒绝退还相关款项。</li>
                <li>参与人必须与实际购车人一致，因地区限购政策等原因导致参与人无法完成购车的，由参与人自行负责。</li>
                <li>活动期间，因参与人操作不当或参与人所在区域网络故障、支付平台网络不畅、电信运营商故障等非神州汽车所能控制的原因导致的参与人无法参与活动、或者参与失败，神州汽车不予负责。</li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>





