<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/9 0009
  Time: 上午 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>Apiview-Api文档管理工具-提升开发效率</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="apiview,API文档管理,接口文档,API测试工具,API生成工具,Api,api管理,api文档,api在线">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootflat/2.0.4/css/bootflat.min.css">
    <link rel="stylesheet" href="./resource/common.min.css">
    <link rel="stylesheet" href="./resource/index.min.css">
</head>

<body ng-app='apiview' ng-controller="PublicController">
<nav class="navbar navbar-inverse navbar-static-top " role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img src="/resource/logo.png" alt="" width="120"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav nav-main" >
                <li class=""><a href="/">首页</a></li>
                <li class=""><a href="#" target="_blank">帮助</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-login" ng-if="!user_info.username" ng-cloak>
                <li><a href="/User/login"  class="" >登录</a></li>
                <li><a href="/User/regist"  class="" >注册</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right "  ng-if="user_info.username" ng-cloak>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><img ng-src="{{user_info.gravater}}" class="gravater img-border" > <b class="caret"></b></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/user/#/project/create">创建项目</a></li>
                        <li><a href="/user/#/project/all">我的项目</a></li>
                        <li><a href="/user/#/account/profile">个人设置</a></li>
                        <li class="divider"></li>
                        <li><a href="/user/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<style type="text/css">
    .navbar{
        display: none;
    }
    #doc-main{
        padding-top: 0 !important;
    }
</style>
<div id="doc-main" ng-controller="ApiController">
    <div class="" id="doc-content">
        <div class="p20">
            <div class="bread-nav mt10 border-bottom">
                <ol class="breadcrumb text-main">
                    <li><a href="/api" class="text-main">主页</a></li>
                    <li><span id="group-name"></span></li>
                    <li class="active"><span>{{api_info.name}}</span></li>
                </ol>
            </div>
            <div class="ng-view mt20">
            </div>
        </div>
    </div>
    <div id="doc-nav" ng-init="getApiList()" ng-cloak>
        <div class="doc-nav-search">
            <a href="#/doc/dashbord" class="home" ng-controller="ProjectController" ng-init="getProjectInfo()">{{project_info.name}}</a>
            <div class="form-search search-only">
                <i class="search-icon glyphicon glyphicon-search"></i>
                <input type="text" class="form-control search-query" ng-model="search_keyword" placeholder="搜索接口">
            </div>
        </div>
        <ul ng-repeat="g in api_list" class="api-list">
            <li ng-class="{'current':search_keyword}">
                <a href="" class="group-name"><span>{{g.name}}</span> ({{g.apis.length}})</a>
                <ul>
                    <li ng-repeat="api in g.apis" class="sub-nav"><a ng-href="#/api/{{api.id}}">{{api.brief}}--{{api.name}}</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="cl"></div>
</div>
</body>
<link rel="stylesheet" href="/resource/app.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.min.css">
<link href="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.buttons.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/jquery.jsonView.css">

<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.min.js"></script>
<script src="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.callbacks.min.js"></script>
<script src="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.confirm.min.js"></script>
<script src="https://cdn.bootcss.com/1000hz-bootstrap-validator/0.10.2/validator.min.js"></script>
<script src="https://cdn.bootcss.com/require.js/2.2.0/require.min.js"></script>
<script src="https://cdn.bootcss.com/angular.js/1.4.2/angular.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/angular.js/1.4.2/angular-route.min.js"></script>
<script src="https://cdn.bootcss.com/angular.js/1.4.2/angular-animate.min.js"></script>
<script src="https://cdn.bootcss.com/angular-md5/0.1.10/angular-md5.min.js"></script>
<script src="/resource/jquery.jsonView.js"></script>
<script src="/resource/app.min.js"></script>
<script src="/resource/func.min.js"></script>
</html>
<script>
    pid = 2089;
    $(document).ready(function() {
        $("#doc-nav").on('click', '.group-name', function(event) {
            event.preventDefault();
            $("#group-name").text($(this).children('span').text());
            if($(this).parent("li").hasClass('current')){
                $(this).parent("li").removeClass('current');
            }else{
                $(this).parent("li").addClass('current');
                $(this).parent("li").parent("ul").siblings('ul').children('li').removeClass('current');
            }
        });
    });
</script>
