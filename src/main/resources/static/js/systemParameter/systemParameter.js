layui.config({
	base : "js/"
}).use(['form','layer','jquery','element'],function(){
	var form = layui.form,
        element = layui.element,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

    $(document).ready(function(){
        //异步请求后端 获取需要展示的信息(系统信息)
        $.ajax({
            type: "POST",
            url: "/ControlManager/sysController/selSysInfo",
            data: {},
            dataType: "json",
            success: function(data){
                //得到数据 放到页面进行展示
                //$("#sysVersion").html(data.sysArch);
                $("#cpu").html(data.cpu);
                $("#dev").html(data.dev);
                $("#sysRam").html(data.mem);
                $("#jvm").html(data.jvm);
                $("#swap").html(data.swap);


            }
        });
        $.ajax({
            type: "POST",
            url: "/ControlManager/sysController/sysMap",
            data: {},
            dataType: "json",
            success: function(data){
                //得到数据 放到页面进行展示
                $("#userName").html(data.userName);
                $("#computerName").html(data.computerName);
                $("#ip").html(data.ip);
                $("#jdkVersion").html(data.jdkVersion);
                $("#jdkPath").html(data.jdkPath);
                $("#osVersion").html(data.osVersion);
                $("#osName").html(data.osName);
                $("#osArch").html(data.osArch);
                $("#userPath").html(data.userPath);
            }
        });
    });


})
