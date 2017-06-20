<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/hisTets.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript" src="${basePath }common/my97/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath }common/echarts/echarts.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>--%>
    <script>
        $(window).on('load', function () {
            $('#dataNo').selectpicker({
                'selectedText': 'cat'
            });
        });
    </script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input type="hidden" value="${pId}" id="pId">
<h4>历史数据</h4><hr/>
<form class="form-inline">
    <div class="form-group">
        <label for="startDate">起始时间</label>
        <input id="startDate" type="text" class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2010-1-01',maxDate:'2050-12-31'})"/>
    </div>
    <div class="form-group">
        <label for="endDate">结束时间</label>
        <input id="endDate" type="text" class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2010-1-01',maxDate:'2050-12-31'})"/>
    </div>

    <div class="form-group">
        <label for="dataType">数据类型</label>
        <select class="form-control" id="dataType">
            <option value="1" checked = "checked">分钟数据</option>
            <option value="2">小时数据</option>
        </select>
    </div>&nbsp;&nbsp;&nbsp;&nbsp;

   <%-- <button type="button" class="btn btn-danger" id="today();" ><span class="glyphicon glyphicon-time"></span>本日</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" class="btn btn-info" id="seven();" ><span class="glyphicon glyphicon-time"></span>近7天</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" class="btn btn-warning" id="san();" ><span class="glyphicon glyphicon-time"></span>近30天</button>&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <br/>

    <div class="form-group">
        <label for="dataNo" class="control-label">分组类型</label>
        <select id="dataNo" class="selectpicker show-tick form-control" multiple data-live-search="false">
            <option value=""></option>
            <c:forEach items="${groupDataList}" var="data">
                <option value="${data.id}">${data.name}</option>
            </c:forEach>
        </select>
    </div>&nbsp;&nbsp;

    <br/>
    <div class="form-group" style="margin-top: 10px;">
        <button type="button" class="btn btn-danger" onclick="today();" ><span class="glyphicon glyphicon-time"></span>本日</button>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-info" onclick="seven();" ><span class="glyphicon glyphicon-time"></span>近7天</button>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-warning" onclick="san();" ><span class="glyphicon glyphicon-time"></span>近30天</button>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-primary" id="searchBtn" ><span class="glyphicon glyphicon-search"></span>查询</button>
    </div>
</form>
<div class="panel-body" id="show_div">
    <%-- <div style="width: 100%;    float: right;   padding-right: 40%;    padding-bottom: 20px;   padding-top: 10px; display: none;"><span id="dt" style="color:red;float: right;">观测时间:</span></div>--%>
    <div id="main" style="width: 100%;height:380px;">
    </div>
</div>

</body>
</html>
