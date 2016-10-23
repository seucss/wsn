<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table width="80%" align="center">
		<tr>
			<td>姓名</td>
			<td>密码</td>
			<td>注册日期</td>
			<td>在线</td>
		</tr>
		<c:forEach items="${list}" var="bean">
			<tr>
				<td>${bean.userName}</td>
				<td>${bean.pwd}</td>
				<td>${bean.registerDate}</td>
				<td>${bean.onLine}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>