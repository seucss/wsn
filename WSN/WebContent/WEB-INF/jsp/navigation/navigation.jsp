<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="resource/icon/icon1.ico">
<!-- Bootstrap core CSS -->
    <link href="/resource/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="/resource/js/bootstrap.min.js"></script>

</head>
<body >
	 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">物联网感知层测试系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          	<c:choose>
          		<c:when test="${navItem=='homePage'}">
          			 <li class="active" ><a href="homePage.wsn">首页</a></li>
          	 	</c:when>
          	 	<c:when test="${navItem==null}">
          			 <li class="active" ><a href="homePage.wsn">首页</a></li>
          	 	</c:when>
          		<c:otherwise>
          			  <li><a href="homePage.wsn">首页</a></li>
          		</c:otherwise>
          	</c:choose>
          	<c:choose>
          		<c:when test="${navItem=='nodeInfo'}">
          			 <li class="active" ><a href="nodeInfo.wsn">节点管理</a></li>
          	 	</c:when>
          		<c:otherwise>
          			 <li ><a href="nodeInfo.wsn">节点管理</a></li>
          		</c:otherwise>
          	</c:choose>
          	<c:choose>
          		<c:when test="${navItem=='networking'}">
          			 <li class="active"><a href="networking.wsn">自主组网</a></li>
          	 	</c:when>
          		<c:otherwise>
          			 <li><a href="networking.wsn">自主组网</a></li>
          		</c:otherwise>
          	</c:choose>
          	<c:choose>
          		<c:when test="${navItem=='performance_testing'}">
          			 <li class="dropdown active">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">性能测试<span class="caret"></span></a>
		              <ul class="dropdown-menu" role="menu">
		                <li><a href="node_packet_loss.wsn">网络丢包率测试</a></li>
		                <li class="divider"></li>
		                <li><a href="time_delay.wsn">网络时延测试</a></li>
		                <li class="divider"></li>
		                <li><a href="network_throughput.wsn">网络吞吐量测试</a></li>
		                <li class="divider"></li>
		                <li><a href="average_path_length.wsn">网络平均路径长度</a></li>
		                <li class="divider"></li>
		                <li><a href="connectivity_degree.wsn">网络联通度测试</a></li>
		              </ul>
		            </li>
          	 	</c:when>
          		<c:otherwise>
          			 <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">性能测试<span class="caret"></span></a>
		              <ul class="dropdown-menu" role="menu">
		                <li><a href="node_packet_loss.wsn">网络丢包率测试</a></li>
		                <li class="divider"></li>
		                <li><a href="time_delay.wsn">网络时延测试</a></li>
		                <li class="divider"></li>
		                <li><a href="network_throughput.wsn">网络吞吐量测试</a></li>
		                <li class="divider"></li>
		                <li><a href="average_path_length.wsn">网络平均路径长度</a></li>
		                <li class="divider"></li>
		                <li><a href="connectivity_degree.wsn">网络联通度测试</a></li>
		              </ul>
		            </li>
          		</c:otherwise>
          	</c:choose>
          	<c:choose>
          		<c:when test="${navItem==''}">
          			 <li class="active" ><a href="">历史查询</a></li>
          	 	</c:when>
          		<c:otherwise>
          			 <li ><a href="">历史查询</a></li>
          		</c:otherwise>
          	</c:choose>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
</body>
</html>