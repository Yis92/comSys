

function upd(i) {
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url:$("#basePath").val()+"dtuData/getControlNodeInfo",
        type:"POST",
        data:{
            "nodeId":dtu_sn
        },
        success:function(data) {
            var result = eval('('+data+')') ;
            $("#uname").val(result.result[i].name);
            console.log("cfg:"+result.result[i].cfg);
            $("#ucfg").val(result.result[i].cfg+".0");
            $("#uaddr").val(result.result[i].addr);
            $("#udescrib").val(result.result[i].describ);
            $("#ux").val(result.result[i].x);
            $("#uy").val(result.result[i].y);
            $("#utsknum").val(result.result[i].tsknum);
            $.each(result.result[i].tskdescrib,function (index, obj) {
                $("#tsk"+(index+1)).val(obj.tsk_describ);
            });
        }
    });
}

/*保存修改*/
function updDTUInfo() {
    $("#upd_msg").empty();

    var dtu_sn = $("#dtu_sn").val();
    var uname = $("#uname").val();
    var ucfg = $("#ucfg").val();
    var uaddr = $("#uaddr").val();
    var udescrib = $("#udescrib").val();
    var ux = $("#ux").val();
    var uy = $("#uy").val();
    var utsknum = $("#utsknum").val();

    var tsk1 = $("tsk1").val();
    var tsk2 = $("tsk2").val();
    var tsk3 = $("tsk3").val();
    var tsk4 = $("tsk4").val();
    var tsk5 = $("tsk5").val();
    var tsk6 = $("tsk6").val();
    var tsk7 = $("tsk7").val();
    var tsk8 = $("tsk8").val();

    $.ajax({
        url:$("#basePath").val()+"dtuOperate/udpDtuControlNodeInfo.adv",
        type:"POST",
        data:{
            dtu_sn:dtu_sn,
            uname:uname,
            ucfg:ucfg,
            uaddr:uaddr,
            udescrib:udescrib,
            ux:ux,
            uy:uy,
            utsknum:utsknum,
            tsk1:tsk1,
            tsk2:tsk2,
            tsk3:tsk3,
            tsk4:tsk4,
            tsk5:tsk5,
            tsk6:tsk6,
            tsk7:tsk7,
            tsk8:tsk8
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=3";
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });

}

