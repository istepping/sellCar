<%--
  Created by IntelliJ IDEA.
  User: 黄伟 杨圳达
  Date: 2018/7/14
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> 管理员登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="http://localhost:8090/resources/css/managerLogin.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">

            <form class="m-t" role="form" action="/sellCar/login/managerLogin/submit">
                <h4 class="no-margins" style="text-align: center">管理员登录：</h4>
                <p class="m-t-md">欢迎登录神州汽车销售系统</p>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="" name="name">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="" name="password">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center">   <a href="/sellCar/login/userLogin"><small>返回用户登录</small></a>
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