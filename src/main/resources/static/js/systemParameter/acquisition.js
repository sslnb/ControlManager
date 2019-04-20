function zlFileTables(){
    layui.use("table",function () {
        var table = layui.table;
        table.render({
            elem: '#zlFileTable'
            ,url: '/ControlManager/comprehensiveController/selAllzlsjwj'
            ,page:true
            ,limit:10
            ,limits : [10,15,20]
            ,cols: [[
                {field: 'id', title: 'ID', width:'10%', sort: true,align:'center'}
                ,{field:'jgxtlb', title: '系统类别代码', width:'15%',align:'center'}
                ,{field:'wjm', title: '文件名', width:'35%',align:'center'}
                ,{field:'md', title: 'MD5', width:'15%',align:'center'}
                ,{field:'wjdx', title: '文件大小', width:'15%',align:'center'}
                ,{field:'wjzt', title: '文件状态', width:'10%',align:'center'}
            ]],  done: function(res, curr, count){
                //layer.msg("数据加载完成...")
            }
            ,id: 'zlFileEvent'
        });
    })
}
function clFileTables(){
    layui.use("table",function () {
        var table = layui.table;
        table.render({
            elem: '#clFileTable'
            ,url: '/ControlManager/comprehensiveController/selAllclsjwj'
            ,page:true
            ,limit:10
            ,limits : [10,15,20]
            ,cols: [[
                {field: 'id', title: 'ID', width:'10%', sort: true,align:'center'}
                ,{field:'jgxtlb', title: '系统类别代码', width:'15%',align:'center'}
                ,{field:'bm', title: '表名', width:'15%',align:'center'}
                ,{field:'wjm', title: '文件名', width:'35%',align:'center'}
                ,{field:'wjdx', title: '文件大小', width:'15%',align:'center'}
                ,{field:'sjl', title: '数据量', width:'10%',align:'center'}
            ]],  done: function(res, curr, count){
                //layer.msg("数据加载完成...")
            }
            ,id: 'clFileEvent'
        });
    })
}

//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use(['table','element'], function(){
    var element = layui.element
    var table = layui.table;
    clFileTables();
    zlFileTables();
});