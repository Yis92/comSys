$(function() {

    var firstId = $("#firstId").val();
    show(firstId);
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

function show(group_id) {
    var nodeId = $("#nodeId").val();
    var seriesData = new Array();
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
                if(obj.id == 1){
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
                                fontWeight: 'bolder'
                            }
                        },
                        data: [{value: obj.value, name: obj.name+"("+obj.unit+")",id:obj.id,}]
                    };
                    seriesData.push(d);
                    //  console.log(seriesData);
                }else if(obj.id == 2){
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
                                    fontWeight: 'bolder'
                                }
                            },
                            data: [{value: obj.value, name: obj.name+"("+obj.unit+")",id:obj.id,}]
                        };
                    seriesData.push(d);
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
                            show: true
                        },
                        data:[{value: obj.value, name:  obj.name+"("+obj.unit+")",id:obj.id, }]
                    };
                    seriesData.push(b);
                }
            });
            //console.log("main" + (index + 1));
            var myChart = echarts.init(document.getElementById('main'));
            showChart(myChart, seriesData);
        }
    });

}


function showChart(myChart,seriesData){
    var til = $("#til").val();
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
                fontSize: 22,
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
    show(groupId);
}

/*修改弹窗*/
function upd() {

}

/*删除弹窗*/
function doDel() {
    var nodeId = $("#nodeId").val();
    var groupId = $("#del_id").val();

    $.ajax({
        type:"POST",
        url:$("#basePath").val() + "dtuData/delGroup.adv",
        data:{
            nodeId:nodeId,
            groupId:groupId
        },
        success:function (data) {
            var result = eval("("+data+")");
            if(result == "SUC"){

            }
        }

    });
}