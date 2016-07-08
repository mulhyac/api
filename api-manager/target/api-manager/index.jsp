<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/6 0006
  Time: 下午 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Api管理</title>
    <style>
        .div_left {
            background-color: #e4e4e4;
            width: 202px;
            text-align: left;
            margin-right: auto;
            margin-top: auto;
            float: left;
            height: 560px;
        }

        .div_rigth {
            background-color: #F7F7F7;
            margin-left: auto;
            margin-top: auto;
            margin-bottom: auto;
            width: 770px;
            height: 560px;
            overflow-y: auto;
            overflow-x: auto;
            text-align: left;
        }
    </style>
</head>
<body>
<div style="margin: 15px 5px 15px 5px; float:left;" text-align="left">
    <div class="div_left">
        <ul><br/>
            <li><h1><a id="gotop1" href="#divTop1">前边</a></h1></li>
            <li><h1><a id="gotop2" href="#divTop2">简介</a></h1></li>
            <li><h1><a id="gotop3" href="#divTop3">中间</a></h1></li>
            <li><h1><a id="gotop4" href="#divTop4">后边</a></h1></li>
        </ul>
    </div>
    <!-- 代码开始 -->
    <div class="div_rigth">
        <a name="divTop1"></a>
        <div style="height:900px; background:#999999">
        </div>
        <a name="divTop2"></a>
        <div style="height:900px; background:#444444">
        </div>
        <a name="divTop3"></a>
        <div style="height:900px; background:#555555">
        </div>
        <a name="divTop4"></a>
        <div style="height:900px; background:#666666">
        </div>
    </div>
</div>
</body>
</html>
