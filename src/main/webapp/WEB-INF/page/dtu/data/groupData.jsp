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
<input id="til" type="hidden" value="${groupInfo.result.group[0].name}">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input id="firstId" type="hidden" value="${groupInfo.result.group[0].group_id}">

<div class="container con_title" style="margin-top: 50px;" >
    <ul class="nav nav-tabs nav-justified">
       <%-- <c:forEach items="'${groupInfo.result.group}" var="group" varStatus="status">
            <c:if test="${status.index == 0}">
                <li role="presentation" class="active" onclick="showD('${group.group_id}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
            <c:if test="${status.index != 0}">
            <li role="presentation" class="" onclick="showD('${group.group_id}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
        </c:forEach>--%>
        <li role="presentation" class="active" onclick="showD('${groupInfo.result.group[0].group_id}','1');" id="btn_1"><a href="javascript:void(0);">${groupInfo.result.group[0].name}</a></li>
        <li role="presentation" class="" onclick="showD('${groupInfo.result.group[1].group_id}','2');" id="btn_2"><a href="javascript:void(0);">${groupInfo.result.group[1].name}</a></li>
        <li role="presentation" class="" onclick="showD('${groupInfo.result.group[2].group_id}','3');" id="btn_3"><a href="javascript:void(0);">${groupInfo.result.group[2].name}</a></li>
    </ul>
</div>
    <div class="panel-body" id="show_div">
        <div id="main" style="width: 100%;height:640px;">
        </div>
        <span id="dt" style="color:red;">观测时间:${groupInfo.dt}</span>
    </div>

</body>
</html>
