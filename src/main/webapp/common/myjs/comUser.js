
$(function(){
    $(".cls_true").addClass("info");
    $(".cls_false").addClass("active");
});

/**添加用户*/
function add() {
    $("#user_id").val("");
    $("#user_password").val("");
    $("#levelA").val(12);
    $("#add_fullName").val("");
    $("#add_desc").val("");
    $("#add_desc").html("");
}

/**执行添加用户*/
function doAdd(){
    var user_id = $("#user_id").val();
    var password = $("#user_password").val();
    var level = $("#levelA").val();
    var fullName = $("#add_fullName").val();
    var desc = $("#add_desc").val();
    var unitNo = $("#unitNo").val();
    if(user_id == '' || user_id.length == 0){
        $("#add_msg").html("请输入用户名");
        return false;
    }
    if(password == ''||password.length ==0){
        $("#add_msg").html("请输入用户密码");
        return false;
    }
    if(fullName==''||fullName.length == 0){
        $("#add_msg").html("请输入用户全名");
        return false;
    }
    if(desc == '' || desc.length ==0){
        $("#desc").html("请输入用户说明");
        return false;
    }
    $.ajax({
        url:$("#basePath").val()+"myHome/doAdd",
        type:"POST",
        data:{
            user_id:user_id,
            password:password,
            level:level,
            fullName:fullName,
            desc:desc,
            unitNo:unitNo
        },
        success:function (data) {
            var result = eval('('+data+')') ;
            if(result == 'SUC'){
                window.location.href = $("#basePath").val()+"myHome/goComUser?id="+unitNo;
                return false;
            }else{
                $("#desc").html(result);
                return false;
            }
            }
        });
}

/**修改用户*/
function edit(id,level,fullName,desc,tel1,tel2) {
    $("#uId").val(id);
    //$("#u_uId").val(id);
    $("#levelS").val(level);
    $("#fullName").val(fullName);
    $("#desc").html(desc);
    $("#phone1").val(tel1);
    $("#phone2").val(tel2);
}

/**执行修改操作*/
function doUpd(){
    var id = $("#uId").val();
    var level = $("#levelS").val();
    var fullName = $("#fullName").val();
    var desc = $("#desc").val();
    var phone1 = $("#phone1").val();
    var phone2 = $("#phone2").val();
    var unitNo = $("#unitNo").val();

    if(fullName == '' ||fullName.length ==0){
        $("#upd_msg").html("请输入用户全名");
        return false;
    }
    if(desc == '' || desc.length ==0){
        $("#upd_msg").html("请输入用户描述");
        return false;
    }
    if(phone1 == '' || phone1.length == 0){
        $("#upd_msg").html("请输入电话1");
        return false;
    }
    if(phone2 == '' || phone2.length == 0){
        $("#upd_msg").html("请输入电话2");
        return false;
    }
    $.ajax({
        url:$("#basePath").val()+"myHome/doUpd",
        type:"post",
        data:{
            id:id,
            level:level,
            fullName:fullName,
            desc:desc,
            phone1:phone1,
            phone2:phone2,
            unitNo:unitNo
        },
        success:function(data){
            var result = eval('('+data+')');
            if(result == 'SUC'){
                window.location.href=$("#basePath").val()+"myHome/goComUser?id="+unitNo;
                    return false;
                }else{
                    $("#upd_msg").html(result);
                    return false;
                }
            }
        });
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
    $("#buserId").val(id);
    $("#upass").val("");
    $("#apass").val("");
}

function  doPwd() {
    var id = $("#buserId").val();
    var upass = $("#upass").val();
    var apass = $("#apass").val();

    if(upass == '' || upass.length ==0){
        $("#upmsg").html("请输入修改密码");
        return false;
    }

    if(apass == '' || apass.length == 0){
        $("#upmsg").html("请输入确认密码");
        return false;
    }

    if(apass != upass){
        $("#upmsg").html("两次输入的密码不一致");
        return false;
    }
    $("#upmsg").html("");
    $.ajax({
        url:$("#basePath").val()+"myHome/doUpwd",
        type:"POST",
        data:{
            user_id:id,
            upass:upass
        },
        success:function (data) {
            var  result = eval("("+data+")");
            if(result == 'SUC'){
                $("#myModal").modal("hide");
                $("#pdwV").modal('show')
                return false;
            }else{
                $("#upmsg").html(result);
                return false;
            }
        }
    });

}

