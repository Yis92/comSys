<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function iset(id){
            $("#btn_1").removeClass("active");
            $("#btn_2").removeClass("active");
            $("#btn_3").removeClass("active");
            $("#btn_1").bind("click");
            $("#btn_2").bind("click");
            $("#btn_3").bind("click");
            if(id == '1'){
                $("#ifr_d").attr("src","${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=1");
                $("#btn_1").addClass("active");
                $("#btn_1").unbind("click");
            }else if(id == '2'){
                $("#ifr_d").attr("src","${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=2");
                $("#btn_2").addClass("active");
                $("#btn_2").unbind("click");
            }else if(id == '3'){
                $("#ifr_d").attr("src","${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=3");
                $("#btn_3").addClass("active");
                $("#btn_3").unbind("click");
            }else if(id == '4'){
                $("#ifr_d").attr("src","${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=3");
                $("#btn_3").addClass("active");
                $("#btn_3").unbind("click");
            }
        }
    </script>

</head>

<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">数据显示（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
       <%-- <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>

    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px; height: 100%;" >
    <ul class="nav nav-tabs">
        <li role="presentation" class="active" onclick="iset('1');" id="btn_1"><a href="javascript:void(0);">实时数据</a></li>
        <li role="presentation" onclick="iset('2');" id="btn_2"><a href="javascript:void(0);">分组数据</a></li>
        <li role="presentation" onclick="iset('3');" id="btn_3"><a href="javascript:void(0);">DTU状态</a></li>
    </ul>
    <div class="panel panel-default" style="height: 100%;">
        <div class="panel-body">
           <iframe id="ifr_d" src="${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=1"  scrolling="yes" frameborder="0"  height="100%" width="100%;"></iframe>
        </div>
    </div>
</div>
</body>
</html>
