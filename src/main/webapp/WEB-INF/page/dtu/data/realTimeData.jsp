<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        function refresh(){
            location.reload();
        }
    </script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<div class="container con_title" style="margin-top: 50px;" >
    <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="refresh();"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新</button>&nbsp;
    </div>
    <span style="color:red;padding-left: 38%">观测时间：${rtData.dt}</span>
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
                <tr class="active" >
                        <td>${sensorNode[0]}</td>
                        <td>${sensorNode[1]}</td>
                        <td>${sensorNode[2]}</td>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
