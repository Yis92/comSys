<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/my97/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath }common/myjs/taskPage.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript">
        function refresh(){
            location.reload();
        }
    </script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId">
<input type="hidden" value="${tsData.result.tskinfo.node_addr}" id="nodeAddr">
<div class="container con_title" style="margin-top: 50px;" >
    <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="refresh();"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新</button>&nbsp;
    </div>
    <span style="color:red;padding-left: 38%;">观测时间：${tsData.dt}</span>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>任务通道号</td>
            <td>通道描述</td>
            <td>任务类型</td>
            <td>任务执行日期</td>
            <td>任务执行时间</td>
            <td>任务执行周期</td>
            <td>任务剩余时间</td>
            <td>状态</td>
            <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
            <td>操作</td>
            </c:if>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="tsk" items="${tsData.result.tskinfo.tsk}" varStatus="status">
            <c:if test="${status.index%2 != '0'}">
                <tr class="active" >
                    <td>${tsk.tsk_channel}</td>
                    <td>${tsk.tsk_describ}</td>
                    <c:if test="${tsk.tsk_type == 0}">
                        <td>立即关闭</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 1}">
                        <td>立即打开</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 2}">
                        <td>计划打开</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 3}">
                        <td>没有任务</td>
                    </c:if>
                    <td>${tsk.tsk_dt}</td>
                    <td>${tsk.tsk_tm}</td>
                    <td>${tsk.tsk_second}</td>
                    <td>${tsk.tsk_surplus}</td>
                    <c:if test="${tsk.tsk_status == 0}">
                        <td>正常</td>
                    </c:if>
                    <c:if test="${tsk.tsk_status == 1}">
                        <td>异常</td>
                    </c:if>
                <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
                    <td><button type="button" style="" class="btn btn-primary" onclick="upd('${tsk.tsk_channel}','${tsk.tsk_describ}','${tsk.tsk_type}','${tsk.tsk_dt}','${tsk.tsk_tm}','${tsk.tsk_second}');" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;</td>
                </c:if>
                </tr>
            </c:if>
            <c:if test="${status.index%2 == '0'}">
                <tr class="success" >
                    <td>${tsk.tsk_channel}</td>
                    <td>${tsk.tsk_describ}</td>
                    <c:if test="${tsk.tsk_type == 0}">
                        <td>立即关闭</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 1}">
                        <td>立即打开</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 2}">
                        <td>计划打开</td>
                    </c:if>
                    <c:if test="${tsk.tsk_type == 3}">
                        <td>没有任务</td>
                    </c:if>
                    <td>${tsk.tsk_dt}</td>
                    <td>${tsk.tsk_tm}</td>
                    <td>${tsk.tsk_second}</td>
                    <td>${tsk.tsk_surplus}</td>
                    <c:if test="${tsk.tsk_status == 1}">
                        <td>正常</td>
                    </c:if>
                    <c:if test="${tsk.tsk_status == 0}">
                        <td>故障</td>
                    </c:if>
                    <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
                        <td><button type="button" style="" class="btn btn-primary" onclick="upd('${tsk.tsk_channel}','${tsk.tsk_describ}','${tsk.tsk_type}','${tsk.tsk_dt}','${tsk.tsk_tm}','${tsk.tsk_second}');" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;</td>
                    </c:if>
                </tr>
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
                <h4 class="modal-title" id="myModalLabel2">修改</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="info">
                        <td style="width: 35%;">任务通道号：</td>
                        <td style="width: 65%;" >
                            <input type="text" class="form-control" placeholder="请输入任务通道号" id="uchannel" readonly="readonly">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>通道描述：</td>
                        <td>
                            <input type="text" class="form-control" placeholder="请输入通道描述" id="udesc" readonly="readonly">
                        </td>
                    </tr>
                    <tr class="info">
                        <td>任务类型：</td>
                        <td>
                            <select class="form-control" id="utype">
                                <option value="0" selected = 'selected'>立即关闭</option>
                                <option value="1">立即打开</option>
                                <option value="2">计划打开</option>
                                <option value="3">没有任务</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>任务执行日期：</td>
                        <td>
                            <input id="udt" type="text" class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'2010-1-01',maxDate:'2050-12-31'})"/>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>任务执行时间：</td>
                        <td>
                            <input id="utm" type="text" class="form-control" onClick="WdatePicker({dateFmt:'HH:mm:ss'})"/>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>任务执行周期：</td>
                        <td>
                            <input type="number" class="form-control" placeholder="请输入任务执行周期（单位：S）" id="uecond">
                        </td>
                    </tr>
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
<!--修改信息 DIV-->

</body>
</html>

