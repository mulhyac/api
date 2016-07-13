<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- saved from url=(0038)http://v2.apiview.com/p/2089#/api/list -->
<html lang="zh-cn">
<head>
    <title>接口列表-Apiview-api文档管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="apiview,API文档管理,接口文档,API测试工具,API生成工具,Api,api管理,api文档,api在线">
    <link rel="stylesheet" href="/resource/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/bootflat.min.css">
    <link rel="stylesheet" href="/resource/common.min.css">
    <link rel="stylesheet" href="/resource/app.min.css">
</head>

<body ng-app='apiview' ng-controller="PublicController">
<nav class="navbar navbar-inverse navbar-static-top " role="navigation">
    <div class="">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img src="/resource/logo.png" alt="" width="120"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav nav-main">
                <li class=""><a href="/user">首页</a></li>
                <li class=""><a href="#">帮助</a></li>
            </ul>
            <p class="tc f20 navbar-text navbar-project-name" ng-cloak>{{project_info.name}}</p>
            <ul class="nav navbar-nav navbar-right mr20" ng-cloak>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><img ng-src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEEAAABBCAIAAAABlV4SAAAABnRSTlMAAAAAAABupgeRAAAAkElEQVRoge3awQnDMBAAwSikgJSSUlyqS0kpKSEt6CHssdl5C3OL/BBIY39/Hhf3PHuABWow1GCowVCDoQZDDYYaDDUYajDUYKjBUIOhBkMNhhoMNRhqMNRgqMEwJtfNX2Nvv+/BX7vDPtRgqMFQg6EGQw2GF/6eb2a8sfb4tdbkbHf4l2ow1GCowVCDoQbDHxjbDUJh+uK9AAAAAElFTkSuQmCC" class="gravater img-border"> <b class="caret"></b></a>
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

<div class="body-content" ng-controller="ProjectController" ng-init="getProjectInfo()">
    <div class="border-right " id="side-menu-first" >
        <div class="tc mt20">
            <a href="#project/dashbord"><img ng-src="/resource/logo_gravater_dark.jpg" alt="" width="60"></a>
        </div>
        <div id="first-menu-list" class="mt10">
            <ul class="first-level-nav menu-list">
                <li><a href="#/group/list" ng-class="{active:nav_first=='group'||!nav_first }"><i class="glyphicon  glyphicon-th-large"></i><span class='menu-title'>分组</span></a></li>
                <li><a href="#/api/list" ng-class="{active:nav_first=='api'}"><i class="glyphicon glyphicon-list"></i><span class='menu-title'>接口</span></a></li>
                <li><a href="#/member/list" ng-class="{active:nav_first=='member'}"><i class="glyphicon glyphicon-user"></i><span class='menu-title'>成员</span></a></li>
                <li><a href="#/setting/baseinfo" ng-class="{active:nav_first=='setting'}"><i class="glyphicon glyphicon-cog"></i><span class='menu-title'>设置</span></a></li>
                <li><a ng-href="/doc/{{project_info.id}}#/doc/dashbord" target="_blank"><i class="glyphicon glyphicon-book"></i><span class='menu-title'>阅读</span></a></li>
            </ul>
        </div>
    </div>
    <div class="border-right " id="side-menu-second" ng-cloak>
        <div ng-if="nav_first=='group'" >
            <div class="menu-title">
                <h3>分组</h3>
                <article>接口很多时可以对接口进行分组管理</article>
            </div>
            <div class="border-bottom pb30 second-menu-list">
                <ul>
                    <li class=""><a href="#/group/list" ng-class="{active:nav_second=='list'}">&nbsp;&nbsp;所有分组</a></li>
                    <li class=""><a href="#/group/create" ng-class="{active:nav_second=='create'}">&nbsp;&nbsp;创建分组</a></li>
                </ul>
            </div>
        </div>
        <div ng-if="nav_first=='api'">
            <div class="menu-title">
                <h3>接口</h3>
                <article>接口相关</article>
            </div>
            <div class="border-bottom pb30 second-menu-list">
                <ul class="menu-list">
                    <li class=""><a href="#/api/list" ng-class="{active:nav_second=='list'}">&nbsp;&nbsp;接口列表</a></li>
                    <li class=""><a href="#/api/create" ng-class="{active:nav_second=='create'}">&nbsp;&nbsp;添加接口</a></li>
                </ul>
            </div>
        </div>
        <div ng-if="nav_first=='member'">
            <div class="menu-title">
                <h3>成员</h3>
                <article>项目成员管理</article>
            </div>
            <div class="border-bottom pb30 second-menu-list">
                <ul class="menu-list">
                    <li class=""><a href="#/member/list" ng-class="{active:nav_second=='list'}">&nbsp;&nbsp;成员列表</a></li>
                </ul>
            </div>
        </div>
        <div ng-if="nav_first=='setting'">
            <div class="menu-title">
                <h3>设置</h3>
                <article>项目相关设置</article>
            </div>
            <div class="border-bottom pb30 second-menu-list">
                <ul class="menu-list">
                    <li class=""><a href="#/setting/baseinfo" ng-class="{active:nav_second=='baseinfo'}">&nbsp;&nbsp;项目信息</a></li>
                    <!-- <li class=""><a href="#/setting/debug" ng-class="{active:nav_second=='debug'}">&nbsp;&nbsp;调试设置</a></li> -->
                    <li class=""><a href="#/setting/advance" ng-class="{active:nav_second=='advance'}">&nbsp;&nbsp;高级设置</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid " id="main-content">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-title p20" ng-cloak>
                    {{page_title}}
                </div>
                <div ng-view class="p20 page"></div>
            </div>
        </div>
    </div>
</div>
<script>
    pid = ${pid};
</script>
<link rel="stylesheet" href="/resource/app.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.min.css">
<link href="https://cdn.bootcss.com/pnotify/3.0.0/pnotify.buttons.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/jquery.jsonView.css">

<script src="/resource/jquery.min.js"></script>
<script src="/resource/pnotify.min.js"></script>
<script src="/resource/pnotify.callbacks.min.js"></script>
<script src="/resource/pnotify.confirm.min.js"></script>
<script src="/resource/validator.min.js"></script>
<script src="/resource/require.min.js"></script>
<script src="/resource/bootstrap.min.js"></script>
<script src="/resource/angular.min.js"></script>
<script src="/resource/angular-route.min.js"></script>
<script src="/resource/angular-animate.min.js"></script>
<script src="/resource/angular-md5.min.js"></script>
<script src="/resource/jquery.jsonView.js"></script>
<script src="/resource/app.min.js"></script>
<script src="/resource/func.min.js"></script>
</body></html>