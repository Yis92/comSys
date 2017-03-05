$(function() {
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            formatter: "{a} <br/>{c} {b}"
        },
        title:{
            show:true,
            textAlign:'center',
            text:"办公区监控",
            left:'center',
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
        series: [
            {
                name: '温度',
                type: 'gauge',
                z: 3,
                min: 0,
                max: 100,
                splitNumber: 10,
                radius: '50%',
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
                /*axisLabel: {
                 formatter:function(v){
                 switch (v + '') {
                 case '0' : return 'E';
                 case '1' : return 'Gas';
                 case '2' : return 'F';
                 }
                 }
                 },*/
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
            }
        ]

    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});