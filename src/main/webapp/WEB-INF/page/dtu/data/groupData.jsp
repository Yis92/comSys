<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/groupingPage.js?ran=<%=Math.random()%>"></script>
    <script type="text/javascript" src="${basePath }common/echarts/echarts.js"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input id="til" type="hidden" value="${groupInfo.result.group[0].name}">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input id="firstId" type="hidden" value="${groupInfo.result.group[0].group_id}">

<div class="container con_title" style="margin-top: 50px;" >
<c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
    <div style="margin-right: 60px;margin-top: 10px;margin-bottom: 10px;"><button type="button" style="" class="btn btn-primary" onclick="upd();" data-toggle="modal" data-target="#myModal_add" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新增</button>&nbsp;</div>
</c:if>
    <ul class="nav nav-tabs nav-justified">
        <c:forEach items="${groupInfo.result.group}" var="group" varStatus="status">
            <c:if test="${status.index == 0}">
                <li role="presentation" class="active" onclick="showD('${group.group_id}','${group.name}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
            <c:if test="${status.index != 0}">
            <li role="presentation" class="" onclick="showD('${group.group_id}','${group.name}',${status.index+1});" id="btn_${status.index+1}"><a href="javascript:void(0);">${group.name}</a></li>
            </c:if>
        </c:forEach>
    </ul>
</div>
    <div class="panel-body" id="show_div">
<c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
        <div style="margin-left: 60px;margin-top: 10px;margin-bottom: 10px; ">
            <button type="button" style="" class="btn btn-primary" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
            <button type="button" style="" class="btn btn-danger" data-toggle="modal" data-target="#myModal_del" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>&nbsp;
        </div>
</c:if>

        <div style="width: 100%;    float: right;   padding-right: 40%;    padding-bottom: 20px;   padding-top: 10px;"><span id="dt" style="color:red;float: right;">观测时间:${groupInfo.dt}</span></div>
        <div id="main" style="width: 100%;height:380px;"></div>
        <div id="main1" style="width: 100%;height:380px; display: none;"></div>
        <div id="main2" style="width: 100%;height:380px; display: none;"></div>
        <div id="main3" style="width: 100%;height:380px; display: none;"></div>
    </div>

<!--新增信息 DIV-->
<div class="modal fade" id="myModal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel1">新增</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="info">
                        <td style="width: 35%;">分组名称：</td>
                        <td style="width: 65%;" >
                            <input type="text" class="form-control" placeholder="请输入分组名称" id="aname1">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据1：</td>
                        <td>
                            <select class="form-control" id="asj1">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据2：</td>
                        <td>
                            <select class="form-control" id="asj2">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据3：</td>
                        <td>
                            <select class="form-control" id="asj3">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据4：</td>
                        <td>
                            <select class="form-control" id="asj4">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据5：</td>
                        <td>
                            <select class="form-control" id="asj5">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据6：</td>
                        <td>
                            <select class="form-control" id="asj6">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据7：</td>
                        <td>
                            <select class="form-control" id="asj7">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据8：</td>
                        <td>
                            <select class="form-control" id="asj8">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据9：</td>
                        <td>
                            <select class="form-control" id="asj9">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据10：</td>
                        <td>
                            <select class="form-control" id="asj10">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <span id="add_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doAdd();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--新增信息 DIV-->

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
                        <td style="width: 35%;">分组名称：</td>
                        <td style="width: 65%;" >
                            <input type="text" class="form-control" placeholder="请输入分组名称" id="uname1">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据1：</td>
                        <td>
                            <select class="form-control" id="sj1">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据2：</td>
                        <td>
                            <select class="form-control" id="sj2">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据3：</td>
                        <td>
                            <select class="form-control" id="sj3">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据4：</td>
                        <td>
                            <select class="form-control" id="sj4">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据5：</td>
                        <td>
                            <select class="form-control" id="sj5">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据6：</td>
                        <td>
                            <select class="form-control" id="sj6">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据7：</td>
                        <td>
                            <select class="form-control" id="sj7">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据8：</td>
                        <td>
                            <select class="form-control" id="sj8">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>数据9：</td>
                        <td>
                            <select class="form-control" id="sj9">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>数据10：</td>
                        <td>
                            <select class="form-control" id="sj10">
                                <option value="0" selected = 'selected'>无</option>
                                <c:forEach var="data" items="${groupDataList}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="hidden" value="${groupInfo.result.group[0].group_id}" id="upd_id" />
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

<!--修改信息 DIV-->
<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel3">删除分组</h4>
            </div>
            <div class="modal-body" align="center">
                <input type="hidden" value="${groupInfo.result.group[0].group_id}" id="del_id" />
                <span id="del_show">你确定要删除【${groupInfo.result.group[0].name}】分组吗？</span>
                <span id="del_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doDel();">确定</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->
</body>
</html>
