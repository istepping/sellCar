<%--
  Created by IntelliJ IDEA.
  User: 黄伟 杨圳达
  Date: 2018/7/13
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title> 用户登录</title>
    <link  rel="stylesheet" type="text/css" href="http://localhost:8090/resources/css/userLogin.css" >
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <%--<script type="text/javascript" src="/resources/js/jsencrypt.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--var publicKey=null;--%>
        <%--function login() {--%>
            <%--getPublicKey();--%>
            <%--console.log("publicKey="+publicKey);--%>
            <%--var password=document.getElementById("password");--%>
            <%--var name=document.getElementById("name");--%>
            <%--var code=document.getElementById("code");--%>
            <%--console.log("password="+password);--%>
            <%--var encrypt=new JSEncrypt();--%>
            <%--if(publicKey!=null){--%>
                <%--encrypt.setPublicKey(publicKey);--%>
                <%--var tPassword=encrypt.encrypt(password);--%>
                <%--console.log("tPassword="+tPassword);--%>
                <%--$.ajax({--%>
                    <%--type:"GET",--%>
                    <%--url:"${pageContext.request.contextPath}/sellCar/login/userLogin/submit.action",--%>
                    <%--data:{code:code,password:tPassword,name:name},--%>
                    <%--dataType:"json",--%>
                    <%--success:function(){--%>
                        <%--console.log("ajax请求成功");--%>
                    <%--},--%>
                    <%--fail:function () {--%>
                        <%--console.log("ajax请求失败!");--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>
        <%--}--%>
        <%--function changeImg() {--%>
            <%--console.log("换一张")--%>
            <%--var imgSrc=$("#imgObj")--%>
            <%--var src=imgSrc.attr("src");--%>
            <%--imgSrc.attr("src",changeUrl(src));--%>
            <%--console.log("imgSrc="+imgSrc);--%>
        <%--}--%>
        <%--function changeUrl(url) {--%>
            <%--var timestamp=(new Date()).valueOf();--%>
            <%--url=url.substring(0,20);--%>
            <%--if ((url.indexOf("&") >= 0)) {--%>
                <%--url = url + "&tamp=" + timestamp;--%>
            <%--} else {--%>
                <%--url = url + "?timestamp=" + timestamp;--%>
            <%--}--%>
                <%--return url;--%>
        <%--}--%>
        <%--function getPublicKey() {--%>
            <%--console.log("获取密钥");--%>
            <%--$.ajax({--%>
                <%--url: "${pageContext.request.contextPath}/sellCar/login/getKey.action",--%>
                <%--type: "GET",--%>
                <%--dataType: "text",--%>
                <%--success: function(data) {--%>
                    <%--if(data) publicKey = data;--%>
                        <%--if(publicKey==null){--%>
                            <%--console.log("获取密钥失败!")--%>
                        <%--}else{--%>
                            <%--console.log("获取密钥成功")--%>
                        <%--}--%>
                    <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--</script>--%>
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">

            <form class="m-t" role="form" action="/sellCar/login/userLogin/submit">
                <h4 class="no-margins" style="text-align: center">用户登录：</h4>
                <p class="m-t-md" >欢迎登录神州汽车销售系统</p>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="" name="name" id="name">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="" name="password" id="password">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="验证码" name="code" id="code"><img id="imgObj" src="/sellCar/login/getCode"/><a href="/sellCar/login/userLogin">换一张</a>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

                <p class="text-muted text-center"> <a href="/sellCar/login/managerLogin"><small>管理员登录</small></a> | <a href="/sellCar/login/userRegister">注册账号</a>
                </p>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            <!--&copy; hAdmin-->
        </div>
    </div>
</div>
</body>
</html>
