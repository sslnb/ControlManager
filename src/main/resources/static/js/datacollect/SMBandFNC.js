/*table渲染*/
layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    table.render({
        elem: '#SMB_FNCTable'
        ,limit:5
        ,url: '' //数据接口
        ,page: false //开启分页
        ,cols: [[ //表头
            {field: 'SMBFNCId', title: 'ID',width:'10%' , sort: true,align:'center'}
            ,{field: 'sysTypeCode', title: '系统类别代码',width:'10%' ,align:'center'}
            ,{field: 'sharedName', title: '共享目录名称',width:'15%' ,align:'center'}
            ,{field: 'sharedIP', title: '共享目录IP',width:'15%' ,align:'center',hide:true}
            ,{field: 'sysType', title: '系统类型',width:'15%' ,align:'center',hide:true}
            ,{field: 'operate', title: '操作',width:'10%',toolbar:'#barDemo',align:'center'}
        ]]
    });
    //监听工具条
    table.on('tool(SMB_FNCEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: []   //可自定义宽高,不指定则由内容填充决定
                ,title: 'SMB_FNC'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content:  '<table class="layui-table"  style="margin-left: 10px;margin-right:10px;margin-top:20px;width: 480px;">\n' +
                    '    <tr>\n' +
                    '        <td>系统类别代码</td>\n' +
                    '         <td>'+data.sysTypeCode+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>共享目录名称</td>\n' +
                    '         <td>'+data.sharedName+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>共享目录IP</td>\n' +
                    '         <td>'+data.sharedIP+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>系统类型</td>\n' +
                    '         <td>'+data.sysType+'</td>\n' +
                    '    </tr>\n' +
                    '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        } else if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                /*ajax 后台传递 执行删除*/
                layer.msg("通过ajax,将ID"+data.exceptRecordingId+"传到后台进行操作")
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
            });
        }
    });
});

//添加配置信息
function addInfo(){
    layer.open({
        type: 1 //Page层类型
        ,closeBtn :1   //关闭按钮
        ,area: ['510px', '480px']
        ,title: '新增'
        ,Boolean:false
        ,shade: 0.6 //遮罩透明度
        ,maxmin: false //允许全屏最小化
        ,anim: 0 //0-6的动画形式，-1不开启
        ,content: '<form class="layui-form" id="FilingForm" action="404.html" method="post" style="margin-top: 30px;margin-left: 20px;margin-right: 50px">\n' +
            '  <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">系统类别代码：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '             <input type="text" id="title1" name="title1" lay-verify="title" autocomplete="off" placeholder="请输入参数1" class="layui-input">\n' +
            '           </div>\n' +
            '  </div>\n' +
            '  <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">共享目录名称：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '             <input type="text" id="title2" name="title2" lay-verify="title" autocomplete="off" placeholder="请输入参数2" class="layui-input">\n' +
            '        </div>\n' +
            '  </div>\n' +
            '    <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">共享目录IP：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '            <input type="text" id="title3" name="title1" lay-verify="title" autocomplete="off" placeholder="请输入参数1" class="layui-input">\n' +
            '        </div>\n' +
            '    </div>\n' +
            '    <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">系统类型：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '            <input type="text" id="title4" name="title2" lay-verify="title" autocomplete="off" placeholder="请输入参数2" class="layui-input">\n' +
            '        </div>\n' +
            '    </div>\n' +
            '    <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">协议类型：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '            <input type="text" id="title5" name="title1" lay-verify="title" autocomplete="off" placeholder="请输入参数1" class="layui-input">\n' +
            '        </div>\n' +
            '    </div>\n' +
            '      <div class="layui-form-item" style="margin-top: 20px">\n' +
            '            <div class="layui-input-block">\n' +
            '                 <button onclick="addInfoData()" type="button" class="layui-btn" >立即添加</button>\n' +
            '                 <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
            '            </div>\n' +
            '      </div>\n' +
            '</form>'
        ,cancel:function () {
            /* layer.msg("该操作禁止关闭", {icon: 6})*/
            return true; // 开启该代码可禁止点击该按钮关闭
        }
    });
}

/*添加函数*/
function addInfoData(){
    var title1 = $("#title1").val();
    var title2 = $("#title2").val();
    var title3 = $("#title3").val();
    var title4 = $("#title4").val();
    var title5 = $("#title5").val();
    if(title1==""||title2==""||title3==""||title4==""||title5==""){
        layer.msg("请补全信息")
    }else{
        //添加   使用ajax与后端进行交互
        $.ajax({
            url: "user/ifSuperUser",	//路径为判定路径 是否为管理员
            type: "post",
            data: {
                "title1": title1,
                "title2": title2,
                "title3": title3,
                "title4": title4,
                "title5": title5
            },
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.ifsuper == "true") {
                    /!* 接收后台传输标识,判定信息 *!/
                    layer.msg("成功");
                } else {
                    /!* 失败  *!/
                    layer.msg("出错！");
                }
            }
        })
    }
};

/*查询函数*/
function selInfos(){
    var sel_1 = $("#sel_1").val();
    var sel_2 = $("#sel_2").val();
    var sel_3 = $("#sel_3").val();
    var sel_4 = $("#sel_4").val();
    if (sel_1==""&&sel_2==""&&sel_3==""&&sel_4==""){
        layer.msg("请输入要查询的参数")
    } else if(sel_1!=""||sel_2!=""||sel_3!=""||sel_4!=""){
        layer.msg("读取查询参数，利用ajax访问后台");
        //添加   使用ajax与后端进行交互
        $.ajax({
            url: "",	//路径为判定路径
            type: "post",
            data: {
                "sel_1": sel_1,
                "sel_2": sel_2,
                "sel_3": sel_3,
                "sel_4": sel_4
            },
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.ifsuper == "true") {
                    /!* 接收后台传输标识,判定信息 *!/
                    layer.msg("成功");
                } else {
                    /!* 失败  *!/
                    layer.msg("出错！");
                }
            }
        })
    }

}

//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});