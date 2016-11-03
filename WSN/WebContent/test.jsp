<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery</title>
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('a').click(function(){
			alert("这是弹出的内容");
		});
	});
</script>
</head>
<body>
	<a href="#">点击弹出内容</a>
</body>
</html>