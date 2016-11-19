<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="resource/css/bootstrap.min.css" rel="stylesheet">
 <link href="resource/css/jquery-confirm.css" rel="stylesheet">
  <link href="resource/css/nodeInfo.css" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
  <script src="resource/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="resource/js/jquery-confirm.js"></script>
</head>
<body>
<button type="button" class="btn btn-success" onclick="show()">提示框</button>
 
<script type="text/javascript">
	function show(){
		$.alert({
            title: 'success',
            content: '恭喜，注册成功！',
            icon: 'fa fa-rocket',
            animation: 'zoom',
            closeAnimation: 'zoom',
            buttons: {
                okay: {
                    text: 'Okay',
                    btnClass: 'btn-primary'
                }
            }
        });
	} 

</script>
</body>
</html>