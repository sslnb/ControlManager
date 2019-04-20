layui.config({
	base : "/static/js/"
}).use(['form','layer'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
})



$(document).keyup(function(event){
    if(event.keyCode == 13){
        loginUser();
    }
});

/*登陆*/
function loginUser(){
    /* 获取用户名和密码并判定非空 */
    var userCode = $("#userCode").val();
    var userPass = $("#userPass").val();
    if(userCode==""||userPass==""){
        /* 提示框用户名或密码为空 */
        layer.msg("请补全登陆信息...");
        //layer.alert("....................")
    }else{
        $.ajax({  // ajax登陆请求
            url:"userController/loginUser",
            type:"post",
            data:{"userCode":userCode,"userPass":userPass},
            dataType:"json",
            success:function(data){
                /* 接收后台传输标识,判定登陆信息     	后面可能会添加备案的操作*/
                if(data.login=="true"){
                    //跳到  indexController
                    window.location.href = "index";
                }else{
                    /* 失败 */
                    layer.msg("用户名或密码错误,请重新输入");
                    $("#userCode").val("");
                    $("#userPass").val("");
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
            }

        });
    }
}
