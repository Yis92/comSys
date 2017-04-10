
function setStatus(id){
    $("#msgId").val(id);
}
//标记报警信息状态为已处理
function updStatus(){
    var msgId = $("#msgId").val();
    var dtu_sn = $("#dtu_sn").val();

    $.ajax({
        type:"POST",
        url:$("#basePath").val() + "dtuOperate/updWarningMsg",
        data:{
            msgid:msgId,
            dtu_sn:dtu_sn
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == 'SUC'){//修改成功跳转到显示页面
                window.location.href = $("#basePath").val()+'dtuHome/goDTUPage?type=4&nodeId='+$("#dtu_sn").val();
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });

}