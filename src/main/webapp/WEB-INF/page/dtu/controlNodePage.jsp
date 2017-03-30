<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/dtuPage.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">DTU历史数据</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }myHome/goDTUPage?nodeId=${dtu_sn}">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goSensorNodePage?nodeId=${dtu_sn}">传感器节点信息</a></li>
        <li role="presentation"  class="active"><a href="${basePath }dtuHome/goControlNodePage?nodeId=${dtu_sn}">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goWarningPage?nodeId=${dtu_sn}">报警信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goGroupingPage?nodeId=${dtu_sn}">分组信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDataDisplayPage?nodeId=${dtu_sn}">数据显示</a></li>
    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px;" >
    <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="add();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
    </div>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>项目</td>
            <td>数值</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <tr class="info">
            <td style="width: 35%;">DTU名称：</td>
            <td style="width: 65%;"></td>
        </tr>
        <tr class="active">
            <td>设备描述：</td>
            <td></td>
        </tr>
        <tr class="info">
            <td>安装位置：</td>
            <td></td>
        </tr>
        <tr class="active">
            <td>安装经度：</td>
            <td></td>
        </tr>
        <tr class="info">
            <td>安装纬度：</td>
            <td></td>
        </tr>
        <tr class="active">
            <td>报警类型：</td>
            <td></td>
        </tr>
        <tr class="info">
            <td>上传频率：</td>
            <td></td>
        </tr>
        <tr class="active">
            <td>通信类型：</td>
            <td></td>
        </tr>
        <tr class="info">
            <td>sim卡号：</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
