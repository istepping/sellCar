<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--@author 杨圳达&黄伟-->
<!--@time 2018/7/15-->
<!--@apiNote 车辆管理界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>车辆管理界面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager/addCar.css">
    <script>
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
        function addCar() {
            var id=getEvent().target.id;
            var cCatalog;
            var cBrand;
            var cPrice;
            var cColor;
            var cNum;
            var cType;
            var cStyle;
            var cEnergy;
            console.log("id="+id);
            if(id=="1"){
                cCatalog="SUV";
                cBrand=document.getElementById("SUVBrand").value;
                cPrice=document.getElementById("SUVPrice").value;
                cColor=document.getElementById("SUVColor").value;
                cNum=document.getElementById("SUVNum").value;
                cType=document.getElementById("SUVType").value;
            }
            else if(id=="2"){
               cCatalog="sportCar";
                cBrand=document.getElementById("sportCarBrand").value;
                cPrice=document.getElementById("sportCarPrice").value;
                cColor=document.getElementById("sportCarColor").value;
                cNum=document.getElementById("sportCarNum").value;
                cStyle=document.getElementById("sportCarStyle").value;
            }
            else{
                cCatalog="NEV";
                cBrand=document.getElementById("NEVBrand").value;
                cPrice=document.getElementById("NEVPrice").value;
                cColor=document.getElementById("NEVColor").value;
                cNum=document.getElementById("NEVNum").value;
                cEnergy=document.getElementById("NEVEnergy").value;
            }
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/managerCar/addCar/addNewCar.action",
                data:{mId:${mId},cCatalog:cCatalog,cBrand:cBrand,cColor:cColor,cNum:cNum,cPrice:cPrice,cType:cType,cStyle:cStyle,cEnergy:cEnergy},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("增加成功!");
                    }
                    else {
                        alert("增加失败!");
                    }
                },
                fail:function () {
                    console.log("ajax请求失败!");
                }
            });
        }
        function deleteCar() {
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/managerCar/addCar/deleteCar.action",
                data:{mId:${mId},cId:$("#cId").val()},
                dataType:"json",
                success:function(data){
                    console.log("ajax请求成功");
                    if(data.model.result=="success"){
                        alert("删除成功!");
                    }
                    else {
                        alert("删除失败!");
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
        <div class="welcome">您好，</div>
        <li class="nav-item active">
            <a class="nav-link name" href="#"><span>${manager.getmName()}</span> 管理员</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/managerCar/managerHome?mId=${mId}">返回首页</a>
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
    <h3 class="top red">车辆管理平台</h3>
    <br>
    <p>欢迎来到<span class="red">神州汽车</span>车辆管理界面！</p>
    <p>请在下列列表中填写您要添加的车辆信息：</p>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active c" data-toggle="tab" href="#list">查看车辆</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#add">添加车辆</a>
        </li>
        <li class="nav-item">
            <a class="nav-link c" data-toggle="tab" href="#delete">删除车俩</a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div id="list" class="container tab-pane active"><br>
            <div class="container">
                <p>平台全部车辆信息如下：</p>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="table-danger">
                        <tr>
                            <th>序号</th>
                            <th>车辆Id</th>
                            <th>车辆品牌</th>
                            <th>车辆类型</th>
                            <th>车辆颜色</th>
                            <th>车辆价格</th>
                            <th>车辆库存</th>
                            <th>车辆状态</th>
                        </tr>
                        </thead>
                        <!--循环输出车辆信息-->
                        <c:forEach items="${cars}" var="car" varStatus="status">
                            <tbody>
                            <tr>
                                <th>${status.index+1}</th>
                                <td>${car.getcId()}</td>
                                <td>${car.getcBrand()}</td>
                                <td>${car.getcCatalog()}</td>
                                <td>${car.getcColor()}</td>
                                <td>${car.getcPrice()}</td>
                                <td>${car.getcNum()}</td>
                                <td>${car.getcState()}</td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div id="add" class="container tab-pane fade"><br>
            <h4>添加车辆</h4>
            <br>
            <p>选择您要添加的车辆类型：</p>
            <br>
            <form action="/action_page.php">
                <div class="container">
                    <!-- Nav pills -->
                    <ul class="nav nav-pills" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active c" data-toggle="pill" href="#home">SUV</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link c" data-toggle="pill" href="#menu1">跑车</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link c" data-toggle="pill" href="#menu2">NEV</a>
                        </li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div id="home" class="container tab-pane active"><br>
                            <p>请在下列列表中输入您要添加的车辆信息：</p>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆品牌：" id="SUVBrand" name="CarBrand">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆颜色：" id="SUVColor" name="CarColor">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆价格：" id="SUVPrice" name="CarPrice">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆库存：" id="SUVNum" name="CarNum">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的SUV类型：" id="SUVType" name="CarType">
                            </div>
                            <button type="button" class="btn btn-danger b" data-toggle="modal" data-target="#myModal1">添加</button>
                            <!-- 模态框 -->
                            <div class="modal fade tip" id="myModal1">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">系统提示</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            是否添加?
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="addCar()" id="1">确定</button>
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="menu1" class="container tab-pane fade"><br>
                            <p>请在下列列表中输入您要添加的车辆信息：</p>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的跑车品牌：" id="sportCarBrand" name="CarBrand">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的跑车颜色：" id="sportCarColor" name="CarColor">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的跑车价格：" id="sportCarPrice" name="CarPrice">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的跑车库存：" id="sportCarNum" name="CarNum">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的跑车风格：" id="sportCarStyle" name="CarStyle">
                            </div>
                            <button type="button" class="btn btn-danger b" data-toggle="modal" data-target="#myModal2">添加</button>
                            <!-- 模态框 -->
                            <div class="modal fade tip" id="myModal2">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">系统提示</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            是否添加?
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="addCar()" id="2">确定</button>
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="menu2" class="container tab-pane fade"><br>
                            <p>请在下列列表中输入您要添加的车辆信息：</p>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆品牌：" id="NEVBrand" name="CarBrand">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆颜色：" id="NEVColor" name="CarColor">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆价格：" id="NEVPrice" name="CarPrice">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的车辆库存：" id="NEVNum" name="CarNum">
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="请输入您要添加的NEV能源种类：" id="NEVEnergy" name="CarEnergy">
                            </div>
                            <button type="button" class="btn btn-danger b" data-toggle="modal" data-target="#myModal3">添加</button>
                            <!-- 模态框 -->
                            <div class="modal fade tip" id="myModal3">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">系统提示</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            是否添加?
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="addCar()" id="3">确定</button>
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </form>
        </div>
        <div id="delete" class="container tab-pane fade"><br>
            <h4>删除车辆</h4>
            <br>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="输入您要删除的车辆Id：" id="cId" name="carID">
            </div>
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">删除</button>
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
                            是否删除?
                        </div>
                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteCar()" id="4">确定</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
