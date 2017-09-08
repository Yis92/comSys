
var option;
$(function(){
    var timeData = [];
    var data = [];
/*    timeData = timeData.map(function (str) {
     return str;//0.replace('2009/', '');
     });*/
    option = {
        /*title: {
         text: '历史数据',
         //subtext: '数据来自西安兰特水电测控技术有限公司',
         x: 'center'
         },*/
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                animation: false
            }
        },
        legend: {
            data:['前台（1）温度'],
            x: 'left'
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {},
                restore: {},
                saveAsImage: {}
            }
        },
        axisPointer: {
            link: {xAxisIndex: 'all'}
        },
        dataZoom: [
            {
                show: true,
                realtime: true,
                start: 30,
                end: 70,
                xAxisIndex: [0]
            }
        ],
        grid: {
            left: 50,
            right: 50,
            height: '65%'
        },
        xAxis :
            {
                type : 'category',
                boundaryGap : false,
                axisLine: {onZero: true},
                data: timeData
            },
        yAxis :
            {
                name : '温度(°C)',
                type : 'value',
                max : 500,
                min : -40
            },
        series : [
            {
                name:'温度(°C)',
                type:'line',
                symbolSize: 8,
                hoverAnimation: false,
                data:data
            }
        ]
    };
    var myChart = echarts.init(document.getElementById('main'));
    var dtu_sn = $("#nodeId").val();
    var pId = $("#pId").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var dataType = $("#dataType").val();
    if( $("#pId").val() == ""){
        pId = $("#dataNo").val();
    }else{
        $("#dataNo").val(pId);
    }

    $.ajax({
        type:"POST",
        url:$("#basePath").val()+"dtuData/getHisData",
        data:{
            dtu_sn:dtu_sn,
            pId:pId,
            startDate:startDate,
            endDate:endDate,
            dataType:dataType
        },
        success:function(dt){
            var result = eval("("+dt+")");
            if(result.suc = 'SUC'){
                /*timeData = result.timeData;
                data = result.data;
                var legendData = result.legendData;
                var yAxisName = result.yAxisName;
                var seriesName = result.seriesName;
                var max = result.yMax;
                var min = result.yMin;

                option.legend.data = legendData;
                option.yAxis.max = max;
                option.yAxis.min = min;
                option.yAxis.name = yAxisName;
                option.series[0].name = seriesName;
                option.xAxis.data = timeData;
                option.series[0].data=data;
                myChart.setOption(option,true);*/

                timeData = result.timeData;
                data = result.data;
                var legendData = result.legendData;
                var yAxisName = result.yAxisName;
                console.log(result.seriesList);
                console.log(legendData);
                option.series = [];
                $.each(result.seriesList,function(index,value){
                    console.log(value);
                    option.series.push(value);
                });
                var max = result.yMax;
                var min = result.yMin;
                option.legend.data =  legendData;
                option.yAxis.max = max;
                option.yAxis.min = min;
                option.yAxis.name = yAxisName;
                option.xAxis.data = timeData;
                myChart.setOption(option,true);


              /*  $("#tbl").empty();
                var thed = '';
                thed+='<tr>';
                thed+='<td>时间</td>';
                $.each(legendData,function(index,value){
                    //console.log(value);
                    thed+='<td>'+value+'</td>';
                    //option.series.push(value);
                });
                thed+='</tr>';
                $("#tbl").append(thed);

                $.each(timeData,function(i,v){
                    var tds = '<tr><td>'+v+'</td>';
                    $.each(result.seriesList,function(j,val){
                        tds+='<td>'+val.data[i]+'</td>';
                    });
                    tds +='</tr>';
                    $("#tbl").append(tds);
                });*/
            }else{
                console.log("系统异常############################");
                alert("系统异常");
            }
        }
    });
  //
  //  myChart.setOption(option);


    /**查询数据显示图形*/
    $("#searchBtn").click(function () {

        option = {
            /*title: {
             text: '历史数据',
             //subtext: '数据来自西安兰特水电测控技术有限公司',
             x: 'center'
             },*/
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    animation: false
                }
            },
            legend: {
                data:['前台（1）温度'],
                x: 'left'
            },
            toolbox: {
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    },
                    dataView: {},
                    restore: {},
                    saveAsImage: {}
                }
            },
            axisPointer: {
                link: {xAxisIndex: 'all'}
            },
            dataZoom: [
                {
                    show: true,
                    realtime: true,
                    start: 30,
                    end: 70,
                    xAxisIndex: [0]
                }
            ],
            grid: {
                left: 50,
                right: 50,
                height: '65%'
            },
            xAxis :
                {
                    type : 'category',
                    boundaryGap : false,
                    axisLine: {onZero: true},
                    data: timeData
                },
            yAxis :
                {
                    name : '温度(°C)',
                    type : 'value',
                    max : 500,
                    min : -40
                },
            series : [
                {
                    name:'温度(°C)',
                    type:'line',
                    symbolSize: 8,
                    hoverAnimation: false,
                    data:data
                }
            ]
        };
        var myChart = echarts.init(document.getElementById('main'));

        var dtu_sn = $("#nodeId").val();
        var pId = $("#dataNo").val().toString();//$("#dataNo").val();
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        var dataType = $("#dataType").val();

        console.log("endDate:"+endDate);
        console.log("startDate:"+startDate);


        var arr=pId.split(',');

        console.log("pId----->"+pId);

        console.log("size----->"+arr.length);

        if(arr.length > 10){
            alert("请选择少于或等于10个要素进行比较");
            return false;
        }

       /* if( $("#pId").val() == ""){
            pId = $("#dataNo").val();
        }*/
        $.ajax({
            type:"POST",
            url:$("#basePath").val()+"dtuData/getHisData",
            data:{
                dtu_sn:dtu_sn,
                pId:pId,
                startDate:startDate,
                endDate:endDate,
                dataType:dataType
            },
            success:function(dt){
                var result = eval("("+dt+")");
                if(result.suc = 'SUC'){
                    /*timeData = result.timeData;
                    data = result.data;
                    var legendData = result.legendData;
                    var yAxisName = result.yAxisName;
                    var seriesName = result.seriesName;
                    var max = result.yMax;
                    var min = result.yMin;

                    option.legend.data = legendData;
                    option.yAxis.max = max;
                    option.yAxis.min = min;
                    option.yAxis.name = yAxisName;
                    option.series[0].name = seriesName;
                    option.xAxis.data = timeData;
                    option.series[0].data=data;
                    myChart.setOption(option,true);*/
                    timeData = result.timeData;
                    data = result.data;
                    var legendData = result.legendData;
                    var yAxisName = result.yAxisName;
                    console.log(result.seriesList);
                    console.log(legendData);
                    option.series = [];
                    $.each(result.seriesList,function(index,value){
                        console.log(value);
                        option.series.push(value);
                    });
                    var max = result.yMax;
                    var min = result.yMin;
                    option.legend.data =  legendData;
                    option.yAxis.max = max;
                    option.yAxis.min = min;
                    option.yAxis.name = yAxisName;
                    option.xAxis.data = timeData;
                    myChart.setOption(option,true);


                  /*  $("#tbl").empty();
                    var thed = '';
                    thed+='<tr>';
                    thed+='<td>时间</td>';
                    $.each(legendData,function(index,value){
                        //console.log(value);
                        thed+='<td>'+value+'</td>';
                        //option.series.push(value);
                    });
                    thed+='</tr>';
                    $("#tbl").append(thed);

                    $.each(timeData,function(i,v){
                        var tds = '<tr><td>'+v+'</td>';
                        $.each(result.seriesList,function(j,val){
                            tds+='<td>'+val.data[i]+'</td>';
                        });
                        tds +='</tr>';
                        $("#tbl").append(tds);
                    });*/
                }else{
                    console.log("系统异常############################");
                    alert("系统异常");
                }
            }
        });
    });


    $("#excelBtn").click(function () {

        var dtu_sn = $("#nodeId").val();
        var pId = $("#dataNo").val().toString();//$("#dataNo").val();
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        var dataType = $("#dataType").val();

        console.log("endDate:"+endDate);
        console.log("startDate:"+startDate);

        var arr=pId.split(',');

        console.log("pId----->"+pId);

        console.log("size----->"+arr.length);

        if(arr.length > 10){
            alert("请选择少于或等于10个要素进行比较");
            return false;
        }

        /* if( $("#pId").val() == ""){
         pId = $("#dataNo").val();
         }*/
        $.ajax({
            type:"POST",
            url:$("#basePath").val()+"dtuData/getHisData",
            data:{
                dtu_sn:dtu_sn,
                pId:pId,
                startDate:startDate,
                endDate:endDate,
                dataType:dataType
            },
            success:function(dt){
                var result = eval("("+dt+")");
                if(result.suc = 'SUC'){
                    /*timeData = result.timeData;
                     data = result.data;
                     var legendData = result.legendData;
                     var yAxisName = result.yAxisName;
                     var seriesName = result.seriesName;
                     var max = result.yMax;
                     var min = result.yMin;

                     option.legend.data = legendData;
                     option.yAxis.max = max;
                     option.yAxis.min = min;
                     option.yAxis.name = yAxisName;
                     option.series[0].name = seriesName;
                     option.xAxis.data = timeData;
                     option.series[0].data=data;
                     myChart.setOption(option,true);*/
                    timeData = result.timeData;
                    data = result.data;
                    var legendData = result.legendData;
                    //var yAxisName = result.yAxisName;
                    //console.log(result.seriesList);
                    //console.log(legendData);
                    //option.series = [];
                    /*$.each(result.seriesList,function(index,value){
                        console.log(value);
                        option.series.push(value);
                    });*/
                    //var max = result.yMax;
                   // var min = result.yMin;
                    //option.legend.data =  legendData;
                    //option.yAxis.max = max;
                    //option.yAxis.min = min;
                    //option.yAxis.name = yAxisName;
                    //option.xAxis.data = timeData;
                    //myChart.setOption(option,true);

                    $("#tbl").empty();
                    var thed = '';
                    thed+='<tr>';
                    thed+='<td>时间</td>';
                    $.each(legendData,function(index,value){
                        //console.log(value);
                        thed+='<td>'+value+'</td>';
                        //option.series.push(value);
                    });
                    thed+='</tr>';
                    $("#tbl").append(thed);

                    $.each(timeData,function(i,v){
                        var tds = '<tr><td>'+v+'</td>';
                        $.each(result.seriesList,function(j,val){
                            tds+='<td>'+val.data[i]+'</td>';
                        });
                        tds +='</tr>';
                        $("#tbl").append(tds);
                    });


                    console.log("点击导出");
                    //名称命名  尾部添加时间  防止命名重复
                    //var date = new Date();
                    //var dateName = date.getFullYear()+''+(date.getMonth() + 1)+''+date.getDate();

                    var star = startDate.replace(" 00:00:00", "").replace("-","").replace("-","");
                    var end = endDate.replace(" 23:59:59", "").replace("-","").replace("-","");
                    var dateName =star+"-"+end;
                    //alert("导出");
                    //$("#example").tableExport({ type: 'excel', escape: 'false' });
                    $("#tbl").table2excel({
                        // 不被导出的表格行的CSS class类
                        exclude: ".noExl",
                        // 导出的Excel文档的名称
                        name: "历史数据",
                        // Excel文件的名称
                        filename: dateName+"-"+dtu_sn,
                        exclude_img: false,
                        exclude_links: false,
                        exclude_inputs: false
                    });
                }else{
                    console.log("系统异常############################");
                    alert("系统异常");
                }
            }
        });

    });


});

/**导出*/
function excel(){
    //名称命名  尾部添加时间  防止命名重复
    var date = new Date();
    var dateName = date.getFullYear()+''+(date.getMonth() + 1)+''+date.getDate()+''+date.getHours()+''+date.getMinutes()+''+date.getSeconds();
    //alert("导出");
    //$("#example").tableExport({ type: 'excel', escape: 'false' });
    $("#tbl").table2excel({
        // 不被导出的表格行的CSS class类
        exclude: ".noExl",
        // 导出的Excel文档的名称
        name: "放款统计表",
        // Excel文件的名称
        filename: "放款统计表"+dateName,
        exclude_img: false,
        exclude_links: false,
        exclude_inputs: false
    });
}


function showLine() {
    var dtu_sn = $("#dtu_sn").val();
    var pId = $("#pId").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var dataType = $("#dataType").val();
    $.ajax({
        type:"POST",
        url:"",
        data:{
            dtu_sn:dtu_sn,
            pId:pId,
            startDate:startDate,
            endDate:endDate,
            dataType:dataType
        },
        success:function(data){

        }
    });
}

/*本日*/
function today(){
    var end = new Date();
    var today = new Date();

    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
    $("#dataType").val("1");
    $("#dataType").attr("disabled","disabled");
}
/*近七天*/
function seven(){
    var end = new Date();
    var today = new Date(end.getTime()- 7*24*60*60*1000);
    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
    $("#dataType").val("2");
    $("#dataType").attr("disabled","disabled");
}
/*近30天*/
function san(){
    var end = new Date();
    var today = new Date(end.getTime()- 30*24*60*60*1000);
    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
    $("#dataType").val("2");
    $("#dataType").attr("disabled","disabled");
}

function getTime(date){
    if(date == ''|| date == null){
        return null;
    }
    if(date.getMonth()<9){
        var st = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-' + date.getDate() +' 00:00:00';
        return st;
    }else{
        var st = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() +' 00:00:00';
        return st;
    }
}

function getTimeE(date){
    if(date == ''|| date == null){
        return null;
    }
    if(date.getMonth()<9){
        var st = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-' + date.getDate() +' 23:59:59';
        return st;
    }else{
        var st = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() +' 23:59:59';
        return st;
    }
}