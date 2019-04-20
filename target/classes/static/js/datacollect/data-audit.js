function auditTable(){
    layui.use("table",function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#dataAuditTable'
            ,url: '/ControlManager/comprehensiveController/selAllDdlsjsj' //数据接口
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,cols: [[ //表头
                {field: 'id', title: 'ID',width:'10%' , sort: true,align:'center'}
                ,{field: 'jgxtlb', title: '系统类别代码',width:'10%' ,align:'center'}
                ,{field: 'seq', title: 'sequerce号',width:'10%' ,align:'center'}
                ,{field: 'scn', title: 'scn号',width:'10%' ,align:'center'}
                ,{field: 'orauser', title: '数据库用户名',width:'15%' ,align:'center'}
                ,{field: 'oraschema', title: 'Schema对象名',width:'15%' ,align:'center'}
                ,{field: 'czlx', title: '操作类型',width:'10%' ,align:'center'}
                ,{field: 'dxlx', title: '操作对象类型',width:'10%' ,align:'center'}
                ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
            ]]
        });
    })
}

layui.use(['form', 'table'], function(){
    var table = layui.table
        ,form = layui.form
    auditTable();
    //监听工具条
    table.on('tool(dataAuditEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: []
                ,title: '数据审计'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<table class="layui-table"  style="margin-left: 10px;margin-right:10px;margin-top:20px;width: 480px;">\n' +
                    '    <tr>\n' +
                    '        <td>系统类别代码</td>\n' +
                    '         <td>'+data.jgxtlb+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>sequence号</td>\n' +
                    '         <td>'+data.seq+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>scn号</td>\n' +
                    '         <td>'+data.scn+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>数据库用户名</td>\n' +
                    '         <td>'+data.orauser+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>Schema对象名</td>\n' +
                    '         <td>'+data.oraschema+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>操作类型</td>\n' +
                    '         <td>'+data.czlx+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>操作对象类型</td>\n' +
                    '         <td>'+data.dxlx+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>DDL对象名</td>\n' +
                    '         <td>'+data.dxm+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>DDL操作时间</td>\n' +
                    '         <td>'+timestampToTime(data.czsj)+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>操作内容</td>\n' +
                    '         <td>'+data.nr+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>更新时间</td>\n' +
                    '         <td>'+timestampToTime(data.gxsj)+'</td>\n' +
                    '    </tr>\n' +

                    '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        } else if(layEvent === 'edit'){ //修改

        }
    });
});

/*查询函数*/
function selInfos(){
    var sel_1 = $("#sel_1").val();
    var sel_2 = $("#sel_2").val();
    var sel_3 = $("#sel_3").val();
    if (sel_1==""&&sel_2==""&&sel_3==""){
        auditTable();
    } else if(sel_1!=""||sel_2!=""||sel_3!=""){
        layui.use("table",function () {
            var table = layui.table;
            table.render({
                elem: '#dataAuditTable'
                ,url: '/ControlManager/comprehensiveController/selDdlsjsjByParam' //数据接口
                ,where:{"param1":sel_1,"param2":sel_2,"param3":sel_3}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[ //表头
                    {field: 'id', title: 'ID',width:'10%' , sort: true,align:'center'}
                    ,{field: 'jgxtlb', title: '系统类别代码',width:'10%' ,align:'center'}
                    ,{field: 'seq', title: 'sequerce号',width:'10%' ,align:'center'}
                    ,{field: 'scn', title: 'scn号',width:'10%' ,align:'center'}
                    ,{field: 'orauser', title: '数据库用户名',width:'15%' ,align:'center'}
                    ,{field: 'oraschema', title: 'Schema对象名',width:'15%' ,align:'center'}
                    ,{field: 'czlx', title: '操作类型',width:'10%' ,align:'center'}
                    ,{field: 'dxlx', title: '操作对象类型',width:'10%' ,align:'center'}
                    ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
                ]]
            });
        })

    }

}

//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});
/*时间戳转化为日期格式*/
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
