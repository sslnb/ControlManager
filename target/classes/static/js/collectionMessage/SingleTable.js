
/*刷新*/
function Reload() {
    tableSingTab();
}

/*将数据渲染放在函数中,方便数据改变后进行刷新*/
function tableSingTab(){
    layui.use('table',function () {
        var table = layui.table
        table.render({
            elem: '#singleTable'
            ,url: '/ControlManager/singleTableController/selAllSingleTable' //数据接口
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,cols: [[ //表头
                {field: 'id', title: 'ID',width:'10%' , sort: true,align:'center'}
                ,{field: 'bm', title: '表名',width:'16%' ,align:'center'}
                ,{field: 'jgxtlb', title: '系统类别代码',width:'16%' ,align:'center'}
                ,{field: 'clcjbj', title: '存量数据采集标记',width:'16%' ,align:'center'}
                ,{field: 'clwcbj', title: '存量采集完成标记',width:'16%' ,align:'center'}
                ,{field: 'bmms', title: '表名描述',width:'16%' ,align:'center'}
                ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
            ]]
        });
    })
}

/*table渲染*/
layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    tableSingTab();
    /*定时刷新*/
    setInterval(function (){
        tableSingTab();
    },5000);
    //监听工具条
    table.on('tool(singleEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: ['45%','90%']    //可自定宽高，eg：['550px','330px']
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
                '        <td>表名</td>\n' +
                '        <td>'+data.bm+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>系统类别代码</td>\n' +
                '        <td>'+data.jgxtlb+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>存量采集标记</td>\n' +
                '        <td>'+data.clcjbj+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>存量采集完成标记</td>\n' +
                '        <td>'+data.clwcbj+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>时间戳字段</td>\n' +
                '        <td>'+data.sjczd+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>存量数据起始日期</td>\n' +
                '        <td>'+timeNull(data.clqsrq)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>存量数据过滤条件</td>\n' +
                '        <td>'+ undefinedZH(data.clgltj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>增量客户端过滤类型</td>\n' +
                '        <td>'+undefinedZH(data.zlkhdgllxx)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>是否采集insert增量数据</td>\n' +
                '        <td>'+pdIUD(data.zlinsert)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>是否采集update增量数据</td>\n' +
                '        <td>'+pdIUD(data.zlupdate)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>是否采集delete增量数据</td>\n' +
                '        <td>'+ pdIUD(data.zldelete)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>策略创建时间</td>\n' +
                '        <td>'+timestampToTime(data.cjsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>策略更新时间</td>\n' +
                '        <td>'+timestampToTime(data.gxsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>clstatus</td>\n' +
                '        <td>'+undefinedZH(data.clstatus)+'</td>\n' +
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

function timeNull(val) {
    if (val==undefined){
        return '空';
    }else{
        return timestampToTime(val);
    }

}
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
function undefinedZH(val) {
    if (val==undefined){
        return '空';
    }
}

function pdIUD(val) {
    if (val==1){
        return '是';
    }else{
        return '否';
    }
}

function cjBJ(val) {
    if (val==0){
        return '未启动';
    }else if(val==1){
        return '正在执行';
    }else{
        return '已完成';
    }
}
/*查询函数*/
/*function selInfos(){
    var sel_1 = $("#sel_1").val();
    if (sel_1==""){
        tableSingTab();
    } else{
        //读取查询参数，利用ajax访问后台
        layui.use('table',function () {
            var table = layui.table
            table.render({
                elem: '#singleTable'
                ,url: '/ControlManager/singleTableController/selSingTabByParam' //数据接口
                ,where:{"param1":sel_1}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[ //表头
                    {field: 'id', title: 'ID',width:'10%' , sort: true,align:'center'}
                    ,{field: 'bm', title: 'bm',width:'16%' ,align:'center'}
                    ,{field: 'jgxtlb', title: 'jgxtlb',width:'16%' ,align:'center'}
                    ,{field: 'clcjbj', title: 'clcjbj',width:'16%' ,align:'center'}
                    ,{field: 'clwcbj', title: 'clwcbj',width:'16%' ,align:'center'}
                    ,{field: 'bmms', title: 'bmms',width:'16%' ,align:'center'}
                    ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
                ]]
            });
        })
    }

}*/

function dataSubmit(){
    var timeValues = $("#city").val();
    layer.msg(timeValues);
    if (timeValues==0){
        layer.msg("请在下拉框中选择时间...")
    } else{
        //layer.msg("√");
        $.ajax({
            type: "POST",		//POST_GET
            url: "/ControlManager/logParameterController/alterZLMRCJZQ",	//访问路径
            data: {"timeValues": timeValues},
            dataType: "json",
            success: function (data) {
                alert("修改成功");
            },error: function(XMLHttpRequest, textStatus, errorThrown){
            	alert("修改失败");
            }
        });
    }
}



//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});