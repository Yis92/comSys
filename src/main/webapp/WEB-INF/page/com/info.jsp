<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/comInfo.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<div class="container con_title" style="" >
    <input id="basePath" value="${basePath }" type="hidden">
    <h3 style="margin-left: 30px;margin-top: 30px;">公司信息</h3>
    <hr/>
    <div style="margin-left: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改信息</button>&nbsp;
        <span id="msg" class = ""></span>
    </div>
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
                <td style="width: 65%;" id="userName"></td>
            </tr>
            <tr class="active">
                <td>单位名称：</td>
                <td id="roleName"></td>
            </tr>
            <tr class="info">
                <td style="width: 35%;">位置-X：</td>
                <td style="width: 65%;" id="x"></td>
            </tr>
            <tr class="active">
                <td>位置-Y：</td>
                <td id="y"></td>
            </tr>
            <tr class="info">
                <td style="width: 35%;">联系电话1：</td>
                <td style="width: 65%;" id="phone1"></td>
            </tr>
            <tr class="active">
                <td>联系电话2：</td>
                <td id="phone2"></td>
            </tr>
            <tr class="info">
                <td style="width: 35%;">联系电话3：</td>
                <td style="width: 65%;" id="phone3"></td>
            </tr>
            <tr class="active">
                <td>联系电话4：</td>
                <td id="phone4"></td>
            </tr>
            <tr class="info">
                <td style="width: 35%;">联系电话5：</td>
                <td style="width: 65%;" id="phone5"></td>
            </tr>
            <tr class="active">
                <td>联系电话6：</td>
                <td id="phone6"></td>
            </tr>
            <tr class="info">
                <td style="width: 35%;">单位地址：</td>
                <td style="width: 65%;" id="addr"></td>
            </tr>
            <tr class="active">
                <td>使用的DTU总数：</td>
                <td id="dtuNums">1</td>
            </tr><tr class="info">
                <td style="width: 35%;">DTU 1：</td>
                <td style="width: 65%;" id="dtu1">1612020003000006</td>
            </tr>
            <tr class="active">
                <td>DTU 2：</td>
                <td id="dtu2">1612020003000002</td>
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
                <h4 class="modal-title" id="myModalLabel2">修改公司信息</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="info">
                        <td style="width: 35%;">单位编号：</td>
                        <td style="width: 65%;" id="uId"></td>
                    </tr>
                    <tr class="active">
                        <td>单位名称：</td>
                        <td id="uusers"></td>
                    </tr>
                    <tr class="info">
                        <td>位置-X：</td>
                        <td id="unikeName"></td>
                    </tr>
                    <tr class="active">
                        <td>位置-Y:</td>
                        <td id="uUserRemark"></td>
                    </tr>
                    <tr class="info">
                        <td>联系电话1:</td>
                        <td id="uAddr"></td>
                    </tr>
                    <tr class="active">
                        <td>联系电话2:</td>
                        <td id="uComId"></td>
                    </tr>
                    <tr class="info">
                        <td>联系电话3:</td>
                        <td id="uPhone1"></td>
                    </tr>
                    <tr class="active">
                        <td>联系电话4:</td>
                        <td id="uPhone2"></td>
                    </tr>
                    <tr class="info">
                        <td>...</td>
                        <td id="uPhone1">...</td>
                    </tr>
                </table>
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updPwd();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->

</body>
</html>
