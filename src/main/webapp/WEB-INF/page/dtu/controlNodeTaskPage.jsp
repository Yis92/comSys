<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function iset(addr,id){
            $("#btn_1").removeClass("active");
            $("#btn_2").removeClass("active");
            $("#btn_3").removeClass("active");
            $("#btn_4").removeClass("active");
            $("#btn_5").removeClass("active");
            $("#btn_6").removeClass("active");
            $("#btn_7").removeClass("active");
            $("#btn_8").removeClass("active");

            $("#btn_1").bind("click");
            $("#btn_2").bind("click");
            $("#btn_3").bind("click");
            if(id == '1'){
                $("#btn_1").addClass("active");
                $("#btn_1").unbind("click");
            }else if(id == '2'){
                $("#btn_2").addClass("active");
                $("#btn_2").unbind("click");
            }else if(id == '3'){
                $("#btn_3").addClass("active");
                $("#btn_3").unbind("click");
            }else if(id == '4'){
                $("#btn_4").addClass("active");
                $("#btn_4").unbind("click");
            }else if(id == '5'){
                $("#btn_5").addClass("active");
                $("#btn_5").unbind("click");
            }else if(id == '6'){
                $("#btn_6").addClass("active");
                $("#btn_6").unbind("click");
            }else if(id == '7'){
                $("#btn_7").addClass("active");
                $("#btn_7").unbind("click");
            }else if(id == '8'){
                $("#btn_8").addClass("active");
                $("#btn_8").unbind("click");
            }
            $("#ifr_d").attr("src","${basePath }dtuHome/goTaskPage?nodeId=${dtu_sn}&nodeAddr="+addr);
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
        <li role="presentation"  class="active" ><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
        <%-- <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>
    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px; height: 100%;" >
    <ul class="nav nav-tabs">
        <c:forEach items="${taskInfo.result.group}" var="group" varStatus="status">
            <c:if test="${status.index == 0}">
                <li role="presentation" class="active" onclick="showD('${group.node_addr}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
            <c:if test="${status.index != 0}">
                <li role="presentation" class="" onclick="showD('${group.group_id}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
        </c:forEach>
       <%-- <li role="presentation" class="active" onclick="iset('1');" id="btn_1"><a href="javascript:void(0);">实时数据</a></li>
        <li role="presentation" onclick="iset('2');" id="btn_2"><a href="javascript:void(0);">分组数据</a></li>
        <li role="presentation" onclick="iset('3');" id="btn_3"><a href="javascript:void(0);">DTU状态</a></li>--%>
    </ul>
    <div class="panel panel-default" style="height: 100%;">
        <div class="panel-body">
            <iframe id="ifr_d" src="${basePath }dtuHome/goTaskPage?nodeId=${dtu_sn}&nodeAddr=${taskInfo.result.group[0].node_addr}"  scrolling="yes" frameborder="0"  height="100%" width="100%;"></iframe>
        </div>
    </div>
</div>
</body>
</html>
