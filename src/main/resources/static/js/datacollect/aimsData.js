function tablesAims(){
    layui.use(['form', 'table','element'], function(){
        var table = layui.table
            ,form = layui.form
            ,element = layui.element
        //第一个实例
        table.render({
            elem: '#aimsDataTable'
            ,url: '/ControlManager/dbconProController/list' //数据接口
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,groups:3
            ,cols: [[ //表头
                {field: 'ip', title: 'IP地址',width:'20%' ,align:'center'}
                ,{field: 'jgxtlb', title: '系统类别代码',width:'10%' ,align:'center'}
                ,{field: 'sid', title: 'SID',width:'10%' ,align:'center'}
                ,{field: 'servicename', title: '服务名' ,align:'center',align:'center',hide:true}
                ,{field: 'port', title: '端口',align:'center',hide:true}
                ,{field: 'azdm', title: '安管系统代码' ,width:'15%'}
                ,{field: 'username', title: '用户名',align:'center',width:'15%'}
                ,{field: 'password', title: '密码',align:'center',hide:true}
                ,{field: 'agentype', title: 'Agent个数',align:'center',width:'10%'}
                ,{field: 'operate', title: '操作',width:'20%',toolbar:'#barDemo',align:'center'}
            ]]
        });
    })
}

/*table渲染*/
layui.use(['form', 'table','element','laydate'], function(){
    var table = layui.table
        ,form = layui.form
        ,element = layui.element
        ,laydate = layui.laydate;
    tablesAims();
    //监听工具条
    table.on('tool(aimsDataEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: ['40%','85%']
                ,title: '目标数据库'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<table class="layui-table"  style="margin-left: 10px;margin-right:10px;margin-top:20px;width: 480px;">\n' +
                '    <tr>\n' +
                '        <td>ip地址</td>\n' +
                '         <td>'+data.ip+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>系统类别代码</td>\n' +
                '         <td>'+data.jgxtlb+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>SID</td>\n' +
                '         <td>'+data.sid+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>端口</td>\n' +
                '         <td>'+data.port+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>服务名</td>\n' +
                '         <td>'+data.servicename+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>安管系统代码</td>\n' +
                '         <td>'+data.azdm+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>schema</td>\n' +
                '         <td>'+data.schema+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>Agent个数</td>\n' +
                '         <td>'+data.agentype+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>时间</td>\n' +
                '         <td>'+timestampToTime(data.startepoch)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '    <tr>\n' +
                '        <td>用户名</td>\n' +
                '         <td>'+data.username+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>密码</td>\n' +
                '         <td>'+data.password+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        } else if(layEvent === 'edit'){ //修改
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: ['750px', '85%']
                ,title: '修改连接信息'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<div class="layui-container layui-fluid " style="width: 650px" >\n' +
                '    <form class="layui-form" id="updAimsData" lay-filter="updAimsData" action="/ControlManager/dbconProController/insAimsData"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">系统类别代码:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="jgxtlb" lay-verify="required" placeholder="请输入系统类别代码..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">SID:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="sid" lay-verify="required" placeholder="请输入sid..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">IP地址:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="ip" lay-verify="required" placeholder="请输入Ip地址..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">端口:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="port" lay-verify="required" placeholder="请输入端口号..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">服务名</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="servicename" placeholder="请输入servicename..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">安管系统代码:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="azdm" lay-verify="required" placeholder="请输入azdm..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">schema:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="schema" lay-verify="required" placeholder="请输入schema..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">Agent个数:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="agentype" lay-verify="required" placeholder="请输入配置的Agent个数..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">用户名:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="username" lay-verify="required" placeholder="请输入用户名..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">密码:</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="text" name="password" lay-verify="required" placeholder="请输入密码..." autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <div class="layui-input-block">\n' +
                '                <button class="layui-btn" lay-submit lay-filter="updAimsData">立即提交</button>\n' +
                '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </form>\n' +
                '</div>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
            //日期
            laydate.render({
                elem: '#dateValue2'
                ,type: 'datetime'
            });
            //表单赋初始值
            form.val("updAimsData", {
                "jgxtlb":data.jgxtlb
                ,"ip":data.ip
                ,"sid":data.sid
                ,"port":data.port
                ,"servicename":data.servicename
                ,"azdm":data.azdm
                ,"username":data.username
                ,"password": data.password
                ,"syljas": data.syljas
                ,"startepoch": timestampToTime(data.startepoch)
                ,"agentype": data.agentype
                ,"schema": data.schema
                ,"id":data.id
            })

            //监听表单提交(编辑)
            form.on('submit(updAimsData)', function(data){
                $.ajax({
                    type: "POST",
                    url: "/ControlManager/dbconProController/updAimsData",
                    data: {"jgxtlb":data.field.jgxtlb,
                        "Ip": data.field.ip,
                        "sid": data.field.sid,
                        "azdm": data.field.azdm,
                        "servicename": data.field.servicename,
                        "schema": data.field.schema,
                        "agentype": data.field.agentype,
                        "password":data.field.password,
                        "port":data.field.port,
                        "username":data.field.username,
                    },
                    dataType: "json",
                    success: function (data) {
                        //得到数据 放到页面进行展示
                        /*$("#sysVersion").html(data.versions);*/
                        if (data.judge=="true"){
                            layer.closeAll('page'); //关闭所有页面层
                            tablesAims();
                        } else{
                            layui.msg("发生某种异常,修改失败...")
                        }
                    },error: function(XMLHttpRequest, textStatus, errorThrown){
                        alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);

                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }
    });
});

//添加配置信息
function addInfo(){
    layui.use(['form', 'table','element','laydate'], function() {
        var table = layui.table
            , form = layui.form
            , element = layui.element
            , laydate = layui.laydate;

        layer.open({
            type: 1 //Page层类型
            ,area: ['75%','80%']
            ,title: '新增目标数据库配置'
            ,Boolean:false
            ,shade: 0.6 //遮罩透明度
            ,maxmin: false //允许全屏最小化
            ,anim: 0 //0-6的动画形式，-1不开启
            ,content: '<div class="layui-container layui-fluid " >\n' +
            '    <form class="layui-form" id="addAimsData" lay-filter="addAimsData" action="/ControlManager/dbconProController/insAimsData"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->\n' +
            '        <div class="layui-form-item" style="margin-top: 10px">\n' +
            '            <label class="layui-form-label">系统类别代码:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="jgxtlb" lay-verify="required" placeholder="请输入系统类别代码..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">SID:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="sid" lay-verify="required" placeholder="请输入sid..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">IP地址:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="ip" lay-verify="required" placeholder="请输入Ip地址..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">端口:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="port" lay-verify="required" placeholder="请输入端口号..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">服务名</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="servicename" placeholder="请输入servicename..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">安管系统代码:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="azdm" lay-verify="required" placeholder="请输入azdm..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">schema:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="schema" lay-verify="required" placeholder="请输入schema..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">用户名:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="username" lay-verify="required" placeholder="请输入用户名..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">密码:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input type="text" name="password" lay-verify="required" placeholder="请输入密码..." autocomplete="off" class="layui-input">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="layui-form-item">\n' +
            '            <label class="layui-form-label">时间:</label>\n' +
            '            <div class="layui-input-block">\n' +
            '                <input name="startepoch" class="layui-input" id="dateValue" type="text" autocomplete="off" placeholder="所传归档时间范围...">\n' +
            '            </div>\n' +
            '        </div>\n' +
            /*<div class="layui-inline">
            <label class="layui-form-label">日期选择</label>
            <div class="layui-input-block">
            <input name="startepoch" class="layui-input" id="date1" type="text" autocomplete="off">
            </div>
            </div>*/
            '        <div class="layui-form-item">\n' +
            '            <div class="layui-input-block">\n' +
            '                <button class="layui-btn" lay-submit lay-filter="addAimsData">立即提交</button>\n' +
            '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </form>\n' +
            '</div>'
            ,cancel:function () {
                return true; // 开启该代码可禁止点击该按钮关闭
            }
        });
        //日期
        laydate.render({
            elem: '#dateValue'
            ,type: 'datetime'
        });
        layui.use('form', function(){
            var form = layui.form

            //监听表单提交
            form.on('submit(addAimsData)', function(data){
                $.ajax({
                    type: "POST",
                    url: "/ControlManager/dbconProController/insAimsData",
                    data: {"jgxtlb":data.field.jgxtlb,
                        "Ip": data.field.ip,
                        "sid": data.field.sid,
                        "azdm": data.field.azdm,
                        "servicename": data.field.servicename,
                        "schema": data.field.schema,
                        "startepoch": data.field.startepoch,
                        "password":data.field.password,
                        "port":data.field.port,
                        "username":data.field.username,
                    },
                    dataType: "json",
                    success: function (data) {
                        //得到数据 放到页面进行展示
                        /*$("#sysVersion").html(data.versions);*/
                        if (data.judge=="true"){
                            layer.closeAll('page'); //关闭所有页面层
                            tablesAims();
                        } else{
                            layui.msg("发生某种异常,添加失败...")
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        });
    });


}

/*查询函数*/
function selInfos(){
    var sel_1 = $("#sel_1").val();
    var sel_2 = $("#sel_2").val();
    if (sel_1==""&&sel_2==""){
        tablesAims();
    } else if(sel_1!=""||sel_2!=""){
        layui.use(['form', 'table','element'], function(){
            var table = layui.table
                ,form = layui.form
                ,element = layui.element
            //第一个实例
            table.render({
                elem: '#aimsDataTable'
                ,url: '/ControlManager/dbconProController/selAimsDataByParam' //数据接口
                ,where:{"param1":sel_1,"param2":sel_2}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,groups:3
                ,cols: [[ //表头
                    {field: 'ip', title: 'IP地址',width:'20%' ,align:'center'}
                    ,{field: 'jgxtlb', title: '系统类别代码',width:'10%' ,align:'center'}
                    ,{field: 'sid', title: 'SID',width:'10%' ,align:'center'}
                    ,{field: 'servicename', title: '服务名' ,align:'center',align:'center',hide:true}
                    ,{field: 'port', title: '端口',align:'center',hide:true}
                    ,{field: 'azdm', title: '安管系统代码' ,width:'15%'}
                    ,{field: 'username', title: '用户名',align:'center',width:'15%'}
                    ,{field: 'password', title: '密码',align:'center',hide:true}
                    ,{field: 'agentype', title: 'Agent个数',align:'center',width:'10%'}
                    ,{field: 'operate', title: '操作',width:'20%',toolbar:'#barDemo',align:'center'}
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
