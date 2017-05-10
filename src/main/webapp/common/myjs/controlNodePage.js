/*点击添加*/
function add() {
    $("#acfg").val("");
    $("#adescrib").val("");
    $("#ax").val("");
    $("#ay").val("");
    $("#atsk1").val("");
    $("#atsk2").val("");
    $("#atsk3").val("");
    $("#atsk4").val("");
    $("#atsk5").val("");
    $("#atsk6").val("");
    $("#atsk7").val("");
    $("#atsk8").val("");
    $("#add_msg").empty();
}
/*保存添加*/
function addInfo() {
    $("#add_msg").empty();
    var dtu_sn = $("#dtu_sn").val();
    var size  = $("#size").val();
    var acfg = $("#acfg").val();
    var adescrib = $("#adescrib").val();
    var ax = $("#ax").val();
    var ay = $("#ay").val();
    var aaddr = $("#aaddr").val();
    var atsk1 = $("#atsk1").val();
    var atsk2 = $("#atsk2").val();
    var atsk3 = $("#atsk3").val();
    var atsk4 = $("#atsk4").val();
    var atsk5 = $("#atsk5").val();
    var atsk6 = $("#atsk6").val();
    var atsk7 = $("#atsk7").val();
    var atsk8 = $("#atsk8").val();

    $.ajax({
        url:$("#basePath").val()+"dtuOperate/addDtuControlNodeInfo.adv",
        type:"POST",
        data:{
            dtu_sn:dtu_sn,
            ucfg:acfg,
            udescrib:adescrib,
            ux:ax,
            uy:ay,
            size:size,
            aaddr:aaddr,
            tsk1:atsk1,
            tsk2:atsk2,
            tsk3:atsk3,
            tsk4:atsk4,
            tsk5:atsk5,
            tsk6:atsk6,
            tsk7:atsk7,
            tsk8:atsk8
        },
        success:function (data) {
        var result = eval("("+data+")");
        if(result == "SUC"){
            window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=3";
        }else{
            $("#add_msg").html(result);
            return false;
        }
    }

    });


}

/*修改某个节点*/
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
            $("#node_no").val(result.result[i].node_no);
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
    var node_no = $("#node_no").val();
    var size = $("#size").val();

    var tsk1 = $("#tsk1").val();
    var tsk2 = $("#tsk2").val();
    var tsk3 = $("#tsk3").val();
    var tsk4 = $("#tsk4").val();
    var tsk5 = $("#tsk5").val();
    var tsk6 = $("#tsk6").val();
    var tsk7 = $("#tsk7").val();
    var tsk8 = $("#tsk8").val();

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
            node_no:node_no,
            size:size,
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


/*一键同步*/
function syn(){
    //console.log("一键同步");
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url: $("#basePath").val() + "dtuOperate/synControlNodeInfo.adv",
        type: "POST",
        data: {
            "nodeId": dtu_sn
        },
        success: function (data) {
            var result = eval("("+data+")");
           /* if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=3";
            }else{
                alert(result);
                return false;
            }*/
            if(result == "SUC"){
                $("#pMsg").empty();
                $("#pMsg").html("同步成功");
                $("#synV").modal("show");
                return false;
            }else{
                //alert(result);
                $("#pMsg").empty();
                $("#pMsg").html(result);
                $("#synV").modal("show");
                return false;
            }
        }
    });
}

function del(addr) {
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url: $("#basePath").val() + "dtuOperate/delCtrlNodeInfo.adv",
        type: "POST",
        data: {
            "nodeId": dtu_sn,
            "nodeAddr":addr
        },
        success: function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=3";
                /*$("#pMsg").empty();
                $("#pMsg").html("删除成功");
                $("#synV").modal("show");*/
                return false;
            }else{
                //alert(result);
                $("#pMsg").empty();
                $("#pMsg").html(result);
                $("#synV").modal("show");
                return false;
            }
        }
    });
}
