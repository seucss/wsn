<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include flush="true" page="../navigation/navigation.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络联通度</title>
<!-- Bootstrap core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/tuoputu.css" rel="stylesheet">
    <link href="resource/css/nodeInfo.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    function start(){
		$.ajax( { 
		    url:'connectivityDegree.json',// 跳转到 controller 
		    type:'post', 
		    cache:false, 
		    data:{ 
	             orderType:'connectivityDegree'
	    	}, 
		    dataType:'json', 
		    async: false,
		    success:function(data) { 
		    	$.alert({
                    title: 'success!',
                    content: '成功',
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
		    }, 
		    error : function() { 
		    	alert("系统错误！");  
		     } 
		});
	}
    </script>
</head>
<body>
<div class="jumbotron">
 	<div class="container">
 		<div align="center">
 			<h2><span>网络联通度测试</span></h2>
 		</div>
 		<div class="pull-left">
 			<button type="button" class="btn btn-primary btn-lg" onclick="start()">开始测试</button>
 		</div>
 	</div>
</div>

<div class="container">
 	<fieldset>
 	<legend>测试结果列表</legend>
	 	<span>网络连通度:</span>&nbsp;&nbsp;&nbsp;<span id="connectivity_degree" class="bluea">0</span>
	 	<br>
	 	<div class="pull-right">
 		<button type="button" class="btn btn-warning btn-sm" onclick="">清空</button>
	 	</div>
	 	<table class="table table-bordered table-hover">
	  		<thead>
	            <tr>
	              <th>序号</th>
	              <th>测试次数</th>
	              <th>参与测试节点ID</th>
	              <th>是否收到该节点信息</th>
	            </tr>
	        </thead>
	        <tbody id="content">
	        </tbody>
		</table>
 	</fieldset>
 </div>
</body>
</html>