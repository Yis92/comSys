<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
   <%-- <script type="text/javascript" src="${basePath }common/myjs/dtuPage.js?ran=<%=Math.random()%>"></script>--%>
    <script type="text/javascript">

        function goTask() {
            window.location.href = "${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=7";
        }
    </script>

</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">控制节点信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
       <%-- <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>
    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px;" >
<c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
    <div style="float: right; margin-right: 30px;margin-top: 10px;margin-bottom: 10px; ">
       <%-- <button type="button" style="" class="btn btn-primary" onclick="add();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;--%>
        <button type="button" style="" class="btn btn-primary" onclick="goTask();" data-toggle="modal" data-target="" ><span class="glyphicon glyphicon-send" aria-hidden="true"></span>&nbsp;任务</button>&nbsp;
    </div>
</c:if>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>序号</td>
            <td>控制器名称</td>
            <td>控制器类型码</td>
            <td>控制器地址</td>
            <td>控制器描述</td>
            <td>控制器站内坐标X</td>
            <td>控制器站内坐标Y</td>
            <td>控制器任务数</td>
            <td>通道描述</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="controlNode" items="${ctrlNodeInfo.result}" varStatus="status">
            <c:if test="${(status.index+1)%2 == 1}">
            <tr class="info">
                <td>${ststus.index+1}</td>
                <td>${controlNode.name}</td>
                <td>${controlNode.cfg}</td>
                <td>${controlNode.addr}</td>
                <td>${controlNode.describ}</td>
                <td>${controlNode.x}</td>
                <td>${controlNode.y}</td>
                <td>${controlNode.tsknum}</td>
                <td>
                    <table>
                        <c:forEach var="desc" items="${controlNode.tskdescrib}" >
                            <tr class="info"><td>${desc.tsk_describ}</td></tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            </c:if>
            <c:if test="${(status.index+1)%2 == 0}">
                <tr class="active">
                <td>${ststus.index+1}</td>
                <td>${controlNode.name}</td>
                <td>${controlNode.cfg}</td>
                <td>${controlNode.addr}</td>
                <td>${controlNode.describ}</td>
                <td>${controlNode.x}</td>
                <td>${controlNode.y}</td>
                <td>${controlNode.tsknum}</td>
                    <td>
                        <table>
                            <c:forEach var="desc" items="${controlNode.tskdescrib}" >
                                <tr class="active"><td>${desc.tsk_describ}</td></tr>
                            </c:forEach>
                        </table>
                    </td>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

<!--修改信息 DIV-->
<div class="modal fade" id="myModal_upd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabeladd">修改DTU信息</h4>
                <input type="hidden" value="${dtu_sn}" id="dtu_sn">
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <thead class="text-center">
                    <tr class="" style="background-color: #3278f7;color: white;">
                        <td>项目</td>
                        <td>数值</td>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <tr class="info">
                        <td style="width: 35%;">DTU名称：</td>
                        <td style="width: 65%;">
                            <input class="form-control" type="text" value="" id="dtu_name" placeholder="请输入DTU名称" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>设备描述：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_describ" placeholder="请输入设备描述" />

                        </td>
                    </tr>
                    <tr class="info">
                        <td>安装位置：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_address" placeholder="请输入安装位置" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>安装经度：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_long" placeholder="请输入安装经度" />
                        </td>
                    </tr>
                    <tr class="info">
                        <td>安装纬度：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_lat" placeholder="请输入安装纬度" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>报警类型：</td>
                        <td>
                            <select class="form-control" id="dtu_warning_type" value="">
                                <option value="0">app</option>
                                <option value="1">短信</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>上传频率：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_upfreq" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>通信类型：</td>
                        <td>
                            <select class="form-control" id="dtu_comm_type" value="">
                                <option value="0">GPRS</option>
                                <option value="1">WIFI</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>sim卡号：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_sim_no" placeholder="请输入sim卡卡号" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>DTU类型</td>
                        <td>
                            <input class="form-control" type="text" value="" id="dtu_type" readonly="readonly" />
                        </td>
                    </tr>
                    </tbody>
                </table>
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updDTUInfo();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->

</body>
</html>
