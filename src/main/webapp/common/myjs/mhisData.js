$(function(){
    var timeData = [];
    var data = [];
    /*    timeData = timeData.map(function (str) {
     return str;//0.replace('2009/', '');
     });*/
    var option = {
        title: {
            text: '历史数据',
            //subtext: '数据来自西安兰特水电测控技术有限公司',
            x: 'center'
        },
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
    myChart.setOption(option);


    /**查询数据显示图形*/
    $("#searchBtn").click(function () {
        var dtu_sn = $("#nodeId").val();
        var pId = $("#pId").val();
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        var dataType = $("#dataType").val();
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
                    timeData = result.timeData;
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
                    myChart.setOption(option,true);
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