/*一键同步*/
function syn() {
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url: $("#basePath").val() + "dtuOperate/synSensorNodeInfo.adv",
        type: "POST",
        data: {
            "nodeId": dtu_sn
        },
        success: function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                //window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=2";
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

/*新增*/
function add(){
    $("#acfg").val("");
    $("#adescrib").val("");
    $("#ax").val("");
    $("#ay").val("");
    $("#add_msg").empty();
}

/*保存修改*/
function addInfo() {
    $("#add_msg").empty();
    var dtu_sn = $("#dtu_sn").val();
    var size  = $("#size").val();
    var acfg = $("#acfg").val();
    var adescrib = $("#adescrib").val();
    var ax = $("#ax").val();
    var ay = $("#ay").val();
    var aaddr = $("#aaddr").val();
    $.ajax({
        url: $("#basePath").val() + "dtuOperate/addDtuSensorNodeInfo.adv",
        type: "POST",
        data: {
            dtu_sn: dtu_sn,
            ucfg: acfg,
            udescrib: adescrib,
            ux: ax,
            uy: ay,
            size: size,
            aaddr: aaddr
        },
        success: function (data) {
            var result = eval("(" + data + ")");
            if (result == "SUC") {
                window.location.href = $("#basePath").val() + "dtuHome/goDTUPage?nodeId=" + dtu_sn + "&type=2";
            } else {
                $("#add_msg").html(result);
                return false;
            }
        }
    });
}

/*修改*/
function upd(i) {
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url:$("#basePath").val()+"dtuData/getSensorNodeInfo",
        type:"POST",
        data:{
            "nodeId":dtu_sn
        },
        success:function(data) {
            var result = eval('('+data+')') ;
            console.log(result);
            $("#uname").val(result.result[i].name);
            console.log("cfg:"+result.result[i].cfg);
            $("#ucfg").val(result.result[i].cfg+".0");
            $("#uaddr").val(result.result[i].addr);
            $("#udescrib").val(result.result[i].describ);
            $("#ux").val(result.result[i].x);
            $("#uy").val(result.result[i].y);
            $("#node_no").val(result.result[i].node_no);
        }
    });
}

/*保存修改*/
function updDTUInfo() {
    $("#upd_msg").empty();

    var dtu_sn = $("#dtu_sn").val();
    var ucfg = $("#ucfg").val();
    var uaddr = $("#uaddr").val();
    var udescrib = $("#udescrib").val();
    var ux = $("#ux").val();
    var uy = $("#uy").val();
    var node_no = $("#node_no").val();
    var size = $("#size").val();
    $.ajax({
        url:$("#basePath").val()+"dtuOperate/updDtuSensorNodeInfo.adv",
        type:"POST",
        data:{
            dtu_sn:dtu_sn,
            ucfg:ucfg,
            uaddr:uaddr,
            udescrib:udescrib,
            ux:ux,
            uy:uy,
            node_no:node_no,
            size:size
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goDTUPage?nodeId="+dtu_sn+"&type=2";
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });

}

/*删除传感器节点*/
function del(addr) {
    var dtu_sn = $("#dtu_sn").val();
    $.ajax({
        url: $("#basePath").val() + "dtuOperate/delSensorNodeInfo.adv",
        type: "POST",
        data: {
            "nodeId": dtu_sn,
            "nodeAddr":addr
        },
        success: function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val() + "dtuHome/goDTUPage?nodeId=" + dtu_sn + "&type=2";
               /* $("#pMsg").empty();
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
