<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/DTU.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<div class="container con_title" style="" >
    <input id="basePath" value="${basePath }" type="hidden">
    <h3 style="margin-left: 30px;margin-top: 30px;">公司信息</h3>
    <hr/>
    <%--<div style="margin-left: 10px;margin-bottom: 10px; ">--%>
        <%--<button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改信息</button>&nbsp;--%>
        <%--<span id="msg" class = ""></span>--%>
    <%--</div>--%>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <%--<thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>DTU名称</td>
            <td>DUT名称</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach items="${dtuList}" var="dtu" varStatus ="status">
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
        </tbody>--%>
            <thead class="text-center">
            <tr class="" style="background-color: #3278f7;color: white;">
                <td>DTU名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody class="text-center">
            <c:forEach items="${dtuList}" var="dtu" varStatus ="status">
                <tr class="cls_${(status.index+1)%2 == 1}" >
                    <td>${dtu.dtu_name}</td>
                    <td>
                        <button type="button" style="" class="btn btn-primary" onclick="dtuState('${dtu.dtu_sn}')" data-toggle="modal" data-target="#dtuData" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;数据</button>&nbsp;
                        <button type="button" style="" class="btn btn-danger test"  onclick="dtuState('${dtu.dtu_sn}')" data-toggle="modal" data-target="#dtuState" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;状态</button>&nbsp;
                        <%--<button type="button" style="" class="btn btn-success" onclick="edit('${dtu.dtu_sn}')" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-th" aria-hidden="true"></span>&nbsp;数据</button>&nbsp;--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
    </table>
</div>

<!--dtu状态 -->
<div class="modal fade" id="dtuState" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">DTU状态</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <thead class="text-center">
                    <tr class="" style="background-color: #3278f7;color: white;">
                        <td>设备名</td>
                        <td>电压</td>
                        <td>状态</td>
                    </tr>
                    </thead>
                    <tbody class="text-center stateTable">

                    </tbody>
                </table>
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doUpd();">保存</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
