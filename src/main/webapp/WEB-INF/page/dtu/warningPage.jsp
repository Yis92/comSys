<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/warningMsg.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">报警信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
        <%--<li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>

    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px;" >
    <input type="hidden" value="${dtu_sn}" id="dtu_sn">
    <c:forEach items="${warningMsg.result}" var="warningMsg" varStatus="status">
        <table class="table table-striped table-bordered table-hover" style="width: 100%;">
            <tbody class="text-center">
            <tr class="info">
                <td style="width: 35%;">报警说明：</td>
                <td style="width: 65%;">${warningMsg.msg}</td>
            </tr>
            <tr class="active">
                <td>报警时间：</td>
                <td>${warningMsg.tm}</td>
            </tr>
            <tr class="info">
                <td>处理报警信息：</td>
                <td>
                    <c:if test="${warningMsg.dispose == '0'}">
                        <button type="button" style="" class="btn btn-primary" onclick="setStatus('${warningMsg.msgid}');" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;未处理</button>&nbsp;
                    </c:if>
                    <c:if test="${warningMsg.dispose == '1'}">
                       已处理
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </c:forEach>

</div>

<!--修改信息 DIV-->
<div class="modal fade" id="myModal_upd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">修改公司信息</h4>
            </div>
            <div class="modal-body" align="center">
                <input type="hidden" value="" id="msgId">
               标记为已处理状态？
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="updStatus();">确定</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->

</body>
</html>
