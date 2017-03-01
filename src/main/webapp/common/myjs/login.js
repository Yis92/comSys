function login(){
    var userName = $('#userName').val();
    var password = $('#password').val();
    var code = $('#code').val();
    $("#errMsg").empty();
    $("#errMsg").attr("class","msg");
    if(userName.length == 0 || userName == ''){
        $("#errMsg").html("请输入用户名");
        return false;
    }
    if(password.length == 0 || password == '') {
        $("#errMsg").html("请输入密码");
        return false;
    }
    if(code.length == 0 || code == '') {
        $("#errMsg").html("请输入验证码");
        return false;
    }
    $("#errMsg").empty();
    var code = $('#code').val();
    $.ajax({
        type : "POST",
        url:$("#basePath").val()+"home/checkCode",
        data : {
            code : code
        },
        success:function(data){
            var result = eval('(' + data + ')');
            if(result == 'SUC'){
                $("#lgForm").attr("action",$("#basePath").val()+"home/doLogin");
                   //$("#lgForm").submit();
                $("#lgForm").ajaxSubmit(function (data) {
                    var result = eval('(' + data + ')');
                    if(result == "SUC"){
                        window.location.href=$("#basePath").val()+"myHome/goMyHome";
                    }else{
                        $("#errMsg").html(result);
                        return false;
                    }
                });
                return false;
            }else{
                $("#errMsg").html("验证码输入有误！请重新输入.");
                return false;
            }
        }
    });
}

function checkCode(){
    var code = $('#code').val();
    $("#isOk").hide();
    $("#errMsg").empty();
    $("#errMsg").attr("class","msg");
    if(code.length == 0 || code == '') {
        $("#errMsg").html("请输入验证码");
        return false;
    }
    $.ajax({
        type : "POST",
        url:$("#basePath").val()+"home/checkCode",
        data : {
            code : code
        },
        success:function(data){
            var result = eval('(' + data + ')');
            if(result == 'SUC'){
                $("#isOk").show();
                return false;
            }else{
                $("#errMsg").html("验证码输入有误！请重新输入.");
                return false;
            }
        }
    });

}