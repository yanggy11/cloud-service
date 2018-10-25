//引入http模块
var express = require('express');
var server = express()
//设置主机名
var hostName = '192.168.1.52';
//设置端口
var port = 1983;
//创建服务
server.all('*', function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.header("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
    res.header("X-Powered-By",' 3.2.1');
    res.header("Content-Type", "application/json;charset=utf-8");
    next();
});

server.get("/get",function(req,res){
    console.log("请求url：",req.path);
    console.log("请求参数：",req.query);
    res.send("这是get请求");
});

server.get("/", function (req, res) {
    res.send('home');
});

server.post("/post",function(req,res){
    console.log("请求参数：",req.body);
    var result = {code:200,msg:"post请求成功"};
    res.send(result);
});
server.listen(port, hostName, function () {
    console.log(`服务器运行在http://${hostName}:${port}`);
});


