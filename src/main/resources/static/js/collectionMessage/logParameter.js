
$(document).ready(function(){
    //do something
    tableLogParameter();
});

/*将数据渲染放在函数中,方便数据改变后进行刷新*/
function tableLogParameter(){
    layui.use('table',function () {
        var table = layui.table;
        table.render({
            elem: '#logTable'
            ,url: '/ControlManager/logParameterController/selAllRzcjqjcs' //数据接口
            ,page:true
            ,limit:10
            ,limits : [10,15,20]
            ,cols: [[ //表头
                {type: 'numbers', title: 'ID',width:'10%' , sort: true,align:'center'}
                ,{field: 'gjz', title: '关键字',width:'30%' ,align:'center'}
                ,{field: 'csmc', title: '参数名称',width:'30%' ,align:'center'}
                ,{field: 'mrz', title: '默认值',width:'30%' ,align:'center'}
            ]]
        });
    })
}
/*table渲染*/
layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    tableLogParameter();
    //监听工具条
    table.on('tool(logEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: []
                ,title: '参数信息'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<table class="layui-table" style="margin-left: 10px;margin-right:10px;margin-top:20px;margin-bottom20px;width: 490px;line-height: 40px">\n' +
                    '    <tbody>\n' +
                    '    <tr>\n' +
                    '        <td>ID</td>\n' +
                    '        <td>'+data.id+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>关键字</td>\n' +
                    '        <td>'+data.gjz+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>参数名称</td>\n' +
                    '        <td>'+data.csmc+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>默认值</td>\n' +
                    '        <td>'+ data.mrz+'</td>\n' +
                    '    </tr>\n' +
                    '    </tbody>\n' +
                    '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        } else if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                /*ajax 后台传递 执行删除*/
                layer.msg("通过ajax,将ID"+data.usersId+"传到后台进行操作")
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
            });
        }
    });
});


/*查询函数*/
function selInfos(){
    var sel_1 = $("#sel_1").val();
    if (sel_1==""){
        tableLogParameter()
    } else{
        //读取查询参数，利用ajax访问后台
        layui.use(['form', 'table','element'], function(){
            var table = layui.table
                ,form = layui.form
                ,element = layui.element
            //第一个实例
            table.render({
                elem: '#logTable'
                ,limit:5
                ,url: '/ControlManager/logParameterController/selRzcjqjcsByParam' //数据接口
                ,where:{"param1":sel_1}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[ //表头
                    {type: 'numbers', title: 'ID',width:'10%' ,align:'center'}
                    ,{field: 'gjz', title: '关键字',width:'30%' ,align:'center'}
                    ,{field: 'csmc', title: '参数名称',width:'30%' ,align:'center'}
                    ,{field: 'mrz', title: '默认值',width:'30%' ,align:'center'}
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