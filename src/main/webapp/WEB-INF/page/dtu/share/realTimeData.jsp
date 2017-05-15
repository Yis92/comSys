<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>实时数据</title>
   <%-- <script type="text/javascript" src="${basePath }common/myjs/realTimeData.js?ran=<%=Math.random()%>"></script>--%>
    <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
    <script type="text/javascript">
        $(function () {
            var timeR = $("#timeR").val();
            $("#refreshId").val(timeR);
            if(timeR == '60000'){
                setTimeout(function() {
                    auto(timeR);
                },60000);
            }else if(timeR == '300000'){
                setTimeout(function() {
                    auto(timeR);
                },300000);
            }else if(timeR == '600000'){
                setTimeout(function() {
                    auto(timeR);
                },600000);
            }else{
                console.log("不进行自动刷新");
                return false;
            }
        });

        function refresh(){
            location.reload();
        }

        function autoRefresh(){
            var date = $("#refreshId").val();
            auto(date);
        }

        function auto(date){
            window.location.href = " ${basePath }dtuShare/goDataPage?nodeId=${dtu_sn}&timeR="+date;
        }
    </script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input id="timeR" type="hidden" value="${timeR}">

<h3 style="margin-left: 30px;margin-top: 30px;">实时数据（${dtuInfo.dtu_name}）</h3>
<hr/>
<div class="container con_title" style="margin-top: 0px;" >
    <div style="margin-left: 0px;margin-top: 0px;margin-bottom: 0px; ">
        <ul class="nav nav-pills">
            <li role="presentation" class="dropdown">
                <select class="form-control" id="refreshId">
                    <option value="60000">1分钟</option>
                    <option value="300000">5分钟</option>
                    <option value="600000">10分钟</option>
                </select>
                &nbsp;&nbsp;
            </li>
            <li><button type="button" style="" class="btn btn-info" onclick="autoRefresh();" id="autoId"><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>&nbsp;自动刷新</button>&nbsp;&nbsp;&nbsp;</li>
            <li><button type="button" style="" class="btn btn-primary" onclick="refresh();"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新</button>&nbsp;&nbsp;&nbsp;</li>
        </ul>
        <%--<button type="button" style="" class="btn btn-primary" onclick="refresh();"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新</button>&nbsp;--%>
    </div>
    <span style="color:red;font-size: 18px;">观测时间：${rtData.dt}</span>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
            <thead class="text-center">
            <tr class="" style="background-color: #3278f7;color: white;">
                <td>观测要素</td>
                <td>数值</td>
                <td>状态</td>
            </tr>
            </thead>
            <tbody class="text-center">
        <c:forEach var="sensorNode" items="${rtData.result}" varStatus="status">
            <c:if test="${sensorNode[4] == '0'}">
                <tr class="active" >
                        <td>${sensorNode[0]}</td>
                        <td>${sensorNode[1]}</td>
                        <td>${sensorNode[2]}</td>
                </tr>
            </c:if>
            <c:if test="${sensorNode[4] == '1'}">
                <tr class="success" >
                    <td>${sensorNode[0]}</td>
                    <td>${sensorNode[1]}</td>
                    <td>${sensorNode[2]}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
