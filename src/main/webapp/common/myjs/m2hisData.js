var curDate = new Date();
var startDate = new Date();
var endDate = new Date(curDate.getTime() + 24*60*60*1000);
var option;
var myChart;
$(function(){


    var browser = {
        versions: function () {
            var u = navigator.userAgent, app = navigator.appVersion;
            return {//<a href="http://www.suchso.com/productdesign/sharemobileappproductdesign.html" class="keylink" title=" 移动" target="_blank">移动</a>终端浏览器版本信息
                trident: u.indexOf('Trident') > -1, //IE内核
                presto: u.indexOf('Presto') > -1, //opera内核
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1, //是否iPad
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
            };
        }(),
        language: (navigator.browserLanguage || navigator.language).toLowerCase()
    }
    //document.writeln("语言版本: "+browser.language);
    //document.writeln(" 是否为移动终端: "+browser.versions.mobile);
    //document.writeln(" ios终端: "+browser.versions.ios);
    //document.writeln(" android终端: "+browser.versions.android);
    //document.writeln(" 是否为iPhone: "+browser.versions.iPhone);
    //document.writeln(" 是否iPad: "+browser.versions.iPad);
    //document.writeln(navigator.userAgent);
    var pagewidth = $(window).width();
    var pageheight = $(window).height();
    if (browser.versions.mobile) {
        window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", hengshuping, false);
        $("#report_box").height(pageheight*0.6);
        $("#report_box").width(pagewidth * 0.95);
    }
    else {
        $("#report_box").height("500px");
        $("#report_box").width("700px");
    }


    var timeData = [];
    var data = [];
    /*    timeData = timeData.map(function (str) {
     return str;//0.replace('2009/', '');
     });*/
    option = {
       /* title: {
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
        /*toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },*/
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
            //height: '95%'
            containLabel: true
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
    myChart = echarts.init(document.getElementById('main'));
    var dtu_sn = $("#nodeId").val();
    var pId = $("#pId").val();
    /* var startDate = $("#startDate").val();
     var endDate = $("#endDate").val();*/

    var st =  getTime(startDate);       //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';
    var et = getTime(endDate);          //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';

    var dataType = $("#dataType").val();
    if( $("#pId").val() == ""){
        pId = $("#dataNo").val();
    }else{
        $("#dataNo").val(pId);
    }
    $.ajax({
        type:"POST",
        url:$("#basePath").val()+"home/getHisData2",
        data:{
            dtu_sn:dtu_sn,
            pId:pId,
            startDate:st,
            endDate:et,
            dataType:dataType
        },
        success:function(dt){
            var result = eval("("+dt+")");
            if(result.suc = 'SUC'){
               /* timeData = result.timeData;
                data = result.data;
                var legendData = result.legendData;
                var yAxisName = result.yAxisName;
                var seriesName = result.seriesName;
                var max = result.yMax;
                var min = result.yMin;

                option.legend.data =  legendData;
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
                //option.legend.data =  legendData;
                option.yAxis.max = max;
                option.yAxis.min = min;
                option.yAxis.name = yAxisName;
                option.xAxis.data = timeData;
                myChart.setOption(option,true);
            }
        }
    });

    /**查询数据显示图形*/
    $("#searchBtn").click(function () {
        var dtu_sn = $("#nodeId").val();
        var pId =$("#dataNo").val().toString();//$("#dataNo").val();
        var st =  getTime(startDate);       //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';
        var et = getTime(endDate);          //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';
        /*
         var startDate = $("#startDate").val();
         var endDate = $("#endDate").val();*/
        var dataType = $("#dataType").val();
        if(dataType == '1'){
            $("#d_show").show();
            $("#w_show").hide();
            startDate = new Date();
            endDate = new Date(curDate.getTime() + 24*60*60*1000);
        }else{
            $("#d_show").hide();
            $("#w_show").show();
            startDate = new Date(new Date() - 7*24*60*60*1000);
            endDate = new Date(curDate.getTime() + 24*60*60*1000);
        }
        var st =  getTime(startDate);       //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';
        var et = getTime(endDate);          //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';

        var arr=pId.split(',');

        console.log("pId----->"+pId);

        console.log("size----->"+arr.length);

        if(arr.length > 10){
            alert("请选择少于或等于10个要素进行比较");
            return false;
        }


        $.ajax({
            type:"POST",
            url:$("#basePath").val()+"home/getHisData2",
            data:{
                dtu_sn:dtu_sn,
                pId:pId,
                startDate:st,
                endDate:et,
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

                    option.legend.data =  legendData;
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
                   // option.legend.data =  legendData;
                    option.yAxis.max = max;
                    option.yAxis.min = min;
                    option.yAxis.name = yAxisName;
                    option.xAxis.data = timeData;
                    myChart.setOption(option,true);
                }
            }
        });
    });



});


function hengshuping(){
    if(window.orientation==180||window.orientation==0){
        $("#report_box").height($(window).height()-20);
        $("#report_box").width("100%");
    }
    if(window.orientation==90||window.orientation==-90){
        $("#report_box").height($(window).height()-20);
        $("#report_box").width("100%");
    }
}




/*前一天*/
function up(num){
    /* var preDate = new Date(curDate.getTime() - 24*60*60*1000);  //前一天
     var nextDate = new Date(curDate.getTime() + 24*60*60*1000);  //后一天*/
    startDate = new Date(startDate.getTime() - num*24*60*60*1000);
    endDate = new Date(endDate.getTime() - num*24*60*60*1000);
    showLine();
}
/*后一天*/
function down(num){
    startDate = new Date(startDate.getTime() + num*24*60*60*1000);
    endDate = new Date(endDate.getTime() + num*24*60*60*1000);
    showLine();
}
//时间转化
function getDate(strDate) {
    if(strDate == ''|| strDate == null){
        return null;
    }
    var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
            function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');
    return date;
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

function showLine() {
    var dtu_sn = $("#nodeId").val();
    var pId =$("#dataNo").val().toString();//$("#dataNo").val();
    var dataType = $("#dataType").val();
    var st =  getTime(startDate);       //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';
    var et = getTime(endDate);          //startDate.getFullYear() + '-' + (startDate.getMonth() + 1) + '-' + startDate.getDate() +' 00:00:00';

    var arr=pId.split(',');

    console.log("pId----->"+pId);

    console.log("size----->"+arr.length);

    if(arr.length > 10){
        alert("请选择少于或等于10个要素进行比较");
        return false;
    }


    $.ajax({
        type:"POST",
        url:$("#basePath").val()+"home/getHisData2",
        data:{
            dtu_sn:dtu_sn,
            pId:pId,
            startDate:st,
            endDate:et,
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
                //option.legend.data =  legendData;
                option.yAxis.max = max;
                option.yAxis.min = min;
                option.yAxis.name = yAxisName;
                option.xAxis.data = timeData;
                myChart.setOption(option,true);
            }
        }
    });
}