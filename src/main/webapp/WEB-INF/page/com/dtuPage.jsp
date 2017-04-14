<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/dtuPage.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript">
        function showDiv(){
            $("#dtu_name").val('${dtuInfo.dtu_name}');
            $("#dtu_describ").val('${dtuInfo.dtu_describ}');
            $("#dtu_address").val('${dtuInfo.dtu_address}');
            $("#dtu_long").val('${dtuInfo.dtu_long}');
            $("#dtu_lat").val('${dtuInfo.dtu_lat}');
            $("#dtu_comm_type").val(${dtuInfo.dtu_comm_type});
            $("#dtu_upfreq").val('${dtuInfo.dtu_upfreq}');
            $("#dtu_warning_type").val('${dtuInfo.dtu_warning_type}');
            $("#dtu_sim_no").val('${dtuInfo.dtu_sim_no}');
            $("#dtu_type").val('${dtuInfo.dtu_type}');
        }
    </script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">DTU信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>
    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 70px;" >
    <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
        <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
            <button type="button" style="" class="btn btn-primary" onclick="showDiv();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
        </div>
    </c:if>

    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>项目</td>
            <td>数值</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <tr class="info">
            <td style="width: 35%;">DTU名称：</td>
            <td style="width: 65%;">${dtuInfo.dtu_name}</td>
        </tr>
        <tr class="active">
            <td>设备描述：</td>
            <td>${dtuInfo.dtu_describ}</td>
        </tr>
        <tr class="info">
            <td>安装位置：</td>
            <td>${dtuInfo.dtu_address}</td>
        </tr>
        <tr class="active">
            <td>安装经度：</td>
            <td>${dtuInfo.dtu_long}</td>
        </tr>
        <tr class="info">
            <td>安装纬度：</td>
            <td>${dtuInfo.dtu_lat}</td>
        </tr>
        <tr class="active">
            <td>报警类型：</td>
            <td>
                    <c:if test="${dtuInfo.dtu_warning_type == '0'}">
                        APP
                    </c:if>
                    <c:if test="${dtuInfo.dtu_warning_type == '1'}">
                        短信
                    </c:if>
            </td>
        </tr>
        <tr class="info">
            <td>上传频率：</td>
            <td>${dtuInfo.dtu_upfreq}</td>
        </tr>
        <tr class="active">
            <td>通信类型：</td>
            <td>
                <c:if test="${dtuInfo.dtu_comm_type == '0'}">
                    GPRS
                </c:if>
                <c:if test="${dtuInfo.dtu_comm_type == '1'}">
                   WIFI
                </c:if>
            </td>
        </tr>
        <tr class="info">
            <td>sim卡号：</td>
            <td>${dtuInfo.dtu_sim_no}</td>
        </tr>
        <tr class="active">
            <td>DTU类型</td>
            <td>${dtuInfo.dtu_type}</td>
        </tr>
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
