

/*修改显示数据*/
function upd(tsk_channel,tsk_describ,tsk_type,tsk_dt,tsk_tm,tsk_second) {
    $("#uchannel").val(tsk_channel);
    $("#udesc").val(tsk_describ);
    $("#utype").val(tsk_type);
    $("#udt").val(tsk_dt);
    $("#utm").val(tsk_tm);
    $("#uecond").val(tsk_second);
}

/*执行修改*/
function doUpd() {
    $("#upd_msg").empty();
    var uchannel = $("#uchannel").val();
    /*var udesc = $("#udesc").val();*/
    var utype = $("#utype").val();
    var udt = $("#udt").val();
    var utm = $("#utm").val();
    var uecond = $("#uecond").val();

    var nodeId = $("#nodeId").val();
    var nodeAddr = $("#nodeAddr").val();

    $.ajax({
        type:"POST",
        url:$("#basePath").val()+"dtuOperate/updDtuTaskInfo.adv",
        data:{
            uchannel:uchannel,
            utype:utype,
            udt:udt,
            utm:utm,
            uecond:uecond,
            nodeId:nodeId,
            nodeAddr:nodeAddr
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goTaskPage?nodeId="+nodeId+"&nodeAddr="+nodeAddr;
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });


}