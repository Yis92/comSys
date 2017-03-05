<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-family: '微软雅黑';">
<div class="container con_title" style="" >
    <input id="basePath" value="${basePath }" type="hidden">
    <h3 style="margin-left: 30px;margin-top: 30px;">公司信息</h3>
    <hr/>
   <%-- <div style="margin-left: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改信息</button>&nbsp;
        <span id="msg" class = ""></span>
    </div>--%>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>项目</td>
            <td>数值</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <tr class="info">
            <td style="width: 35%;">单位编号：</td>
            <td style="width: 65%;">${comInfo.unit_no}</td>
        </tr>
        <tr class="active">
            <td>单位名称：</td>
            <td>${comInfo.unit_name}</td>
        </tr>
        <tr class="info">
            <td>地理经度：</td>
            <td>${comInfo.unit_long}</td>
        </tr>
        <tr class="active">
            <td>地理纬度:</td>
            <td>${comInfo.unit_lat}</td>
        </tr>
        <tr class="info">
            <td>地理位置：</td>
            <td>${comInfo.address}</td>
        </tr>
        <tr class="active">
            <td>公司电话1:</td>
            <td>${comInfo.unit_tel1}</td>
        </tr>
        <tr class="info">
            <td>公司电话2:</td>
            <td>${comInfo.unit_tel2}</td>
        </tr>
        <tr class="active">
            <td>公司电话3:</td>
            <td>${comInfo.unit_tel3}</td>
        </tr>
        <tr class="info">
            <td>公司电话4:</td>
            <td>${comInfo.unit_tel4}</td>
        </tr>
        <tr class="active">
            <td>公司电话5:</td>
            <td>${comInfo.unit_tel5}</td>
        </tr>
        <tr class="info">
            <td>公司电话6:</td>
            <td>${comInfo.unit_tel6}</td>
        </tr>
        <tr class="active">
            <td>dtu数量：</td>
            <td>${comInfo.dtu_num}</td>
        </tr>
        <c:forEach items="${comInfo.dtu}" var="dtu" varStatus ="status">
            <c:if test="${(status.index+1)%2 == 1}">
                <tr class="info">
                    <td>dtu${status.index+1}</td>
                    <td>${dtu.dtu_sn}</td>
                </tr>
            </c:if>
            <c:if test="${(status.index+1)%2 == 0}">
                <tr class="active">
                    <td>dtu${status.index+1}</td>
                    <td>${dtu.dtu_sn}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
