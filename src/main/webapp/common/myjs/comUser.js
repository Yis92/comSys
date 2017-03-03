
$(function(){
    $(".cls_true").addClass("info");
    $(".cls_false").addClass("active");
});

/**修改用户*/
function edit(id,level,fullName,desc,tel1,tel2) {



}

/**删除用户*/
function del(id,name) {
    $("#del_userId").val(id);
    $("#delName").html(name);
    $("#delV").modal("show");
}

/**执行删除...*/
function Dodel(){
    var userId = $("#del_userId").val();
    var unitNo = $("#unitNo").val();
    $.ajax({
        url:$("#basePath").val()+"myHome/doDel",
        type:"POST",
        data:{
            userId : userId,
            unitNo : unitNo
        },
        success:function(data){
            var result = eval('('+data+')');
            if(result == 'SUC'){
                window.location.href=$("#basePath").val()+"myHome/goComUser?id="+unitNo;
                return false;
            }else{
                $("#pMsg").html(result);
                return false;
            }
        }
    });
}


/**修改密码*/
function pwd(id){

}


