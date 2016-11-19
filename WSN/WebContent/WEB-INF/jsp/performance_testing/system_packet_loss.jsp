<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include flush="true" page="../navigation/navigation.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>丢包率测试</title>
<!-- Bootstrap core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/tuoputu.css" rel="stylesheet">
    <link href="resource/css/nodeInfo.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
 	<div class="container">
 		<div align="center">
 			<h2><span>丢包率测试</span></h2>
 		</div>
 		<div class="pull-left">
	 		<ol class="breadcrumb">
			  <li><a href="node_packet_loss.wsn">节点丢包率</a></li>
			  <li class="active">系统丢包率</li>
			</ol>
		</div>
 	</div>
 </div>
 <div class="container">
 	<div class="row">
    <div class="col-md-6">
 	<fieldset>
 	<legend>当前测试结果</legend>
	 	<span>发包速率(字节/秒):</span>&nbsp;&nbsp;&nbsp;<span id="send_packet_speed" class="bluea">0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	<span>系统总发包数:</span>&nbsp;&nbsp;&nbsp;<span id="system_send_packet_number" class="bluea">0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	<span>系统总收包数:</span>&nbsp;&nbsp;&nbsp;<span id="system_receive_packet_number" class="bluea">0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	<span>系统丢包率:</span>&nbsp;&nbsp;&nbsp;<span id="system_packet_loss" class="bluea">0</span>
 	</fieldset>
 	<br><br>
 	<fieldset>
 	<legend>历史测试结果</legend>
 		<div class="pull-right">
 		<button type="button" class="btn btn-warning btn-sm" onclick="">清空</button>
	 	</div>
	 	<table class="table table-bordered table-hover">
	  		<thead>
	            <tr>
	              <th>序号</th>
	              <th>测试次数</th>
	              <th>测试包发送速率(字节/秒)</th>
	              <th>周期数</th>
	              <th>系统总发包数</th>
	              <th>系统总收包数</th>
	              <th>网络系统丢包率</th>
	            </tr>
	        </thead>
	        <tbody id="content">
	        </tbody>
		</table>
 	</fieldset>
 	</div>
 	<div class="col-md-6">
 	<fieldset>
 	<legend>绘图区</legend>
 		<span>选择横坐标：</span>
 		<select class="form-control" id="packet_loss_x" onChange="">
		    <option >数据包发送间隔</option>
		    <option>clusterHeadNode</option>
	    </select>
	    <br>
	    <div id='lineChart'>
    	</div>
 	</fieldset>
 	</div>
 </div>
 </div>
</body>
</html>