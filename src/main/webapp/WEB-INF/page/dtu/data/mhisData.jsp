<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>历史数据</title>
    <script type="text/javascript" src="${basePath }common/myjs/mhisData.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript" src="${basePath }common/my97/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath }common/echarts/echarts.js"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input type="hidden" value="${pId}" id="pId">
<h4>历史数据</h4><hr/>
<form class="form-inline">
    <div class="form-group">
            <label for="dataNo">分组类型</label>
            <select class="form-control" id="dataNo">
                <option value=""></option>
                <c:forEach items="${groupDataList}" var="data">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
    </div>&nbsp;&nbsp;
    <div class="form-group">
        <label for="dataType">数据类型</label>
        <select class="form-control" id="dataType">
            <option value="1" checked = "checked">分钟数据</option>
            <option value="2">小时数据</option>
        </select>
    </div>&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" class="btn btn-primary" id="searchBtn" ><span class="glyphicon glyphicon-search"></span>查询</button>
</form>
<div class="panel-body" id="show_div">
    <%-- <div style="width: 100%;    float: right;   padding-right: 40%;    padding-bottom: 20px;   padding-top: 10px; display: none;"><span id="dt" style="color:red;float: right;">观测时间:</span></div>--%>
    <div id="main" style="width: 100%;height:480px;">
    </div>
        <div style="margin-left: 38%;margin-top: 0px;margin-bottom: 0px; ">
            <ul class="nav nav-pills">
                <li><button type="button" style="" class="btn btn-info" onclick="up();" id="autoId"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;前一天</button>&nbsp;&nbsp;&nbsp;</li>
                <li><button type="button" style="" class="btn btn-primary" onclick="down();">后一天&nbsp;<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>&nbsp;&nbsp;&nbsp;</li>
            </ul>
        </div>
</div>

</body>
</html>
