function updInfo(){
    var unitNo = $("#unitNo").val();
    var unitName = $("#unitName").val();
    var long = $("#long").val();
    var lat = $("#lat").val();
    var adress = $("#adress").val();
    var tel1 = $("#tel1").val();
    var tel2 = $("#tel2").val();
    var tel3 = $("#tel3").val();
    var tel4 = $("#tel4").val();
    var tel5 = $("#tel5").val();
    var tel6 = $("#tel6").val();

    if(unitName == '' || unitName.length == 0){
        $("#upd_msg").html("请输入单位名称");
        return false;
    }
    if(long == '' || long.length == 0){
        $("#upd_msg").html("请输入公司地理经度");
        return false;
    }
    if(lat == '' || lat.length == 0){
        $("#upd_msg").html("请输入公司地理纬度");
        return false;
    }
    if(adress == ''|| adress.length == 0){
        $("#upd_msg").html("请输入公司地理位置");
        return false;
    }
    if(tel1 == ''||tel1.length == 0){
        $("#upd_msg").html("请输入公司电话1");
        return false;
    }
    if(tel2 == '' || tel2.length ==0){
        $("#upd_msg").html("请输入公司电话2");
        return false;
    }
    if(tel3 == ''||tel3.length == 0){
        $("#upd_msg").html("请输入公司电话3");
        return false;
    }
    if(tel4 == ''||tel4.length == 0){
        $("#upd_msg").html("请输入公司电话4")
        return false;
    }
    if(tel5 == '' || tel5.length == 0){
        $("#upd_msg").html("请输入公司电话5");
        return false;
    }
    if(tel6 == '' || tel6.length == 0){
        $("#upd_msg").html("请输入公司电话6");
        return false;
    }
    $("#upd_msg").empty();

    $.ajax({
        url: $("#basePath").val()+'myHome/doUpdComInfo.admin',
        type : "POST",
        data : {
            unitNo:unitNo,
            unitName:unitName,
            unitLong:long,
            unitLat:lat,
            adress:adress,
            tel1:tel1,
            tel2:tel2,
            tel3:tel3,
            tel4:tel4,
            tel5:tel5,
            tel6:tel6
        },
        success : function (data) {
            var result = eval("("+data+")");
            if(result == 'SUC'){
                window.location.href == $("#basePath").val()+'myHome/goComInfo?id='+unitNo;
                return false ;
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });


}