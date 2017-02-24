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
        url:"../home/checkCode.do",
        data : {
            code : code
        },
        success:function(data){
            var result = eval('(' + data + ')');
            if(result == 'SUC'){
                    $("#lgForm").attr("action","../home/doLogin");
                   //$("#lgForm").submit();
                $("#lgForm").ajaxSubmit(function (data) {
                    alert(data);
                });

               /* $.ajax({
                    url:"http://139.129.239.172:7710/php/check_usr2.php",
                    type:"POST",
                    data:{
                        "user_id":userName,
                        "pwd":password
                    },
                    dataType:'String',
                    success:function(data){
                        alert(data);
                    }
                });*/

               // $("#isOk").show();
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
        url:"../home/checkCode.do",
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