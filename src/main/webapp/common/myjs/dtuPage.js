//执行修改DTUinfo
function updDTUInfo(){
    var dtu_name = $("#dtu_name").val();
    var dtu_describ = $("#dtu_describ").val();
    var dtu_address = $("#dtu_address").val();
    var dtu_long = $("#dtu_long").val();
    var dtu_lat  = $("#dtu_lat").val();
    var dtu_comm_type = $("#dtu_comm_type").val();
    var dtu_upfreq = $("#dtu_upfreq").val();
    var dtu_warning_type = $("#dtu_warning_type").val();
    var dtu_sim_no = $("#dtu_sim_no").val();
    var dtu_type = $("#dtu_type").val();
    var dtu_sn =$("#dtu_sn").val();

    if(dtu_name == '' || dtu_name.length == 0){
        $("#upd_msg").html("请输入DTU名称");
        return false;
    }
    if(dtu_describ == '' || dtu_describ.length == 0){
        $("#upd_msg").html("请输入DTU描述");
        return false;
    }
    if(dtu_address == '' || dtu_address.length == 0){
        $("#upd_msg").html("请输入DTU安装地址");
        return false;
    }
    if(dtu_long == '' || dtu_long.length == 0){
        $("#upd_msg").html("请输入DTU安装经度");
        return false;
    }
    if(dtu_lat == '' || dtu_lat.length == 0){
        $("#upd_msg").html("请输入DTU安装纬度");
        return false;
    }
  /*  if(dtu_upfreq == '' || dtu_upfreq.length == 0){
        $("#upd_msg").html("请输入DTU上传频率");
        return false;
    }*/
    if(dtu_sim_no == '' || dtu_sim_no.length == 0){
        $("#upd_msg").html("请输入sim卡卡号");
        return false;
    }
    $("#upd_msg").empty();
    $.ajax({
        url:$("#basePath").val() + "dtuOperate/updDtuInfo.adv",
        type:"POST",
        data:{
             dtu_sn : dtu_sn,
             dtu_name : dtu_name,
             dtu_describ : dtu_describ,
             dtu_address : dtu_address,
             dtu_long : dtu_long,
             dtu_lat  : dtu_lat,
             dtu_comm_type : dtu_comm_type,
             dtu_upfreq : dtu_upfreq,
             dtu_warning_type : dtu_warning_type,
             dtu_sim_no : dtu_sim_no,
             dtu_type : dtu_type
        },
        success:function (data) {
            var result = eval("("+data+")");

            if(result == 'SUC'){//修改成功跳转到显示页面
                console.log(result == 'SUC');
                window.location.href = $("#basePath").val()+'myHome/goDTUPage?nodeId='+$("#dtu_sn").val();
                return false ;
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });

}
