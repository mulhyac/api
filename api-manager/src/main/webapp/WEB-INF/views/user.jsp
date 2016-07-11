<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<title>所有项目-Apiview-api文档管理</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="apiview,API文档管理,接口文档,API测试工具,API生成工具,Api,api管理,api文档,api在线">
<link rel="stylesheet" href="/resource/bootstrap.min.css">
<link rel="stylesheet" href="/resource/bootflat.min.css">
<link rel="stylesheet" href="/resource/common.min.css">
<link rel="stylesheet" href="/resource/index.min.css">
<script type="text/javascript" charset="utf-8" async="" data-requirecontext="_"
        data-requiremodule="/Public/lib/plupload/plupload.full.min.js"
        src="./所有项目-Apiview-api文档管理_files/plupload.full.min.js"></script>
<script type="text/javascript" charset="utf-8" async="" data-requirecontext="_"
        data-requiremodule="/Public/lib/jcrop/jquery.Jcrop.min.js"
        src="/resource/jquery.Jcrop.min.js"></script>
</head>

<body ng-app="apiview" ng-controller="PublicController" class="ng-scope">
<nav class="navbar navbar-inverse navbar-static-top " role="navigation">
    <div class="">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img src="/resource/logo.png" alt=""
                                                  width="120"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav nav-main">
                <li class=""><a href="/user">首页</a></li>
                <li class=""><a href="#" target="_blank">帮助</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right mr20">
                <a href="#/project/create" class="btn btn-success btn-sm pull-left mt10 ml5"><i
                        class="glyphicon glyphicon-plus"></i>&nbsp;创建项目</a>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><img class="gravater img-border"
                                                                                   ng-src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEEAAABBCAIAAAABlV4SAAAABnRSTlMAAAAAAABupgeRAAAAkElEQVRoge3awQnDMBAAwSikgJSSUlyqS0kpKSEt6CHssdl5C3OL/BBIY39/Hhf3PHuABWow1GCowVCDoQZDDYYaDDUYajDUYKjBUIOhBkMNhhoMNRhqMNRgqMEwJtfNX2Nvv+/BX7vDPtRgqMFQg6EGQw2GF/6eb2a8sfb4tdbkbHf4l2ow1GCowVCDoQbDHxjbDUJh+uK9AAAAAElFTkSuQmCC"
                                                                                   src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEEAAABBCAIAAAABlV4SAAAABnRSTlMAAAAAAABupgeRAAAAkElEQVRoge3awQnDMBAAwSikgJSSUlyqS0kpKSEt6CHssdl5C3OL/BBIY39/Hhf3PHuABWow1GCowVCDoQZDDYYaDDUYajDUYKjBUIOhBkMNhhoMNRhqMNRgqMEwJtfNX2Nvv+/BX7vDPtRgqMFQg6EGQw2GF/6eb2a8sfb4tdbkbHf4l2ow1GCowVCDoQbDHxjbDUJh+uK9AAAAAElFTkSuQmCC">
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#/project/all">我的项目</a></li>
                        <li><a href="#/account/profile">个人设置</a></li>
                        <li class="divider"></li>
                        <li><a href="https://apiview.com/user/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="body-content ng-scope" ng-controller="UserController">
    <div class="border-right " id="side-menu-first">
        <div class="tc mt20">
            <img alt="" width="32" class="img-circle"
                 ng-src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEEAAABBCAIAAAABlV4SAAAABnRSTlMAAAAAAABupgeRAAAAkElEQVRoge3awQnDMBAAwSikgJSSUlyqS0kpKSEt6CHssdl5C3OL/BBIY39/Hhf3PHuABWow1GCowVCDoQZDDYYaDDUYajDUYKjBUIOhBkMNhhoMNRhqMNRgqMEwJtfNX2Nvv+/BX7vDPtRgqMFQg6EGQw2GF/6eb2a8sfb4tdbkbHf4l2ow1GCowVCDoQbDHxjbDUJh+uK9AAAAAElFTkSuQmCC"
                 src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEEAAABBCAIAAAABlV4SAAAABnRSTlMAAAAAAABupgeRAAAAkElEQVRoge3awQnDMBAAwSikgJSSUlyqS0kpKSEt6CHssdl5C3OL/BBIY39/Hhf3PHuABWow1GCowVCDoQZDDYYaDDUYajDUYKjBUIOhBkMNhhoMNRhqMNRgqMEwJtfNX2Nvv+/BX7vDPtRgqMFQg6EGQw2GF/6eb2a8sfb4tdbkbHf4l2ow1GCowVCDoQbDHxjbDUJh+uK9AAAAAElFTkSuQmCC">
        </div>
        <div id="first-menu-list" class="mt10">
            <ul class="first-level-nav menu-list">
                <li><a href="#/project/all"
                       ng-class="{active:nav_first=='project'||!nav_first }" class="active" style=""><i
                        class="glyphicon  glyphicon-folder-open"></i><span class="menu-title">项目</span></a></li>
                <li><a href="#/message/all" ng-class="{active:nav_first=='message'}"
                       class="" style=""><i class="glyphicon glyphicon-comment"></i><span
                        class="menu-title">消息</span></a></li>
                <li><a href="#/account/profile"
                       ng-class="{active:nav_first=='account'}" class="" style=""><i
                        class="glyphicon glyphicon-user"></i><span class="menu-title">账户</span></a></li>
            </ul>
        </div>
    </div>
    <div class="border-right" id="side-menu-second">
        <!-- ngIf: nav_first=='project' -->
        <div ng-if="nav_first=='project'" ng-init="projectCount()" class="ng-scope">
            <div class="menu-title">
                <h3>项目</h3>
                <article>包括我创建与参与的项目</article>
            </div>
            <div class="border-bottom pb30 mb30 second-menu-list">
                <ul>
                    <li class=""><a href="#/project/create/"
                                    ng-class="{active:nav_second=='create'}">&nbsp;&nbsp;创建新项目</a></li>
                    <li class="" ng-init="getProjectList('all')" ng-click="getProjectList('all')"><a
                            href="#/project/all"
                            ng-class="{active:nav_second=='all'}" class="ng-binding active">
                        &nbsp;&nbsp;所有项目({{project_count.created}})</a></li>
                    <li class="" ng-click="getProjectList('created')"><a
                            href="#/project/created"
                            ng-class="{active:nav_second=='created'}" class="ng-binding">&nbsp;&nbsp;我创建的({{project_count.created}})</a>
                    </li>
                    <li class="" ng-click="getProjectList('joined')"><a
                            href="#/project/joined"
                            ng-class="{active:nav_second=='joined'}" class="ng-binding">&nbsp;&nbsp;我参与的({{project_count.created}})</a>
                    </li>
                </ul>
            </div>
            <!-- <div class="border-bottom pb20 mb30 second-menu-list">
                <ul>
                    <li class=""><a href="#/project/stared/" ng-class="{active:nav_second=='stared'}">&nbsp;&nbsp;我收藏的({{project_count.stared}})</a></li>
                </ul>
            </div> -->
        </div><!-- end ngIf: nav_first=='project' -->
        <!-- ngIf: nav_first=='message' -->
        <!-- ngIf: nav_first=='account' -->
    </div>
    <div class="container-fluid " id="main-content">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-title p20 ng-binding">
                    所有项目
                </div>
                <!-- ngView:  -->
                <div ng-view="" class="p20 page ng-scope">
                    <div class="row project-list ng-scope">
                        <!-- ngRepeat: p in project_list -->
                        <div class="col-lg-3 col-md-4 col-sm-6 ng-scope" ng-repeat="p in project_list">
                            <div class="border project-list-item p20 mb20 bg-white">
                                <!-- ngIf: p.edit==1 --><a class="l project-logo tc ng-scope"
                                                           ng-href="/p/2089#/project/dashbord" ng-if="p.edit==1"
                                                           href="https://apiview.com/p/2089#/project/dashbord">
                                <img src="/resource/logo_gravater_dark.jpg"
                                     class="radius-circle img-border project-logo-md" alt="logo">
                            </a><!-- end ngIf: p.edit==1 -->
                                <!-- ngIf: p.edit==0 -->
                                <div class="l project-text">
                                    <!-- ngIf: p.edit==1 --><a ng-if="p.edit==1" class="text-main tc ng-scope"
                                                               ng-href="/p/2089#/project/dashbord"
                                                               href="https://apiview.com/p/2089#/project/dashbord">
                                    <h4 class="project-name ng-binding">pnk-web</h4>
                                </a><!-- end ngIf: p.edit==1 -->
                                    <!-- ngIf: p.edit==0 -->
                                    <p class="project_intro text-opacity text-black p10 ng-binding">项目发行，申购</p>
                                </div>
                                <div class="cl"></div>
                            </div>
                        </div><!-- end ngRepeat: p in project_list -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
</body>
</html>