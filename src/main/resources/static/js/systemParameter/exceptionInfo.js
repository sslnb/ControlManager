$(document).ready(function(){
    //do something
    excepInfo();
});
function excepInfo(){
    //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
    layui.use(['table','element'], function(){
        var element = layui.element
        var table = layui.table;

        table.render({
            elem: '#exceptionTaskTable'
            ,url: '/ControlManager/comprehensiveController/selAllExeception'
            ,page:true
            ,limit:10
            ,limits : [10,15,20]
            ,even: true
            ,cols: [[
                {field:'id', title: 'ID', width:'10%', sort: true,align:'center'}
                ,{field:'jgxtlb', title: '交管系统类别', width:'20%',align:'center'}
                ,{field:'jobname', title: '任务名', width:'20%',align:'center'}
                ,{field:'desciption', title: '描述', width:'25%',align:'center'}
                ,{field:'createtime', title: '时间', width:'25%',align:'center',templet:function(d){
                        return timestampToTime(d.createtime);
                    }}
            ]],  done: function(res, curr, count){
                //layer.msg("数据加载完成...")
            }
        });


    });
}
function selExceptionInfo() {
    var sel_1 = $("#sel_1").val();
    if (sel_1==""){
        excepInfo();
    }else{
        console.log("条件:"+sel_1)
        //读取查询参数，利用ajax访问后台
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#exceptionTaskTable'
                ,url: '/ControlManager/comprehensiveController/haveSelExeception' //数据接口
                ,where:{"sel_1":sel_1}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[ //表头
                    {field:'id', title: 'ID', width:'10%', sort: true,align:'center'}
                    ,{field:'jgxtlb', title: '交管系统类别', width:'20%',align:'center'}
                    ,{field:'jobname', title: '任务名', width:'20%',align:'center'}
                    ,{field:'desciption', title: '描述', width:'25%',align:'center'}
                    ,{field:'createtime', title: '时间', width:'25%',align:'center',templet:function(d){
                            return timestampToTime(d.createtime);
                        }}
                ]]
            });
        })
    }
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = date.getDate() + ' ';
    var h = date.getHours() + ':';
    var m = date.getMinutes() + ':';
    var s = date.getSeconds();
    return Y+M+D+h+m+s;
}

