<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-family: '微软雅黑';">
<div class="container con_title" style="" >
    <input id="basePath" value="${basePath }" type="hidden">
    <h3 style="margin-left: 30px;margin-top: 30px;">单位用户</h3>
    <hr/>
    <div style="margin-left: 10px;margin-bottom: 10px; ">

        <span id="msg" class = ""></span>
    </div>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>用户编号</td>
            <td>用户组</td>
            <td>用户全名</td>
            <td>用户描述</td>
            <td>用户电话</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody class="text-center">
            <tr class="info">
                <td>1</td>
                <td>用户组1</td>
                <td>用户1</td>
                <td>用户1****</td>
                <td>13455254455</td>
                <td>2017-02-26 15:31:45</td>
                <td>
                    <button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
                    <button type="button" style="" class="btn btn-danger" onclick="edit();" data-toggle="modal" data-target="#pwdUpd" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>&nbsp;
                    <button type="button" style="" class="btn btn-success" onclick="edit();" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-th" aria-hidden="true"></span>&nbsp;密码</button>&nbsp;
                </td>
            </tr>
            <tr class="active">
                <td>2</td>
                <td>用户组2</td>
                <td>用户2</td>
                <td>用户2****</td>
                <td>13455254455</td>
                <td>2017-02-26 15:31:45</td>
                <td>
                    <button type="button" style="" class="btn btn-primary" onclick="edit();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
                    <button type="button" style="" class="btn btn-danger" onclick="edit();" data-toggle="modal" data-target="#pwdUpd" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>&nbsp;
                    <button type="button" style="" class="btn btn-success" onclick="edit();" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-th" aria-hidden="true"></span>&nbsp;密码</button>&nbsp;
                </td>
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
                        <td style="width: 65%;" id="uId"></td>
                    </tr>
                    <tr class="active">
                        <td>用户组：</td>
                        <td id="uusers"></td>
                    </tr>
                    <tr class="info">
                        <td>用户全名：</td>
                        <td id="unikeName"></td>
                    </tr>
                    <tr class="active">
                        <td>用户描述:</td>
                        <td id="uUserRemark"></td>
                    </tr>
                    <tr class="info">
                        <td>居住地址:</td>
                        <td id="uAddr"></td>
                    </tr>
                    <tr class="active">
                        <td>用户单位编号:</td>
                        <td id="uComId"></td>
                    </tr>
                    <tr class="info">
                        <td>用户电话1:</td>
                        <td id="uPhone1"></td>
                    </tr>
                    <tr class="active">
                        <td>用户电话2:</td>
                        <td id="uPhone2"></td>
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
                        <td>用户ID：</td>
                        <td>
                            <input type="password" class="form-control input-sm" id="buserId" title="长度在6~22位之间" placeholder="用户Id">
                        </td>
                    </tr>
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
                <span id="upmsg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updPwd();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改密码 DIV  ------end -->

<!-- 重置密码提示窗 -->
<div class="modal fade" id="pwdUpd">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">删除用户</h4>
            </div>
            <div class="modal-body">
                <h5>您确定要删除<span id="uPwdName"></span>用户吗？</h5>
                <span id="pMsg" style="color: red;"></span>
                <input type="hidden" id="uPwdId"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="doUpdPwd();">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 重置密码 -----end-->
</body>
</html>