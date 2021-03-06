<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include flush="true" page="../navigation/navigation.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平均路径长度</title>
<!-- Bootstrap core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/tuoputu.css" rel="stylesheet">
    <link href="resource/css/nodeInfo.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
     <script type="text/javascript">
    	function show(){
    		$('#myModal').modal();
    	}
    	
    	function start(){
    		$.ajax( { 
			    url:'averagePathLength.json',// 跳转到 controller 
			    type:'post', 
			    cache:false, 
			    data:{ 
		             orderType:'averagePathLength'
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
	<!-- 隐藏修改节点信息窗口 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
     <h4 class="modal-title" id="myModalLabel">网络平均路径长度测试参数</h4>
    </div>
    <div class="modal-body">
    <div class="form-group">
      <label for="cycle_length">周期长度（秒）</label><span class="bluea" id="span_cycle_length">每个测试周期所经历的时间，以秒为单位，范围[1-180]</span>
      <input type="text" class="form-control" id="cycle_length" >
     </div>
     <div class="form-group">
      <label for="cycle_number">测试周期数（个）</label><span class="bluea" id="span_cycle_number">测试周期的个数，范围[1-10]</span>
      <input type="text" class="form-control" id="cycle_number" >
     </div>
     <div class="form-group">
      <label for="cycle_interval">周期间隔（秒）</label><span class="bluea" id="span_cycle_interval">相邻两周期的时间，以秒为单位，范围[1-120]</span>
      <input type="text" class="form-control" id="cycle_interval" >
     </div>
    </div>
    <div class="modal-footer">
     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
     <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal" onclick="start()">测试开始</button>
    </div>
   </div>
  </div>
 </div>
 
 <div class="jumbotron">
 	<div class="container">
 		<div align="center">
 			<h2><span>网络平均路径长度测试</span></h2>
 		</div>
 		<div class="pull-left">
 			<button type="button" class="btn btn-primary btn-lg" onclick="show()">参数设置</button>
 		</div>
 	</div>
 </div>
 
  <div class="container">
 	<fieldset>
 	<legend>测试结果列表</legend>
	 	<span>网络平均路径长度(跳):</span>&nbsp;&nbsp;&nbsp;<span id="average_path_length" class="bluea">0</span>
	 	<br>
	 	<div class="pull-right">
 		<button type="button" class="btn btn-warning btn-sm" onclick="">清空</button>
	 	</div>
	 	<table class="table table-bordered table-hover">
	  		<thead>
	            <tr>
	              <th>序号</th>
	              <th>测试次数</th>
	              <th>普通节点ID</th>
	              <th>测试周期数</th>
	              <th>路径长度</th>
	            </tr>
	        </thead>
	        <tbody id="content">
	        </tbody>
		</table>
 	</fieldset>
 </div>
 
</body>
</html>