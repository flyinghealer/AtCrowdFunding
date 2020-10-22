<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">
      <!-- el表达式中内置对象param可以直接获取地址栏中的参数 -->
	  <h1 style="color:red">${param.errorMsg}</h1>
      <form id="loginForm" action="dologin" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
		  <div class="form-group has-success has-feedback">
		  	<!--jquery可以通过id来获取输入框的值，而后台通过name属性来获取值  -->
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
		  </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
          <br>
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="reg.html">我要注册</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
    function dologin() {
    	//非空校验，需要注意表单即使不填，表单元素的值也不会为null,取值是空字符串
        var loginacct = $("#loginacct").val();
        if(loginacct==""){
        	//alert("用户登录账号不能为空");
        	layer.msg("用户登录账号不能为空",{time:1000,icon:5,shift:6},function(){
        		
        	});
        	return;
        }
        var userpswd = $("#userpswd").val();
        if(userpswd==""){
        	//alert("用户登录密码不能为空");
        	layer.msg("用户登录密码不能为空",{time:1000,icon:5,shift:6},function(){
        		
        	});
        	return;
        }
        //$("#loginForm").submit();//也就是不使用直接提交表单的方式了，也就不会发送url:dologin请求了（form表单中添加了action属性），而是使用下面的ajax方式，url为doAJAXLogin
        //JS中使用var定义的变量就是局部变量，不使用var定义的变量就是全局变量
        var loadingIndex = null;
        $.ajax({
        	type:"POST",
        	url:"doAJAXLogin",
        	data:{
        		"loginacct":loginacct,
        		"userpswd":userpswd
        	},
        	beforeSend:function(){
        		loadingIndex = layer.msg('处理中',{icon:16});
        	},
        	success:function(result){
        		layer.close(loadingIndex);
        		if(result.success){
        			window.location.href="main";
        		}else{
        			layer.msg("用户登录账号或密码不正确",{time:1000,icon:5,shift:6},function(){
                		
                	});
        		}
        	}
        });
        
    }
    </script>
  </body>
</html>


