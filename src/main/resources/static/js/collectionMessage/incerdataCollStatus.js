//添加配置信息
function addInfo(){
    layer.open({
        type: 1 //Page层类型
        ,closeBtn :1   //关闭按钮
        ,area: ['510px', '400px']
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
            '        <label class="layui-form-label">名称：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '             <input type="text" id="title2" name="title2" lay-verify="title" autocomplete="off" placeholder="请输入参数2" class="layui-input">\n' +
            '        </div>\n' +
            '  </div>\n' +
            '    <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">状态：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '            <input type="text" id="title3" name="title1" lay-verify="title" autocomplete="off" placeholder="请输入参数1" class="layui-input">\n' +
            '        </div>\n' +
            '    </div>\n' +
            '    <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">参数4：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '            <input type="text" id="title4" name="title2" lay-verify="title" autocomplete="off" placeholder="请输入参数2" class="layui-input">\n' +
            '        </div>\n' +
            '    </div>\n' +
            '      <div class="layui-form-item" style="margin-top: 15px">\n' +
            '            <div class="layui-input-block">\n' +
            '                 <button onclick="addInfoBtn()" type="button" class="layui-btn" >立即添加</button>\n' +
            '                 <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
            '            </div>\n' +
            '      </div>\n' +
            '</form>\n'
        ,cancel:function () {
            /* layer.msg("该操作禁止关闭", {icon: 6})*/
            return true; // 开启该代码可禁止点击该按钮关闭
        }
    });
}

/*添加函数*/
function addInfoBtn(){
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
    if (sel_1==""&&sel_2==""&&sel_3==""){
        layer.msg("请输入要查询的参数")
    } else if(sel_1!=""||sel_2!=""||sel_3!=""){
        layer.msg("读取查询参数，利用ajax访问后台");
        //添加   使用ajax与后端进行交互
        $.ajax({
            url: "",	//路径为判定路径
            type: "post",
            data: {
                "sel_1": sel_1,
                "sel_2": sel_2,
                "sel_3": sel_3,
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