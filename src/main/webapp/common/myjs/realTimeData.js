

function upd(dataNo) {
    var nodeId = $("#nodeId").val();
    $.ajax({
        url:$("#basePath").val() + "dtuData/getSensorWarningInfo",
        type:"POST",
        data:{
            dataNo:dataNo,
            nodeId:nodeId
        },
        success:function (data) {
            var result = eval("("+data+")");
            console.log(result);
            $("#uname").val(result.name);
            $("#udescrib").val(result.describ);
            $("#udata_no").val(result.data_no);
            $("#uup").val(result.up);
            $("#ulow").val(result.low);
            $("#ulasting").val(result.lasting);
            $("#uinterval").val(result.interval);
            $("#uenable").val(result.enable);
            return false;
        }
    });
}

/*保存修改*/
function doUpd() {
    $("#upd_msg").empty();
    var nodeId = $("#nodeId").val();
    var uname = $("#uname").val();
    var udescrib = $("#udescrib").val();
    var udata_no = $("#udata_no").val();
    var uup = $("#uup").val();
    var ulow = $("#ulow").val();
    var ulasting = $("#ulasting").val();
    var uinterval = $("#uinterval").val();
    var uenable = $("#uenable").val();

    if(uenable == '1'){
        if(uup =='' || uup.length == 0){
            $("#upd_msg").html("请输入报警上线");
            return false;
        }
        if(ulow =='' || ulow.length == 0){
            $("#upd_msg").html("请输入报警下线");
            return false;
        }
        if(ulasting =='' || ulasting.length == 0){
            $("#upd_msg").html("请输入报警持续时间");
            return false;
        }
        if(uinterval =='' || uinterval.length == 0){
            $("#upd_msg").html("请输入报警间隔时间");
            return false;
        }
    }
    $.ajax({
        url:$("#basePath").val() + "dtuOperate/updSensorWarningInfo.adv",
        type:"POST",
        data:{
            nodeId:nodeId,
            uname:uname,
            udescrib:udescrib,
            udata_no:udata_no,
            uup:uup,
            ulow:ulow,
            ulasting:ulasting,
            uinterval:uinterval,
            uenable:uenable
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == 'SUC'){
                window.location.href = $("#basePath").val()+"dtuHome/goDataPage?nodeId="+nodeId+"&type=1";
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });
}

