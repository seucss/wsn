<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="resource/icon/icon1.ico">
<title>物联网感知层安全测试系统</title>
<!-- Bootstrap core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/signin.css" rel="stylesheet">
</head>
<body>
	 <div class="container">
	 
      <form class="form-signin" role="form" action="login.wsn" method="post">
        <h3 class="form-signin-heading">登录</h3>
        <input type="userName" class="form-control" placeholder="userName" required autofocus>
        <input type="password" class="form-control" placeholder="password" required>
        <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        </div>
        <button class="btn btn-primary" type="submit">登录</button>
        <button type="button" class="btn btn-link">注册</button>
      </form>
      
     </div> <!-- /container -->
</body>
</html>