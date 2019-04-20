function fileTables(){
    layui.use("table",function () {
        var table = layui.table;
        table.render({
            elem: '#zlFileTable'
            ,url: '/ControlManager/comprehensiveController/selAllzlsjwj'
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,cols: [[
                {field:'jgxtlb', title: '系统类别代码', width:'15%',align:'center'}
                ,{field:'wjm', title: '文件名', width:'20%',align:'center'}
                ,{field:'md5', title: 'MD5', width:'20%',align:'center'}
                ,{field:'wjdx', title: '文件大小', width:'15%',align:'center'}
                ,{field:'wjzt', title: '文件状态', width:'15%',align:'center',templet:function(d){
                    if (d.wjzt=="1"){
                        return "已采集"
                    }else if(d.wjzt=="2"){
                        return "已上传"
                    }else if(d.wjzt=="3"){
                        return "上传部局"
                    }else if(d.wjzt=="4"){
                        return "入库"
                    }else if(d.wjzt=="5"){
                        return "重传"
                    }else {
                        return "本地"
                    }
                    }
                }
                ,{field: 'operate', title: '操作',width:'15%',toolbar:'#barDemo',align:'center',templet:'#barDemo'}
            ]],  done: function(res, curr, count){
                //layer.msg("数据加载完成...")
            }
            ,id: 'zlFileEvent'
        });
    })
}

layui.use("table",function () {
    var table = layui.table;
    fileTables();
    //监听工具条
    table.on('tool(zlFileEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: []
                ,title: '用户信息'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content: '<table class="layui-table" style="margin-left: 10px;margin-right:10px;margin-top:20px;width: 490px;line-height: 40px">\n' +
                '    <tbody>\n' +
                '    <tr>\n' +
                '        <td>系统类别代码</td>\n' +
                '        <td>'+data.jgxtlb+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>文件名</td>\n' +
                '        <td>'+ data.wjm+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>MD5</td>\n' +
                '        <td>'+data.md5+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>文件大小</td>\n' +
                '        <td>'+data.wjdx+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>文件状态</td>\n' +
                '        <td>'+fileStatus(data.wjzt)+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>Insert数据量</td>\n' +
                '        <td>'+data.sjlinsert+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>Updata数据量</td>\n' +
                '        <td>'+data.sjlupdate+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>Delete数据量</td>\n' +
                '        <td>'+ data.sjldelete+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>起始SCN</td>\n' +
                '        <td>'+data.scnq+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>结束SCN</td>\n' +
                '        <td>'+ data.scnz+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>生成时间</td>\n' +
                '        <td>'+timestampToTime(data.scsj)+'</td>\n' +
                '    </tr>\n' +
                '    </tbody>\n' +
                '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        }


    });
})


/*查询*/
function selInfos() {
    var sel_1 = $("#sel_1").val();      //查询条件
    if (sel_1==""){
        fileTables();
    }else{
        layui.use("table",function () {
            var table = layui.table;
            table.render({
                elem: '#zlFileTable'
                ,url: '/ControlManager/comprehensiveController/selzlsjwjByParam'
                ,where:{"param1":sel_1}
                ,page:true
                ,limit:5
                ,limits : [5,10,15]
                ,cols: [[
					{field:'jgxtlb', title: '系统类别代码', width:'15%',align:'center'}
					,{field:'wjm', title: '文件名', width:'20%',align:'center'}
					,{field:'md5', title: 'MD5', width:'20%',align:'center'}
					,{field:'wjdx', title: '文件大小', width:'15%',align:'center'}
					,{field:'wjzt', title: '文件状态', width:'15%',align:'center',templet:function(d){
					    if (d.wjzt=="1"){
					        return "已采集"
					    }else if(d.wjzt=="2"){
					        return "已上传"
					    }else if(d.wjzt=="3"){
					        return "上传部局"
					    }else if(d.wjzt=="4"){
					        return "入库"
					    }else if(d.wjzt=="5"){
					        return "重传"
					    }else {
					        return "本地"
					    }
					    }
					}
					,{field: 'operate', title: '操作',width:'15%',toolbar:'#barDemo',align:'center',templet:'#barDemo'}
                ]],  done: function(res, curr, count){
                    //layer.msg("数据加载完成...")
                }
                ,id: 'zlFileTable'
            });
        })
    }
}




/*用于修改文件状态信息的展示*/
function fileStatus(str){
	if (str=="1"){
		return "已采集"
	}else if(str=="2"){
		return "已上传"
	}else if(str=="3"){
		return "上传部局"
	}else if(str=="4"){
		return "入库"
	}else if(str=="5"){
		return "重传"
	}else {
		return "本地"
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