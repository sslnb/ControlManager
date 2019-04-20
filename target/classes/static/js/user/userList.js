$(document).ready(function (){
    tables();
});

function tables() {
    /*table渲染*/
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#userTable'
            ,url: '/ControlManager/userController/selAllUserInfo'    //controller
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,groups:3
            ,cols: [[ //表头
                {field: 'userId', title: 'ID',width:'20%', align:'center', sort: true}
                ,{field: 'userCode', title: '用户名',width:'20%',align:'center'}
                ,{field: 'userRole', title: '角色',width:'30%',align:'center',templet:function(d){
                    if (d.userRole=="1"){
                        return "管理员"
                    }else {
                        return "普通用户"
                    }
                    }}
                ,{field: 'createTime', title: '创建时间',hide:true}
                ,{field: 'operate', title: '操作',width:'30%',toolbar:'#barDemo',align:'center',templet:'#barDemo'}
            ]]
        });
    });
}

layui.use('table', function(){
    var table = layui.table;

    var $ = layui.$, active = {
        reload: function () {
            var demoReload = $('#selName').val();
            //执行重载
            table.reload('selUserInfo', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    key: {
                        userCode: demoReload
                    }
                }
            });
        }
    };

    //监听工具条
    table.on('tool(userEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    var tr = obj.tr; //获得当前行 tr 的DOM对象
    if(layEvent === 'detail'){ //查看
        //do somehing
        layer.open({
            type: 1 //Page层类型
            ,closeBtn :1   //关闭按钮
            ,area: ['510px', '250px']
            ,title: '用户信息'
            ,Boolean:false
            ,shade: 0.6 //遮罩透明度
            ,maxmin: false //允许全屏最小化
            ,anim: 0 //0-6的动画形式，-1不开启
            ,content: '<table class="layui-table" style="margin-left: 10px;margin-right:10px;margin-top:20px;width: 490px;line-height: 40px">\n' +
            '    <tbody>\n' +
            '    <tr>\n' +
            '        <td>ID</td>\n' +
            '        <td>'+data.userId+'</td>\n' +
            '    </tr>\n' +
            '    <tr>\n' +
            '        <td>用户名</td>\n' +
            '        <td>'+data.userCode+'</td>\n' +
            '    </tr>\n' +
            '    <tr>\n' +
            '        <td>用户角色</td>\n' +
            '        <td>'+ data.userRole+'</td>\n' +
            '    </tr>\n' +
            '    <tr>\n' +
            '        <td>创建时间</td>\n' +
            '        <td>'+ timestampToTime(data.createTime)+'</td>\n' +
            '    </tr>\n' +
            '    </tbody>\n' +
            '</table>'
            ,cancel:function () {
                return true; // 开启该代码可禁止点击该按钮关闭
            }
        });
    } else if(layEvent === 'del'){ //删除
        layer.confirm('真的删除用户\n['+data.userCode+']\n么?',{btn:["确定","取消"]}
            ,function(){
                //向后端请求删除命令
                var userId = data.userId;
                $.ajax({  // ajax登陆请求
                    url: "/ControlManager/userController/delUser",
                    type: "post",
                    data: {"userId": userId},
                    dataType: "json",
                    async: true,
                    success: function (data) {
                        /!* 接收后台传输标识,判定登陆信息     	后面可能会添加备案的操作*!/
                        if (data.del == "true") {
                            /!* 成功 *!/
                            layer.msg("删除成功...",{icon:1,time:1500});
                            tables();
                        }else if(data.del == "noAdmain"){
                            layer.msg("您权限不足，请联系管理员进行删除...")
                        }  else {
                            /!* 失败 *!/
                            layer.msg("发生某种错误,删除失败...",{icon:1,time:2000})
                        }
                    },error: function(XMLHttpRequest, textStatus, errorThrown){
                        alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
                        location.href = "templates/page/500";
                    }
                });
            }
            ,function () {
                return;
            });
    }
});
});

//新增按钮
function  addUser() {
    layer.open({
        type: 1 //Page层类型
        ,closeBtn :1   //关闭按钮
        ,area: ['510px', '310px']
        ,title: '添加新用户'
        ,id: 'addTip'
        ,Boolean:false
        ,shade: 0.6 //遮罩透明度
        ,maxmin: false //允许全屏最小化
        ,anim: 0 //0-6的动画形式，-1不开启
        ,content: '<form class="layui-form" id="FilingForm" action="" method="post" style="margin-top: 30px;margin-left: 20px;margin-right: 50px">\n' +
            '      <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">账号：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '          <input type="text" id="userCode" name="title1" lay-verify="title" autocomplete="out" placeholder="请输入账号..." class="layui-input">\n' +
            '        </div>\n' +
            '      </div>\n' +
            '      <div class="layui-form-item">\n' +
            '        <label class="layui-form-label">密码：</label>\n' +
            '        <div class="layui-input-block">\n' +
            '          <input type="password" id="userPass" name="title2" lay-verify="title" autocomplete="off" placeholder="请输入密码..." class="layui-input">\n' +
            '        </div>\n' +
            '      </div>\n' +
            '      <div class="layui-form-item" style="margin-top: 15px">\n' +
            '        <div class="layui-input-block">\n' +
            '          <button onclick="addUserInfo()" type="button" class="layui-btn" >立即添加</button>\n' +
            '          <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
            '        </div>\n' +
            '      </div>\n' +
            '    </form>'
        ,cancel:function () {
            return true; // 开启该代码可禁止点击该按钮关闭
        }
    });
}

//新增用户
function addUserInfo() {
    var userCode = $("#userCode").val();
    var userPass = $("#userPass").val();
    if(userCode==""||userPass==""){
        /* 提示框用户名或密码为空 */
        layer.msg("请补全信息...",{icon:1,time:1500});
    }else {
        /*跳转后台添加方法,由后台判定是否有权限*/
        $.ajax({  // ajax登陆请求
            url: "/ControlManager/userController/addUser",
            type: "post",
            data: {"userCode": userCode, "userPass": userPass},
            dataType: "json",
            async: true,
            success: function (data1) {
                /!* 接收后台传输标识*!/
                if (data1.add == "true") {
                    /!* 成功 *!/
                    layer.closeAll('page'); //关闭所有页面层
                    tables();
                } else if(data1.add == "same"){
                    /!* 失败 *!/
                    layer.msg("存在同名用户,创建失败...",{icon:2,time:2000});
                    return;
                }else if (data1.add == "noAdmin"){
                    layer.msg("您权限不足，请联系管理员进行添加...",{icon:7,time:2000});
                } else{
                    layer.msg("发生某种错误,创建失败...",{icon:2,time:2000})
                    return;
                }
            },error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
                location.href = "templates/page/500";
            }
        });
    }
}

/*查询*/
function selUserInfo() {
    var selName = $("#selName").val();      //查询条件
    if (selName==""){
        layer.msg("重新渲染表格...")
        tables();
    }else{
        /*执行查询活动（预期使用ajax去后端查询  前端使用模态框弹出用户信息）
        * 后期断定为后端模糊查询,然后前端重新渲染信息
        * */
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#userTable'
                ,url: '/ControlManager/userController/selAllUserInfoByName'    //controller
                ,where:{"userCode":selName}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,groups:3
                ,cols: [[ //表头
                    {field: 'userId', title: 'ID',width:'20%', align:'center', sort: true}
                    ,{field: 'userCode', title: '用户名',width:'20%',align:'center'}
                    ,{field: 'userRole', title: '角色',width:'30%',align:'center',templet:function(d){
                            if (d.userRole=="1"){
                                return "管理员"
                            }else {
                                return "普通用户"
                            }
                        }}
                    ,{field: 'createTime', title: '创建时间',hide:true}
                    ,{field: 'operate', title: '操作',width:'30%',toolbar:'#barDemo',align:'center',templet:'#barDemo'}
                ]]
            });
        });
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