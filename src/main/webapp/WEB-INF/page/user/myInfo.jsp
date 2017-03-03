<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>DTU</title>
    <script type="text/javascript" src="${basePath }common/myjs/myInfo.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<div class="container con_title" style="" >
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">我的信息</h3>
<hr/>
    <div style="margin-left: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改资料</button>&nbsp;
        <button type="button" style="" class="btn btn-success" data-toggle="modal" data-target="#myModal" onclick="openPwd();" ><span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>&nbsp;修改密码</button>&nbsp;
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
        <td style="width: 35%;">用户ID：</td>
        <td style="width: 65%;">${userInfo.user_id}</td>
    </tr>
    <tr class="active">
        <td>用户等级：</td>
        <td>${userInfo.user_level}</td>
    </tr>
    <tr class="info">
        <td>用户全名：</td>
        <td>${userInfo.user_full_name}</td>
    </tr>
    <tr class="active">
        <td>用户描述:</td>
        <td>${userInfo.user_describ}</td>
    </tr>
   <%-- <tr class="info">
        <td>居住地址:</td>
        <td id="addr"></td>
    </tr>--%>
    <tr class="info">
        <td>用户单位编号:</td>
        <td>${userInfo.user_unit_num}</td>
    </tr>
    <tr class="active">
        <td>用户电话1:</td>
        <td>${userInfo.user_tel1}</td>
    </tr>
    <tr class="info">
        <td>用户电话2:</td>
        <td>${userInfo.user_tel2}</td>
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
                <h4 class="modal-title" id="myModalLabel2">修改信息</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="info">
                        <td style="width: 35%;">用户ID：</td>
                        <td style="width: 65%;">
                            ${userInfo.user_id}
                            <input type="hidden" value="${userInfo.user_id}" id="userId" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>用户等级：</td>
                        <td>
                            ${userInfo.user_level}
                            <input type="hidden" value="${userInfo.user_level}" id="userLevel">
                        </td>
                    </tr>
                    <tr class="info">
                        <td>用户全名：</td>
                        <td><input type="text" value="${userInfo.user_full_name}" id="fullName" /></td>
                    </tr>
                    <tr class="active">
                        <td>用户描述:</td>
                        <td><textarea id="desc" rows="3" cols="20" id="desc" >${userInfo.user_describ}</textarea></td>
                    </tr>
                    <%--<tr class="info">
                        <td>居住地址:</td>
                        <td id="uAddr"></td>
                    </tr>--%>
                    <tr class="info">
                        <td>用户单位编号:</td>
                        <td><input type="text" id="unitNum" value="${userInfo.user_unit_num}" /></td>
                    </tr>
                    <tr class="active">
                        <td>用户电话1:</td>
                        <td><input type="text" id="phone1" value="${userInfo.user_tel1}"/></td>
                    </tr>
                    <tr class="info">
                        <td>用户电话2:</td>
                        <td><input type="text" id="phone2" value="${userInfo.user_tel2}" /></td>
                    </tr>
                </table>
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updInfo();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->

<!--修改密码 DIV -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="active">
                        <td>初始密码：</td>
                        <td>
                            <input type="password" class="form-control input-sm" id="bpassword" title="长度在6~22位之间" placeholder="请输入初始密码">
                        </td>
                    </tr>
                    <tr class="success">
                        <td>修改密码：</td>
                        <td>
                            <input type="password" class="form-control input-sm" id="upass" title="长度在6~22位之间" placeholder="请输入6~22位之间的新密码">
                        </td>
                    </tr>
                    <tr class="info">
                        <td>确认密码：</td>
                        <td>
                            <input type="password" class="form-control input-sm" id="apass" title="长度在6~22位之间" onblur="checkPwd();" placeholder="请输入确认密码">
                        </td>
                    </tr>
                </table>
                <span id="pmsg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updPwd();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改密码 DIV  ------end -->

<!--修改密码成功 DIV -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >修改密码</h4>
            </div>
            <div class="modal-body" align="center">
                <h3 style="color: blue;">密码修改成功！</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <%--<button type="button" class="btn btn-primary" onclick="updPwd();">保存</button>--%>
            </div>
        </div>
    </div>
</div>
<!--修改密码成功 DIV  ------end -->
</body>
</html>
