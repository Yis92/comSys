<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>历史数据</title>
    <script type="text/javascript" src="${basePath }common/myjs/m2hisData.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript" src="${basePath }common/my97/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath }common/echarts/echarts.js"></script>
    <link rel="stylesheet" href="${basePath }common/css/bootstrap-select.min.css"/>
    <script src="${basePath }common/bootstrap/js/bootstrap-select.min.js"></script>
    <style>
        .open{
            width: 80%;
        }
        .bootstrap-select.form-control:not([class*=col-]) {
            width: 80%;
        }
    </style>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input type="hidden" value="${pId}" id="pId">
<%--<h4>历史数据</h4><hr/>--%>
<form class="form-inline" style="margin-top: 15px; margin-left: 50px;">

    <div class="form-group" style="width: 80%;">
        <label for="dataNo" >分组类型</label>
        <select id="dataNo" class="selectpicker show-tick form-control" multiple data-live-search="false">
            <%--<option value=""></option>--%>
            <c:forEach items="${groupDataList}" var="data">
                <option value="${data.id}">${data.name}</option>
            </c:forEach>
        </select>
    </div>&nbsp;&nbsp;<br/>
    <%--<div class="form-group">
        <label for="dataNo">分组类型</label>
        <select class="form-control" id="dataNo">
            <option value=""></option>
            <c:forEach items="${groupDataList}" var="data">
                <option value="${data.id}">${data.name}</option>
            </c:forEach>
        </select>
    </div>&nbsp;&nbsp;
    --%>
    <div class="form-group" style="margin-top: 20px;width: 80%;">
        <label for="dataType">数据类型</label>
        <select  class="selectpicker show-tick form-control" id="dataType"><%--class="form-control"--%>
            <option value="1" checked = "checked">分钟数据</option>
            <option value="2">小时数据</option>
        </select>
    </div>&nbsp;&nbsp;<br/>
    <button type="button" class="btn btn-primary" id="searchBtn" style="margin-top: 20px;" ><span class="glyphicon glyphicon-search"></span>查询</button>
</form>
<div class="panel-body" id="show_div">
    <%-- <div style="width: 100%;    float: right;   padding-right: 40%;    padding-bottom: 20px;   padding-top: 10px; display: none;"><span id="dt" style="color:red;float: right;">观测时间:</span></div>--%>
    <div id="main" style="width: 100%;height:380px;">
    </div>
    <div style="margin-left: 38%;margin-top: 0px;margin-bottom: 0px; display: block;" id="d_show">
        <ul class="nav nav-pills">
            <li><button type="button" style="" class="btn btn-info" onclick="up(1);" id="autoId"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;前一天</button>&nbsp;&nbsp;&nbsp;</li>
            <li><button type="button" style="" class="btn btn-primary" onclick="down(1);">后一天&nbsp;<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>&nbsp;&nbsp;&nbsp;</li>
        </ul>
    </div>
        <div style="margin-left: 38%;margin-top: 0px;margin-bottom: 0px; display: none;" id="w_show">
            <ul class="nav nav-pills">
                <li><button type="button" style="" class="btn btn-info" onclick="up(7);" id="auto7Id"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;前一周</button>&nbsp;&nbsp;&nbsp;</li>
                <li><button type="button" style="" class="btn btn-primary" onclick="down(7);">后一周&nbsp;<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>&nbsp;&nbsp;&nbsp;</li>
            </ul>
        </div>
</div>

</body>
</html>
