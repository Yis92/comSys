$(function(){

});
//点击数据状态

function dtuState(dtuNo) {
    $.ajax({
        url: $("#basePath").val() + "myHome/goDTUState",
        type: "POST",
        data: {
            dtuId: dtuNo
        },
        success: function (data) {
            var result = eval('('+data+')') ;
            //json = eval(json);
            console.log(result)
            console.log(result.code)
            console.log(result.date)
            console.log(result.list)
            if (result.code == "0") {
                  var htmlTab='';
                for (var i = 0; i < result.list.length; i++) {
                    var dutStateInfo =  result.list[i];
                    htmlTab+='<tr class="info">';
                    for (var j = 0; j < dutStateInfo.length; j++) {
                        htmlTab+='<td>'+dutStateInfo[j]+'</td>  ';
                    }
                    htmlTab+='</tr>';
                }
                console.log(htmlTab)
                $(".stateTable").append(htmlTab);
                //window.location.href = $("#basePath").val()+"myHome/goComUser?id="+dtuNo;
            } else {
                //$("#add_msg").html(result);
            }
        }
    });
}