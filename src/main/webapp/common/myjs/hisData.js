
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

            }
        }
    });
  //
  //  myChart.setOption(option);


    /**查询数据显示图形*/
    $("#searchBtn").click(function () {
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
            success:function(dt){                var result = eval("("+dt+")");
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

                }else{
                    alert("系统异常");
                }
            }
        });
    });



});


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
    var today = new Date(end.getTime()- 24*60*60*1000);

    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
}
/*近七天*/
function seven(){
    var end = new Date();
    var today = new Date(end.getTime()- 7*24*60*60*1000);
    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
}
/*近30天*/
function san(){
    var end = new Date();
    var today = new Date(end.getTime()- 30*24*60*60*1000);
    //alert(getTime(end));
    $("#startDate").val(getTime(today));
    $("#endDate").val(getTimeE(end));
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