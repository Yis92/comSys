<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/dtuPage.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">传感器节点信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
        <%--<li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>

    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 70px;" >
   <%-- <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="add();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
    </div>--%>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
            <tr class="" style="background-color: #3278f7;color: white;">
                <td>序号</td>
                <td>传感器名称</td>
                <td>传感器类型码</td>
                <td>传感器地址</td>
                <td>X</td>
                <td>Y</td>
                <td>传感器描述</td>
            </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="sensorNode" items="${sensorNodeInfo.result}" varStatus="status">
            <c:if test="${(status.index+1)%2 == 1}">
                <tr class="info" >
                    <td>${ststus.index+1}</td>
                    <td>${sensorNode.name}</td>
                    <td>${sensorNode.cfg}</td>
                    <td>${sensorNode.addr}</td>
                    <td>${sensorNode.x}</td>
                    <td>${sensorNode.y}</td>
                    <td>${sensorNode.describ}</td>
                </tr>
            </c:if>
            <c:if test="${(status.index+1)%2 == 0}">
                <tr class="active" >
                    <td>${ststus.index+1}</td>
                    <td>${sensorNode.name}</td>
                    <td>${sensorNode.cfg}</td>
                    <td>${sensorNode.addr}</td>
                    <td>${sensorNode.x}</td>
                    <td>${sensorNode.y}</td>
                    <td>${sensorNode.describ}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
