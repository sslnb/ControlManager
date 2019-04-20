layui.use(['form', 'table'], function(){  //只加载模块
    var form = layui.form //获取form模块
        ,table = layui.table; //获取upload模块
    oneDay()
    //首页饼状图
    var myChart1 = echarts.init(document.getElementById('char1'));
    //24小时系统信息
    var myCartTotalSysInfo = echarts.init(document.getElementById('totalSysInfo'));
    var option2 = {
        /* title: {
             text: '测试'
         },*/
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['cpu','内存','磁盘','jvm']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['*1','*2','*3','*4','*5','*6','*7','*8','*9','*10','*11','*12','*13','*14','*15','*16','*17','*18','*19','*20','*21','*22','*23','*24']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'cpu',
                type:'line',
                stack: '总量',
                data:[12,32, 11, 14, 9, 23, 21,12, 12, 11, 14, 9, 23, 21,12, 12, 11, 13, 9, 23, 21,12, 12, 11]
            },
            {
                name:'内存',
                type:'line',
                stack: '总量',
                data:[22, 12, 31, 24, 29, 33, 31,12, 12, 11, 14, 9, 23, 21,22, 2, 41, 34, 29, 33, 31,22, 12, 41]
            },
            {
                name:'磁盘',
                type:'line',
                stack: '总量',
                data:[15, 32, 21, 14, 19, 33, 41,15, 22, 21, 14, 19, 33, 41,15, 22, 21, 14, 19, 33, 41,15, 22, 21]
            },
            {
                name:'jvm',
                type:'line',
                stack: '总量',
                data:[32, 33, 31, 33, 39, 33, 32,32, 32, 31, 34, 39, 33, 32,32, 32, 31, 34, 39, 33, 32,32, 32, 31]
            }
        ]
    };
    /*24小时系统信息获取*/
    function oneDay(){
        $.ajax({
            type: "POST",
            url: "/ControlManager/softRJXTController/selInfo",
            dataType: "json",
            success: function (data) {
                if (data.code==0){
                    myCartTotalSysInfo.setOption(option2);
                }else{
                    option2.xAxis.data = data.sjList;
                    option2.series[0].data = data.cpuList;
                    option2.series[1].data = data.memList;
                    option2.series[2].data = data.devList;
                    option2.series[3].data = data.jvmList;
                    myCartTotalSysInfo.setOption(option2);
                }
            },error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
            }
        });
    }


    var optionTask = {
        title : {
            text: '任务总览',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['已完成任务','运行中任务','未执行任务','已停止任务']
        },
        series : [
            {
                name: '详情',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ],color:['#FF6666','#87CEEB','#123FFF','#FFFBBB']
    };
    //异步请求后端 获取需要展示的信息(系统信息及饼状图)；修改为系统信息和任务数分开调用
    $.ajax({
        type: "POST",
        url: "/ControlManager/sysController/selSysInfo",
        dataType: "json",
        success: function(data){
            //得到数据 放到页面进行展示
            $("#sysVersion").html(data.sysArch);
            $("#swap").html(data.swap);
            $("#cpu").html(data.cpu);
            $("#dev").html(data.dev);
            $("#jvm").html(data.jvm);
            $("#sysRam").html(data.mem);
           /* myCharMem.setOption(optionMem);
            myCharCpu.setOption(optionCpu);
            myCharDev.setOption(optionDev);
            myCharMem.setOption({
                series:[{
                    name:'详情',
                    type:'pie',
                    data:[{value:data.memNum,name:'已使用内存'},{value:(100-data.memNum),name:'未使用内存'}]
                }]
            });
            myCharCpu.setOption({
                series:[{
                    name:'详情',
                    type:'pie',
                    data:[{value:data.cpuNum,name:'已使用CPU'},{value:(100-data.cpuNum),name:'未使用CPU'}]
                }]
            });
            myCharDev.setOption({
                series:[{
                    name:'详情',
                    type:'pie',
                    data:[{value:data.devNum,name:'已使用磁盘空间'},{value:(100-data.devNum),name:'未使用磁盘空间'}]
                }]
            });*/
        }
    });
    myCartTotalSysInfo.setOption(option2);
    /*新添加用作于调用jobController层，查出任务数*/
    $.ajax({
        type:"POST",
        url:"/ControlManager/jobController/getCount",
        dataType:"json",
        success:function (data) {
            $("#totalCount").html(data.totalCount);
            $("#completedCount").html(data.completedCount);
            $("#startCount").html(data.startCount);
            $("#normalCount").html(data.normalCount);
            $("#pauseCount").html(data.pauseCount);
            myChart1.setOption(optionTask);
            if (data.completedCount=="0"&&data.startCount=="0"&&data.normalCount=="0"&&data.pausedCount=="0"){
                myChart1.setOption({
                    series : [
                        {
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value: 1,name: '已完成任务'}
                            ]
                        }
                    ]
                });
            }else{
                myChart1.setOption({
                    series : [
                        {
                            name: '详情',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value: data.completedCount,name: '已完成任务'},
                                {value: data.startCount,name: '运行中任务'},
                                {value: data.normalCount,name: '未执行任务'},
                                {value: data.pauseCount,name: '已停止任务'}
                            ]
                        }
                    ]
                });
            }
        }
    });
});
