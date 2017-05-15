<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/realTimeData.js?ran=<%=Math.random()%>"></script>
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

           /* $('#copyBtn').click(function(){

            });*/
        });

        function copy(){
            if ( window.clipboardData ) {
                $('.copy_btn').click(function() {
                    window.clipboardData.setData("Text", 'http://139.129.239.172:8080/comSys/dtuShare/goDataPage?nodeId=${dtu_sn}');
                    alert('复制成功！');
                });
            }else{
                $("#url_Dta").html("http://139.129.239.172:8080/comSys/dtuShare/goDataPage?nodeId=${dtu_sn}");
                $("#synV").modal("show");
            }
        }

        function refresh(){
            location.reload();
        }

        function autoRefresh(){
            var date = $("#refreshId").val();
            auto(date);
        }

        function auto(date){
            window.location.href = "${basePath }dtuHome/goDataPage?nodeId=${dtu_sn}&type=1&timeR="+date;
        }
    </script>
</head>
<body style="font-family: '微软雅黑';">

<%--一键同步弹窗--%>
<div class="modal fade" id="synV">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">复制链接</h4>
            </div>
            <div class="modal-body">
                对不起！由于浏览器兼容问题，请您手动选择链接进行复制：<br/><span id="url_Dta" style="color: #0000FF"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<input id="basePath" value="${basePath }" type="hidden">
<input type="hidden" value="${dtu_sn}" id="nodeId" />
<input id="timeR" type="hidden" value="${timeR}">
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
            <li id="copyBtn"><button type="button" class="btn btn-primary" onclick="copy();" ><span class="glyphicon glyphicon-link" aria-hidden="true"></span>&nbsp;分享链接</button>&nbsp;&nbsp;&nbsp;</li>
        </ul>
        <%--<button type="button" style="" class="btn btn-primary" onclick="refresh();"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新</button>&nbsp;--%>
    </div>
    <span style="color:red;padding-left: 38%;font-size: 18px;">观测时间：${rtData.dt}</span>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
            <thead class="text-center">
            <tr class="" style="background-color: #3278f7;color: white;">
                <td>观测要素</td>
                <td>数值</td>
                <td>状态</td>
            <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
                <td>操作</td>
            </c:if>
            </tr>
            </thead>
            <tbody class="text-center">
        <c:forEach var="sensorNode" items="${rtData.result}" varStatus="status">
            <c:if test="${sensorNode[4] == '0'}">
                <tr class="active" >
                        <td>${sensorNode[0]}</td>
                        <td>${sensorNode[1]}</td>
                        <td>${sensorNode[2]}</td>
            <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
                        <td><button type="button" style="" class="btn btn-primary" data-toggle="modal" onclick="upd('${sensorNode[3]}');" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;</td>
            </c:if>
                </tr>
            </c:if>
            <c:if test="${sensorNode[4] == '1'}">
                <tr class="success" >
                    <td>${sensorNode[0]}</td>
                    <td>${sensorNode[1]}</td>
                    <td>${sensorNode[2]}</td>
            <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
                    <td><button type="button" style="" class="btn btn-primary" data-toggle="modal" onclick="upd('${sensorNode[3]}');" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;</td>
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
                        <td style="width: 35%;">名称：</td>
                        <td style="width: 65%;" >
                            <input type="text" class="form-control" placeholder="请输入分组名称" id="uname" readonly="readonly">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>说明：</td>
                        <td>
                            <input type="text" class="form-control" placeholder="请输入分组名称" id="udescrib" readonly="readonly">
                        </td>
                    </tr>
                    <tr class="info">
                        <td style="width: 35%;">数据序号：</td>
                        <td style="width: 65%;" >
                            <input type="text" class="form-control" placeholder="请输入数据序号" id="udata_no" readonly="readonly">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>报警上线：</td>
                        <td>
                            <input type="number" class="form-control" placeholder="请输入报警上线" id="uup">
                        </td>
                    </tr>
                    <tr class="info">
                    <td style="width: 35%;">报警下线：</td>
                    <td style="width: 65%;" >
                        <input type="number" class="form-control" placeholder="请输入报警下线" id="ulow">
                    </td>
                </tr>
                    <tr class="active">
                        <td>报警持续时间（S）：</td>
                        <td>
                            <input type="number" class="form-control" placeholder="请输入报警持续时间（单位：S）" size="10" id="ulasting">
                        </td>
                    </tr>

                    <tr class="info">
                        <td style="width: 35%;">报警间隔时间（S）：</td>
                        <td style="width: 65%;" >
                            <input type="number" class="form-control" placeholder="请输入报警间隔时间（单位：S）" size="10" id="uinterval">
                        </td>
                    </tr>
                    <tr class="active">
                        <td>是否报警：</td>
                        <td>
                            <select class="form-control" id="uenable">
                                <option value="0" selected = "selected">否</option>
                                <option value="1">是</option>
                            </select>
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
