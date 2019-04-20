/*table渲染*/
layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    table.render({
        elem: '#linkTable'
        ,url: '/ControlManager/baBhController/selAllBaBh' //数据接口
        ,page:true
        ,limit:5
        ,limits : [5,10,15]
        ,cols: [[ //表头
            {field: 'babh', title: '备案编号',width:'25%',align:'center'}
            ,{field: 'jkxlh', title: '接口序列号',width:'25%',align:'center'}
            ,{field: 'ip', title: '主备IP',width:'25%',align:'center'}
            ,{field: 'port', title: '端口',width:'25%',align:'center'}
            ,{field: 'time', title: '建立时间',width:'20%',hide:true,toolbar:'#barDemo'}
        ]]
    });
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

    /*格林威治时间转化日期*/
    function chGMT(gmtDate){
        var mydate = new Date(gmtDate);
        mydate.setHours(mydate.getHours() + 8);
        return mydate.format("yyyy-MM-dd hh:mm:ss");
    }


//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});