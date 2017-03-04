
/**打开修改框*/
function edit(){
    $("#edit").show();
}
/**修改信息*/
function updInfo(){
    var userId = $("#userId").val();
    var fullName = $("#fullName").val();
    var desc = $("#desc").val();
    var phone1 = $("#phone1").val();
    var phone2 = $("#phone2").val();
    if(fullName == '' ||fullName.length==0){
        $("#upd_msg").html("请输入用户全名");
        return false;
    }
    if(desc == '' || desc.length ==0){
        $("#upd_msg").html("请输入用户描述");
        return false;
    }
    if(phone1 == ''||phone1.length==0){
        $("#upd_msg").html("请输入电话1");
        return false;
    }
    if(phone2 == ''||phone2.length==0){
        $("#upd_msg").html("请输入电话2");
        return false;
    }

    $("#upd_msg").empty();
    $("#upd_msg").html("");
    $.ajax({
        url : $("#basePath").val()+"userHome/updInfo",
        type : "POST",
        data : {
            userId :userId,
            fullName : fullName,
            desc : desc,
            phone1 : phone1,
            phone2 : phone2
        },
        success : function(data){
            var result = eval('('+data+')');
            if(result == 'SUC'){
                window.location.href=$("#basePath").val()+"userHome/myInfo";
                return false;
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });
}

function updPwd(){
    var bpassword = $("#bpassword").val();
    var upass = $("#upass").val();
    var apass = $("#apass").val();

    if(bpassword.length == 0 ||bpassword == ''){
        $("#pmsg").html("请输入初始密码");
        return false;
    }

    if(upass.length == 0 ||upass == ''){
        $("#pmsg").html("请输入修改密码");
        return false;
    }

    if(apass.length == 0 ||apass == ''){
        $("#pmsg").html("请输入确认密码");
        return false;
    }

    if(upass!=apass){
        $("#pmsg").html("两次输入密码不一致");
        return false ;
    }
    $("#pmsg").empty();
    $.ajax({
        url:$("#basePath").val()+"userHome/updPwd",
        type : "POST",
        data:{
            password:bpassword,
            upass :upass
        },
        success :function (data) {
            var result = eval('('+data+')');
            if(result == 'SUC'){
                //$("#pmsg").html("两次输入密码不一致")
                $("#myModal").modal('hide');
                $("#myModal2").modal('show');
                return false ;
            }else{
                $("#pmsg").html(result);
                return false;
            }
        }
    });
}

/**打开修改密码弹窗*/
function openPwd(){
    $("#bpassword").val('');
    $("#upass").val('');
    $("#apass").val('');
    $("#pmsg").empty();
}


