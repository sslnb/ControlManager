function stockTable(){
    layui.use("table",function () {
        var table = layui.table;
        table.render({
            elem: '#stockTable'
            ,url: '/ControlManager/comprehensiveController/selAllClsjclzt'
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,cols: [[ //表头
                {field: 'jgxtlb', title: '系统类别代码',width:'15%' ,align:'center'}
                ,{field: 'bm', title: '表名',width:'15%' ,align:'center'}
                ,{field: 'cjzt', title: '采集状态',width:'15%' ,align:'center'}
                ,{field: 'sjzl', title: '数据总量',width:'15%' ,align:'center'}
                ,{field: 'cjsjzl', title: '采集数据总量',width:'15%' ,align:'center'}
                ,{field: 'cjwjs', title: '已采集文件数',width:'15%' ,align:'center'}
                ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
            ]]
        });
    })
}
/*table渲染*/
layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    stockTable();
    //监听工具条
    table.on('tool(stockEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: ['40%','90%']
                ,title: '存量数据'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<table class="layui-table" style="margin-left: 10px;margin-right:10px;margin-top:20px;margin-bottom20px;width: 490px;line-height: 40px">\n' +
                    '    <tbody>\n' +
                '    <tr>\n' +
                '        <td>系统类别代码</td>\n' +
                '        <td>'+data.jgxtlb+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>表名</td>\n' +
                '        <td>'+ data.bm+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>初次启动时间</td>\n' +
                '        <td>'+timestampToTime(data.ccqdsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>最近启动时间</td>\n' +
                '        <td>'+timestampToTime(data.zjqdsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>数据总量</td>\n' +
                '        <td>'+ data.sjzl+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>已采集数据总量</td>\n' +
                '        <td>'+data.cjsjzl+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>已采集文件数</td>\n' +
                '        <td>'+data.cjwjs+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>入库状态</td>\n' +
                '        <td>'+data.rkzt+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>更新时间</td>\n' +
                '        <td>'+timestampToTime(data.gxsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>采集完成时间</td>\n' +
                '        <td>'+undefinedZH(data.sjwcsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>最后一个文件名</td>\n' +
                '        <td>'+data.zhwjm+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>入库完成时间</td>\n' +
                '        <td>'+ undefinedZH(data.rkwcsj)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>已入库数据总量</td>\n' +
                '        <td>'+undefinedZH(data.pkwjs)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>已入库文件数</td>\n' +
                '        <td>'+undefinedZH(data.yrkwjs)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>错误信息描述</td>\n' +
                '        <td>'+undefinedZH(data.swxxms)+'</td>\n' +
                '    </tr>\n' +
                    '    </tbody>\n' +
                    '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        }
    });
});


/*查询函数*/
function selInfos(){
    var sel_1 = $("#sel_1").val();
    var sel_2 = $("#sel_2").val();
    if (sel_1==""&&sel_2==""){
        stockTable();
    } else if(sel_1!=""||sel_2!=""){
        layui.use("table",function () {
            var table = layui.table;
            table.render({
                elem: '#stockTable'
                ,url: '/ControlManager/comprehensiveController/selClsjclztByParam'
                ,where:{"param1":sel_1,"param2":sel_2}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[ //表头
                    {field: 'jgxtlb', title: '系统类别代码',width:'15%' ,align:'center'}
                    ,{field: 'bm', title: '表名',width:'15%' ,align:'center'}
                    ,{field: 'cjzt', title: '采集状态',width:'15%' ,align:'center'}
                    ,{field: 'sjzl', title: '数据总量',width:'15%' ,align:'center'}
                    ,{field: 'cjsjzl', title: '采集数据总量',width:'15%' ,align:'center'}
                    ,{field: 'cjwjs', title: '已采集文件数',width:'15%' ,align:'center'}
                    ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
                ]]
            });
        })
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
//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});