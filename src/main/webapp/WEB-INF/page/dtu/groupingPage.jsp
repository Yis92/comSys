<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/groupingPage.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript" src="${basePath }common/echarts/echarts.js"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">DTU分组信息</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }myHome/goDTUPage?nodeId=${dtu_sn}">DTU信息</a></li>
        <li role="presentation" ><a href="${basePath }dtuHome/goNodePage?nodeId=${dtu_sn}">节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goWarningPage?nodeId=${dtu_sn}">报警信息</a></li>
        <li role="presentation" class="active"><a href="javascript(void);">分组信息</a></li>
        <%--<li role="presentation"><a href="#">实时数据</a></li>--%>
        <li role="presentation"><a href="${basePath }dtuHome/goStatusPage?nodeId=${dtu_sn}">状态数据</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goHistoryPage?nodeId=${dtu_sn}">历史数据</a></li>
    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px;" >
    <ul class="nav nav-pills">
        <li role="presentation" class="dropdown">
            <select class="form-control">
                <option>办公区监控</option>
                <option>前台监控</option>
                <option>会议室监控</option>
            </select>
        </li>
    </ul>
    <div class="container-fluid" style="margin-top: 20px;">
        <div id="main" style="width: 100%;height:640px;">
        </div>
    </div>
</div>
</body>
</html>
