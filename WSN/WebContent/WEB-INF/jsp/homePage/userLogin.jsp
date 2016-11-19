<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="resource/icon/icon1.ico">
<title>物联网感知层安全测试系统</title>
<!-- Bootstrap core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/signin.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript">
    	function register(){
    		window.location.href="register.wsn"
    	}
    </script>
</head>
<body>
	<c:if test="${error=='true'}">
		<div class="alert alert-warning alert-dismissible" role="alert">
		 <span class="warning"><strong>Warning!</strong> 用户名或密码错误</span>
		</div>
	</c:if>
	 <div class="container">
      <form class="form-signin" role="form" action="login.wsn" method="post">
        <h3 class="form-signin-heading">登录</h3>
        <input type="userName" class="form-control" placeholder="userName" name="userName" id="userName" required autofocus>
        <input type="password" class="form-control" placeholder="password" name="pwd" id="password" required>
        <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        </div>
        <button class="btn btn-primary" type="submit">登录</button>
        <button type="button" class="btn btn-link" onclick="register()">注册</button>
      </form>
     </div> <!-- /container -->
     
</body>
</html>