$(function() {

    var firstId = $("#firstId").val();
    var til = $("#til").val();
    show(firstId,til);
 //[
            /*{
                name: '温度',
                type: 'gauge',
                z: 3,
                min: 0,
                max: 100,
                splitNumber: 10,
                radius: '40%',
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 10
                    }
                },
                axisTick: {            // 坐标轴小标记
                    length: 15,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: {           // 分隔线
                    length: 20,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                title: {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 20,
                        fontStyle: 'italic'
                    }
                },
                detail: {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder'
                    }
                },
                data: [{value: 21.1, name: '温度(°C)'}]
            },
            {
                name: '湿度',
                type: 'gauge',
                center: ['15%', '55%'],    // 默认全局居中
                radius: '40%',
                min: 0,
                max: 100,
                //endAngle:45,
                splitNumber: 4,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 8
                    }
                },
                axisTick: {            // 坐标轴小标记
                    length: 12,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: {           // 分隔线
                    length: 20,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                pointer: {
                    width: 5
                },
                title: {
                    offsetCenter: [0, '-30%'],       // x, y，单位px
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 16,
                        fontStyle: 'italic'
                    }
                },
                detail: {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder'
                    }
                },
                data: [{value: 12, name: '湿度（%）'}]
            },
            {
                name: '二氧化碳',
                type: 'gauge',
                center: ['85%', '55%'],    // 默认全局居中
                radius: '40%',
                min: 0,
                max: 1000,
                //startAngle: 180,
                //endAngle: 10,
                splitNumber: 10,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 8
                    }
                },
                axisTick: {            // 坐标轴小标记
                    splitNumber: 5,
                    length: 10,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                /!*axisLabel: {
                 formatter:function(v){
                 switch (v + '') {
                 case '0' : return 'E';
                 case '1' : return 'Gas';
                 case '2' : return 'F';
                 }
                 }
                 },*!/
                splitLine: {
                    // 分隔线
                    length: 15,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                pointer: {
                    width:2
                },
                title : {
                    show: true,
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 16,
                        fontStyle: 'italic'
                    }
                },
                detail : {
                    show: true
                },
                data:[{value: 515, name: '二氧化碳(ppm)'}]
            }*/
       // ]

   // };
    // 使用刚指定的配置项和数据显示图表。

});
/*刷新*/
function refresh() {
    var firstId = $("#firstId").val();
    var til = $("#til").val();
    show(firstId,til);
}

function show(group_id,til) {
    var nodeId = $("#nodeId").val();
    var seriesData = new Array();
    var seriesData1 = new Array();
    var seriesData2 = new Array();
    var seriesData3 = new Array();
    $("#uname1").val(til);
    $("#sj1").val("0");
    $("#sj2").val("0");
    $("#sj3").val("0");
    $("#sj4").val("0");
    $("#sj5").val("0");
    $("#sj6").val("0");
    $("#sj7").val("0");
    $("#sj8").val("0");
    $("#sj9").val("0");
    $("#sj10").val("0");


    $.ajax({
        url:$("#basePath").val() + "dtuData/groupingData",
        type:"POST",
        data:{
            nodeId:nodeId,
            groupId:group_id
        },
        success:function (data) {
            var result = eval('('+data+')') ;
            console.log(result);
            $.each(result.groupdata,function (index, obj) {
                //console.log(obj.name+"---"+obj.value);

                $("#t"+index).empty();
                $("#t"+index).html(obj.name);

                if(index%3 == 0){
                    d = {
                        name: obj.name+'('+obj.unit+')',
                        type: 'gauge',
                        center: ['15%', '55%'],    // 默认全局居中
                        radius: '70%',
                        min: obj.mini,
                        max: obj.max,
                        //endAngle:45,
                        splitNumber: 8,
                        axisLine: {            // 坐标轴线
                            lineStyle: {       // 属性lineStyle控制线条样式
                                width: 8
                            }
                        },
                        axisTick: {            // 坐标轴小标记
                            length: 12,        // 属性length控制线长
                            lineStyle: {       // 属性lineStyle控制线条样式
                                color: 'auto'
                            }
                        },
                        splitLine: {           // 分隔线
                            length: 20,         // 属性length控制线长
                            lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                                color: 'auto'
                            }
                        },
                        pointer: {
                            width: 5
                        },
                        title: {
                            offsetCenter: [0, '-30%'],       // x, y，单位px
                            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                fontWeight: 'bolder',
                                fontSize: 16,
                                fontStyle: 'italic'
                            }
                        },
                        detail: {
                            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                fontWeight: 'bolder',
                                fontSize: 16,
                            }
                        },
                        data: [{value: obj.value, name: obj.unit,id:obj.id,}]
                    };
                    if(index<3){
                        seriesData.push(d);
                    }else if(index>2 & index<6){
                        seriesData1.push(d);
                    }else if(index>5 & index<9){
                        seriesData2.push(d);
                    }else{
                        seriesData3.push(d)
                    }
                    //  console.log(seriesData);
                }else if(index%3 == 1){
                    var d =
                        {
                            name: obj.name+'('+obj.unit+')',
                            type: 'gauge',
                            z: 3,
                            min: obj.mini,
                            max: obj.max,
                            splitNumber: 8,
                            radius: '70%',
                            axisLine: {            // 坐标轴线
                                lineStyle: {       // 属性lineStyle控制线条样式
                                    width: 10
                                }
                            },
                            axisTick: {            // 坐标轴小标记
                                length: 15,        // 属性length控制线长
                                lineStyle: {       // 属性lineStyle控制线条样式
                                    color: 'auto'
                                }
                            },
                            splitLine: {           // 分隔线
                                length: 20,         // 属性length控制线长
                                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                                    color: 'auto'
                                }
                            },
                            title: {
                                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                    fontWeight: 'bolder',
                                    fontSize: 16,
                                    fontStyle: 'italic'
                                }
                            },
                            detail: {
                                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                    fontWeight: 'bolder',
                                    fontSize: 16,
                                }
                            },
                            data: [{value: obj.value, name: obj.unit,id:obj.id,}]
                        };
                    if(index<3){
                        seriesData.push(d);
                    }else if(index>2&index<6){
                        seriesData1.push(d);
                    }else if(index>5&index<9){
                        seriesData2.push(d);
                    }else{
                        seriesData3.push(d)
                    }
                  //  seriesData.push(d);
                    /* console.log(seriesData);
                     console.log("main" + (index + 1));
                     var myChart = echarts.init(document.getElementById('main' + (index + 1)));
                     showChart(myChart, seriesData);*/
                }else{
                    var b = {
                                name:  obj.name+'('+obj.unit+')',
                                type: 'gauge',
                                center: ['85%', '55%'],    // 默认全局居中
                                radius: '70%',
                                min: obj.mini,
                                max: obj.max,
                                //startAngle: 180,
                                //endAngle: 10,
                                splitNumber: 10,
                                axisLine: {            // 坐标轴线
                                    lineStyle: {       // 属性lineStyle控制线条样式
                                        width: 8
                                    }
                                },
                                axisTick: {            // 坐标轴小标记
                                    splitNumber: 5,
                                    length: 10,        // 属性length控制线长
                                    lineStyle: {       // 属性lineStyle控制线条样式
                                        color: 'auto'
                                    }
                                },
                           /* /!*axisLabel: {
                            formatter:function(v){
                                switch (v + '') {
                                    case '0' : return 'E';
                                    case '1' : return 'Gas';
                                    case '2' : return 'F';
                                }
                            }
                        },*!/*/
                        splitLine: {
                            // 分隔线
                            length: 15,         // 属性length控制线长
                                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                                color: 'auto'
                            }
                        },
                        pointer: {
                            width:2
                        },
                        title : {
                            show: true,
                                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                fontWeight: 'bolder',
                                    fontSize: 16,
                                    fontStyle: 'italic'
                            }
                        },
                        detail : {
                            show: true,
                            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                fontWeight: 'bolder',
                                fontSize: 16,
                            }
                        },
                        data:[{value: obj.value, name: obj.unit,id:obj.id, }]
                    };
                    if(index<3){
                        seriesData.push(b);
                    }else if(index>2 & index<6){
                        seriesData1.push(b);
                    }else if(index>5 & index<9){
                        seriesData2.push(b);
                    }else{
                        seriesData3.push(b)
                    }
                   //
                    // seriesData.push(b);
                }

                $("#sj"+(index+1)).val(obj.id);

            });
            //console.log("main" + (index + 1));
            var myChart = echarts.init(document.getElementById('main'));
            showChart(myChart, seriesData,til);

           /* console.log("【seriesData】："+seriesData);
            console.log("【seriesData1】："+seriesData1);
            console.log("【seriesData2】："+seriesData2);
            console.log("【seriesData3】："+seriesData3);*/

           // if(result.groupdata.length<3){
                $("#main1").hide();
                $("#main2").hide();
                $("#main3").hide();
                $("#tbd1").hide();
                $("#tbd2").hide();
                $("#tbd3").hide();
            if(result.groupdata.length>3&result.groupdata.length<7){
                $("#main1").show();
                $("#main2").hide();
                $("#main3").hide();
                $("#tbd1").show();
                $("#tbd2").hide();
                $("#tbd3").hide();
            }else if(result.groupdata.length>6&result.groupdata.length<10){
                $("#main2").show();
                $("#main1").show();
                $("#main3").hide();
                $("#tbd1").show();
                $("#tbd2").show();
                $("#tbd3").hide();
            }else if(result.groupdata.length>9){
                $("#main3").show();
                $("#main2").show();
                $("#main1").show();
                $("#tbd1").show();
                $("#tbd2").show();
                $("#tbd3").show();
            }
            var myChart1 = echarts.init(document.getElementById('main1'));
            showChart(myChart1, seriesData1,til);
            var myChart2 = echarts.init(document.getElementById('main2'));
            showChart(myChart2, seriesData2,til);
            var myChart3 = echarts.init(document.getElementById('main3'));
            showChart(myChart3, seriesData3,til);

        }
    });

}


function showChart(myChart,seriesData,til){
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            formatter: "{a} <br/>{c} {b}"
        },
        title: {
            show: true,
            textAlign: 'center',
            text: til,//title
            left: 'center',
            textStyle: {
                color: '#333',
                fontWeight: 'bolder',
                fontStyle: 'italic',
                fontFamily: 'sans-serif',
                fontSize: 20,
            },
        },
        toolbox: {
            show: true,
            feature: {
                restore: {show: false},
                saveAsImage: {show: false}
            }
        },
        series: seriesData
    };

    function eConsole(param) {
        //var str = param.id + "======" + param.value;
       // console.log(param);
        var nodeId = $("#nodeId").val();
        window.location.href = $("#basePath").val() +"dtuHome/goHisPage?nodeId="+nodeId+"&pId="+param.data.id;
        //alert(param.data.id);
        //$("#main1").css({ "display": "block" });
        //test1(3);
    }

    myChart.on("CLICK", eConsole);
    myChart.setOption(option,true);
}

function showD(groupId,name,id) {
    $("#del_id").val(groupId);
    $("#upd_id").val(groupId);
    $("#del_show").empty();
    $("#del_show").html("你确定要删除【"+name+"】分组吗？");
    console.log($("#groupId").val());
    $("#btn_1").removeClass("active");
    $("#btn_2").removeClass("active");
    $("#btn_3").removeClass("active");
    $("#btn_4").removeClass("active");
    $("#btn_5").removeClass("active");
    $("#btn_6").removeClass("active");
    $("#btn_7").removeClass("active");
    $("#btn_8").removeClass("active");
    $("#btn_9").removeClass("active");
    $("#btn_10").removeClass("active");

    if(id == '1'){
        $("#btn_1").addClass("active");
    }else if(id == '2'){
        $("#btn_2").addClass("active");
    }else if(id == '3'){
        $("#btn_3").addClass("active");
    }else if(id == '4'){
        $("#btn_4").addClass("active");
    }else if(id == '5'){
        $("#btn_5").addClass("active");
    }else if(id == '6'){
        $("#btn_6").addClass("active");
    }else if(id == '7'){
        $("#btn_7").addClass("active");
    }else if(id == '8'){
        $("#btn_8").addClass("active");
    }else if(id == '9'){
        $("#btn_9").addClass("active");
    }else if(id == '10'){
        $("#btn_10").addClass("active");
    }
    show(groupId,name);
}

/*新增*/
function doAdd() {
    $("#add_msg").empty();
    var nodeId = $("#nodeId").val();
    var asj1 = $("#asj1").val();
    var asj2 = $("#asj2").val();
    var asj3 = $("#asj3").val();
    var asj4 = $("#asj4").val();
    var asj5 = $("#asj5").val();
    var asj6 = $("#asj6").val();
    var asj7 = $("#asj7").val();
    var asj8 = $("#asj8").val();
    var asj9 = $("#asj9").val();
    var asj10 = $("#asj10").val();

    var aname1 = $("#aname1").val();
    if (aname1 == '' || aname1.length == 0) {
        $("#add_msg").html("请输入分组名称");
        return false;
    }
    $.ajax({
        type: "POST",
        url: $("#basePath").val() + "dtuOperate/addGroup.adv",
        data: {
            nodeId: nodeId,
            asj1: asj1,
            asj2: asj2,
            asj3: asj3,
            asj4: asj4,
            asj5: asj5,
            asj6: asj6,
            asj7: asj7,
            asj8: asj8,
            asj9: asj9,
            asj10: asj10,
            aname1: aname1,
        },
        success: function (data) {
            var result = eval("(" + data + ")");
            if (result == "SUC") {
                window.location.href = $("#basePath").val()+"dtuHome/goDataPage?nodeId="+nodeId+"&type=2";
            }else{
                $("#add_msg").html(result);
                return false;
            }
        }
    });
}

/*修改弹窗*/
function doUpd() {
    $("#upd_msg").empty();
    var nodeId = $("#nodeId").val();
    var groupId = $("#upd_id").val();
    var asj1 = $("#sj1").val();
    var asj2 = $("#sj2").val();
    var asj3 = $("#sj3").val();
    var asj4 = $("#sj4").val();
    var asj5 = $("#sj5").val();
    var asj6 = $("#sj6").val();
    var asj7 = $("#sj7").val();
    var asj8 = $("#sj8").val();
    var asj9 = $("#sj9").val();
    var asj10 = $("#sj10").val();

    var aname1 = $("#uname1").val();
    if (aname1 == '' || aname1.length == 0) {
        $("#upd_msg").html("请输入分组名称");
        return false;
    }
    $.ajax({
        type: "POST",
        url: $("#basePath").val() + "dtuOperate/updGroup.adv",
        data: {
            nodeId: nodeId,
            asj1: asj1,
            asj2: asj2,
            asj3: asj3,
            asj4: asj4,
            asj5: asj5,
            asj6: asj6,
            asj7: asj7,
            asj8: asj8,
            asj9: asj9,
            asj10: asj10,
            aname1: aname1,
            groupId : groupId
        },
        success: function (data) {
            var result = eval("(" + data + ")");
            if (result == "SUC") {
                window.location.href = $("#basePath").val()+"dtuHome/goDataPage?nodeId="+nodeId+"&type=2";
            }else{
                $("#upd_msg").html(result);
                return false;
            }
        }
    });
}

/*删除弹窗*/
function doDel() {
    var nodeId = $("#nodeId").val();
    var groupId = $("#del_id").val();
    $.ajax({
        type:"POST",
        url:$("#basePath").val() + "dtuOperate/delGroup.adv",
        data:{
            nodeId:nodeId,
            groupId:groupId
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){
                window.location.href = $("#basePath").val()+"dtuHome/goDataPage?nodeId="+nodeId+"&type=2";
            }else{
                $("#del_msg").html(result);
                return false;
            }
        }

    });
}