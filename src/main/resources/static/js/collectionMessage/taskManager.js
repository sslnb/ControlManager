layui.config({
    version: '1541881042991' //为了更新 js 缓存，可忽略
});
$(document).ready(function (){
    tables();
    setInterval(function (){
        //需要重复执行的函数
        tables();
        },10000);
});
/*表格渲染*/
function tables() {
    layui.use('table', function(){
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#taskEvent'
            ,url: '/ControlManager/jobController/selAllScheduleJob'
            ,page:true
            ,limit:5
            ,limits : [5,10,15]
            ,cols: [[
                { type:'checkbox',width:'5%'}
                ,{field:'id',width:'10%',title:'ID'}
                ,{field:'jobName', title: '任务名', width:'15%',align:'center'}
                ,{field:'jobGroup', title: '任务类别', width:'10%',align:'center'}
                ,{field:'jgxtlb', title: '交管系统类别', width:'10%',align:'center'}
                ,{field:'adzm', title: '安管系统代码', width:'10%',align:'center'}
                ,{field:'DESCRIPTION', title: '增量SCN/存量数据量', width:'15%',align:'center'}
                ,{field:'jobStatus', title: '状态', width:'10%',align:'center',templet:function (d) {
                        if (d.jobStatus=="COMPLETE"){
                            return "已完成";
                        } else if (d.jobStatus=="START") {
                            return "运行中";
                        } else if (d.jobStatus=="NORMAL"){
                            return "未运行"
                        } else if (d.jobStatus=="PAUSED"){
                            return "已停止"
                        }
                    }}
                ,{field: 'operate', title: '操作',width:'15%',toolbar:'#barDemo',align:'center',templet:'#barDemo'}
            ]],  done: function(res, curr, count){
                //layer.msg("数据加载完成...",{icon:1,time:1500})
            }
            ,id: 'testReload'
        });
    });
}

function pdStatus(num){
    if (num=="COMPLETE"){
        return "已完成";
    } else if (num=="START") {
        return "运行中";
    } else if (num=="NORMAL"){
        return "等待中任务调度"
    } else if (num=="PAUSED"){
        return "已停止"
    }
}

/*判断undefined*/
function undefinedZH(val) {
    if (val==undefined||val==null||val==""){
        return '空';
    }else{
        return val;
    }
}
layui.use('table', function() {
    var table = layui.table

    /*//监听表格复选框选择
    table.on('checkbox(taskEvent)', function(obj){
        console.log(obj)
    });*/

    //监听工具条
    table.on('tool(taskEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'get'){ //查看
            console.log(data);
            layer.open({
                type: 1 //Page层类型
                ,closeBtn :1   //关闭按钮
                ,area: []
                ,title: '任务信息'
                ,Boolean:false
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 0 //0-6的动画形式，-1不开启
                ,content:'<table class="layui-table" style="margin: 15px;width: 530px">\n' +
                    '    <tbody>\n' +
                    '    <tr>\n' +
                    '        <td>ID</td>\n' +
                    '        <td>'+ data.id +'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>任务名</td>\n' +
                    '        <td>'+data.jobName+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>任务类别</td>\n' +
                    '        <td>'+data.jobGroup+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>表名</td>\n' +
                    '        <td>'+undefinedZH(data.bm)+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>安管系统代码</td>\n' +
                    '        <td>'+undefinedZH(data.adzm)+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>交管系统类别</td>\n' +
                    '        <td>'+undefinedZH(data.jgxtlb)+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>pdtypename(data.jobGroup)</td>\n' +
                    '        <td>'+data.description+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>beanName</td>\n' +
                    '        <td>'+data.beanName+'</td>\n' +
                    '    </tr>\n' +
                    '    <tr>\n' +
                    '        <td>完成状态</td>\n' +
                    '        <td>'+pdStatus(data.jobStatus)+'</td>\n' +
                    '    </tr>\n' +
                    '    </tbody>\n' +
                    '</table>'
                ,cancel:function () {
                    return true; // 开启该代码可禁止点击该按钮关闭
                }
            });
        } else if(layEvent === 'start'){ //启动
            //获取jobname   jobgroup
            var jobName = data.jobName;
            var jobGroup = data.jobGroup;
            if (data.jobStatus=="START"||data.jobStatus=="COMPLETE"){
                layer.msg("任务正在执行或已完成,不可执行此操作...");
            }else{
                $.ajax({  // ajax登陆请求
                    url: "/ControlManager/jobController/runOneJob",
                    type: "post",
                    data: {"jobName": jobName,"jobGroup":jobGroup},
                    dataType: "json",
                    success: function (data) {
                        /!* 接收后台传输标识,*!/
                        if (data.jobpd == "true") {
                            /!* 成功 *!/
                            layer.msg("已执行...",{icon:1,time:1500});
                            tables();
                        }else if(data.jobpd == "false"){
                            layer.msg("执行失败...",{icon:1,time:1500});
                        }else{
                            layer.msg("发生某种异常...");
                        }
                    },error: function(XMLHttpRequest, textStatus, errorThrown){
                    	layer.msg("重采设置失败！");
                    }
                });
            }
        }else if (layEvent==='end'){    //停止
            //获取jobname   jobgroup
            var jobName = data.jobName;
            var jobGroup = data.jobGroup;
            if (data.jobStatus=="COMPLETE"||data.jobStatus=="PAUSED"||data.jobStatus=="NORMAL"){
                layer.msg("任务已完成或已停止或待运行,不可执行此操作...");
            }else{
                $.ajax({  // ajax登陆请求
                    url: "/ControlManager/jobController/pauseJob",
                    type: "post",
                    data: {"jobName": jobName,"jobGroup":jobGroup},
                    dataType: "json",
                    success: function (data) {
                        /!* 接收后台传输标识,*!/
                        if (data.jobpd == "true") {
                            /!* 成功 *!/
                            layer.msg("已执行...",{icon:1,time:1500});
                            tables();
                        }else if(data.jobpd == "false"){
                            layer.msg("执行失败...",{icon:1,time:1500});
                        }else{
                            layer.msg("发生某种异常...");
                        }
                    },error: function(XMLHttpRequest, textStatus, errorThrown){
                        alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
                        location.href = "templates/page/500";
                    }
                });
            }
        }else if (layEvent==='Retake'){
        	   layui.use(['laydate','table','form'],function () {
        	        var laydate = layui.laydate
        	            ,table = layui.table
        	            ,form = layui.form;

        	        layer.open({
        	            type: 1 //Page层类型
        	            , closeBtn: 1   //关闭按钮
        	            , area: []
        	            , title: '请选择时间点'
        	            , Boolean: false
        	            , shade: 0.6 //遮罩透明度
        	            , maxmin: false //允许全屏最小化
        	            , anim: 0 //0-6的动画形式，-1不开启
        	            , content: '<div class="layui-form" style="margin-right: 70px">\n' +
        	                '    <div class="layui-form-item" style="margin-top: 30px">\n' +
        	                '        <label class="layui-form-label">交管系统类别:</label>\n' +
        	                '        <div class="layui-input-inline">\n' +
        	                '            <input class="layui-input" type="text" id="jgxtlb" name="jgxtlb" placeholder="jgxtlb" disabled>\n' +
        	                '        </div>\n' +
        	                '    </div>\n' +
        	                '    <div class="layui-form-item" style="margin-top: 30px">\n' +
        	                '        <label class="layui-form-label">任务名:</label>\n' +
        	                '        <div class="layui-input-inline">\n' +
        	                '            <input class="layui-input" type="text" id="jobName" name="jgxtlb" placeholder="jobName" disabled>\n' +
        	                '        </div>\n' +
        	                '    </div>\n' +
        	                '    <div class="layui-form-item" style="margin-top: 30px">\n' +
        	                '        <label class="layui-form-label">任务组:</label>\n' +
        	                '        <div class="layui-input-inline">\n' +
        	                '            <input class="layui-input" type="text" id="jobGroup" name="jobGroup" placeholder="jobGroup" disabled>\n' +
        	                '        </div>\n' +
        	                '    </div>\n' +
        	                '    <div class="layui-form-item" style="margin-top: 30px">\n' +
        	                '        <label class="layui-form-label">时间选择:</label>\n' +
        	                '        <div class="layui-input-inline">\n' +
        	                '            <input type="text" class="layui-input" name="dataVals" id="dataVals" placeholder="请选择详细的时间点...">\n' +
        	                '        </div>\n' +
        	                '    </div>\n' +
        	                '    <div class="layui-form-item" style="margin-top: 30px;margin-bottom: 30px">\n' +
        	                '        <div class="layui-input-block">\n' +
        	                '            <button class="layui-btn" id="dataSubmit" type="button">立即提交</button>\n' +
        	                '        </div>\n' +
        	                '    </div>\n' +
        	                '</div>'
        	        });
        	        
        	      //渲染日期组件
        	        laydate.render({
        	            elem: '#dataVals'
        	            ,type: 'datetime'
        	            ,theme: '#393D49'
        	            ,min:-10
        	            ,max: 1 
        	        });
        	        $("#jgxtlb").val(data.jgxtlb);
        	        $("#jobGroup").val(data.jobGroup);
        	        $("#jobName").val(data.jobName);
        	        //选定完日期 提交按钮的事件
        	        $("#dataSubmit").click(function () {
        	            var jgxtlb = $("#jgxtlb").val();
        	            var dataVals = $("#dataVals").val();
        	            var jobName = $("#jobName").val();
        	            var jobGroup = $("#jobGroup").val();
        	            if(dataVals==null||dataVals==""){
        	                layer.msg("请选择增量任务开始采集的时间点...此时间点必须是所给归档包含的时间");
        	            }else{
        	                $.ajax({
        	                    type: "POST",		//POST_GET
        	                    url: "/ControlManager/jobController/retake",	//访问路径
        	                    data: {"jgxtlb":jgxtlb,"dataVals":dataVals,"jobName":jobName,"jobGroup":jobGroup},
        	                    dataType: "json",
        	                    success: function(data){
        	                    	if(data.code=="1"){
        	                    		tables();
        	                    		layer.msg("设置成功...");
        	                    	}else{
        	                    		layer.msg("重采失败...");
        	                    	}
        	                    },error: function(XMLHttpRequest, textStatus, errorThrown){
        	                        alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
        	                        location.href = "templates/page/500";
        	                    }
        	                });
        	            }
        	        });
        	   });
        	
        }
    });

    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload').val();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        jobId: demoReload
                    }
                }
            });
        }
        ,getCheckData: function(){ //批量启动
            var checkStatus = table.checkStatus('testReload')
                ,data = checkStatus.data;
            var jobList = new Array();
            var jobTwoList = new Array();
            for (var i = 0;i<data.length;i++){
               console.log(data[i]["jobName"]);
               console.log(data[i]["jobGroup"]);
               jobList[i]=data[i]["jobName"];
               jobTwoList[i]=data[i]["jobGroup"];
                if (data[i]["jobStatus"]=="NORMAL"){
                    layer.msg("选中任务包含已完成任务,禁止启动...")
                }else{
                    $.ajax({
                        type: "POST",
                        url: "/ControlManager/jobController/runListJob",
                        data: {'jobList': jobList, 'jobTwoList': jobTwoList},
                        dataType: "json",
                        success: function (data) {
                            if (data.jobPd=="true"){
                                //成功
                                tablesAims();
                            }else{
                                //失败
                                layer.msg("发生某种异常,批量启动失败...")
                            }
                        }
                    })
                }
            }

        }
        ,getCheckLength: function(){ //批量停止
            var checkStatus = table.checkStatus('testReload')
                ,data = checkStatus.data;
            var jobList = new Array();
            var jobTwoList = new Array();
            for (var i = 0;i<data.length;i++){
                console.log(data[i]["jobName"]);
                console.log(data[i]["jobGroup"]);
                jobList[i]=data[i]["jobName"];
                jobTwoList[i]=data[i]["jobGroup"];
                if (data[i]["jobStatus"]!="NORMAL"){
                    layer.msg("选中任务包含已完成任务,禁止停止...")
                }else{
                    $.ajax({
                        type: "POST",
                        url: "/ControlManager/jobController/pauseListJob",
                        data: {'jobList': jobList, 'jobTwoList': jobTwoList},
                        dataType: "json",
                        success: function (data) {
                            if (data.jobPd=="true"){
                                //成功
                                tablesAims();
                            }else{
                                //失败
                                layer.msg("发生某种异常,批量停止失败...")
                            }
                        }
                    })
                }
            }
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

})

function pdtypename(str) {
    if (str=="ZLTASK"){
        return "增量当前SCN"
    }
    else if (str=="CLTASK"){
        return "存量当前数据量"
    } else{
        return "其他类型";
    }
}

function ReloadTask() {
    tables();
}


