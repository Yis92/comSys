<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>APP上传更新</title>
    <script type="text/javascript" src="${basePath }common/upload/ajaxupload.3.6.js"></script>
    <script type="application/javascript">
        $(function(){
            var btnUpload=$('#upload');
            new AjaxUpload(btnUpload, {
                action: '${basePath }app/fileUpload',
                name: 'uploadfile',
                onSubmit: function(file, ext){
                    if (! (ext && /^(apk)$/.test(ext))){
                        alert("请上传apk文件");
                        return false;
                    }
                },
                onComplete: function(file, response){
                    $('#appFile').val(file);
                    /*if(response!=""){
                        $('#appFile').val(response);
                    } else{

                    }*/
                }
            });
            $("#submit").click(function(){
                $.ajax({
                    type:"post",
                    url:"${basePath}app/updateAppVersion",
                    data:$("#inputForm").serialize(),
                    dataType:"json",
                    success:function(data){
                        if(data.code == "0"){
                            alert("更新成功")
                        } else {
                            alert("更新失败");
                        }
                    }
                });
            });
        });

    </script>
</head>
<body style="font-family: '微软雅黑';">
    <form class="form-horizontal" method="post" id="inputForm">
        <table class="table table-striped table-bordered table-hover" style="text-align: center;">
            <tr>
                <td style="width: 35%;">版本号</td>
                <td style="width: 65%;"><input type="text" name="versionCode" class="form-control" id="versionCode" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td style="width: 35%;">上传apk</td>
                <td style="width: 65%;"><input type="text" name="apkFile" id="appFile" class="form-control"><div id="upload"><button  class="btn btn-primary"> 上传</button></div></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button  class="btn btn-primary" id="submit">提交</button>
                </td>
            </tr>
        </table>
    </form>


</body>
</html>
