<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@author 黄伟 杨圳达--%>
<%--@time 2018/7/15--%>
<%--@apiNote 主页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>神州汽车</title>
    <head>
        <script type="text/javascript" src="//mat1.gtimg.com/joke/Koala/Koala-min1.3.2.js" async="true"></script>
        <script async=""
                src="http://tags.webdev.com/interface/tag/articles.php?tag=%E7%94%A8%E8%BD%A6&amp;
                oe=utf8&amp;site=auto&amp;p=1&amp;l=12&amp;platform=web&amp;callback=jQuery110207458324556349168_1531647667230&amp;_=1531647667231">
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
        <meta name="baidu-site-verification" content="elM09FkRTW">
        <meta name="author" content="samuelcheng">

        <link href="${pageContext.request.contextPath}/resources/css/userHome.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="//mat1.gtimg.com/auto/FERD/homepage/css/main.css">
        <script type="text/javascript" src="http://fw.qq.com:80/ipaddress"></script>
        <script src="//w.l.qq.com/lview?type=text&amp;rot=1&amp;ri=_textAd&amp;callback=auto_gen_1&amp;loc=Auto_CHJX_Text7,Auto_CHJX_Text8"
                charset="gbk"></script>
        <script src="//ra.gtimg.com/web/crystal/v4.4Beta05Build050/crystal_ext-min.js"></script>
        <script src="//dp3.qq.com/dynamic?get_type=cm&amp;ch=auto&amp;callback=crystal.cookieMapping"></script>
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <script>
            function gotoURL() {
                self.location.href="/sellCar/login/userLogin";//填写返回登陆界面网址
            }
        </script>
    </head>

</head>
<body>
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
            <a class="nav-link disabled" data-toggle="modal" data-target="#myModal" href="#">用户注销</a>
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

<div class="title"><h1><a class="box red">产品商城</a></h1></div>
<div class="carshop mt15 com-head layout1000 layout1240" bosszone="automall">
    <div class="carshop mt15 com-head layout1000 layout1240" bosszone="automall">

        <div class="bd">
            <ul class="line1 cf" id="shopl1">
                <c:forEach items="${cars}" var="car">
                <li>
                    <div class="con">
                        <a class="imglink" href="/sell/detail?id=${car.getcId()}&uId=${uId}" target="_blank">
                            <img src="${car.getcUrl()}"
                                 alt="途安">
                        </a>
                        <div class="tips cf"></div>
                        <div class="dec">
                            <a class="nametext" href="/sell/detail?id=${car.getcId()}&uId=${uId}"
                               target="_blank">${car.getcBrand()}</a>
                        </div>
                        <div class="price">
                        <span class="now"><em>${car.getcPrice()}</em>
                        </span>
                        </div>
                        <span class="buying share10-buybg">
                        <a class="buylink" href="/sell/detail?id=${car.getcId()}&uId=${uId}"
                           target="_blank">购买</a>
                    </span>
                    </div>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>