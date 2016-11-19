package com.seu.wsn.Core.StaticConst;
/**
 * 
 * @ClassName: WebConst 
 * @Description: 系统相关的常量
 * @author: CSS
 * @date: 2016-11-18 下午7:26:48
 */
public class WebConst {
	
	/***************************************JSP页面路径信息*******************************************/
	/*
	 * 管理员登录页面
	 */
	public static final String ADMIN_LOGIN               =          "//WEB-INF//jsp/homePage//adminLogin.jsp";
	/*
	 * 系统简介页面
	 */
	public static final String INTRODUCTION              =          "//WEB-INF//jsp/homePage//introduction.jsp";
	/*
	 * 用户登录页面
	 */
	public static final String USER_LOGIN                =          "//WEB-INF//jsp/homePage//userLogin.jsp";
	/*
	 * 用户注册页面
	 */
	public static final String USER_REGISTER             =          "//WEB-INF//jsp/homePage//userRegister.jsp";
	/*
	 * 首页
	 */
	public static final String INDEX                     =          "//index.jsp";
	/*
	 * 节点管理页面
	 */
	public static final String NODE_INFO                 =          "//WEB-INF//jsp//nodeManage//nodeInfo.jsp";
	/*
	 * 系统使用说明
	 */
	public static final String DIRECTION                 =          "//WEB-INF//jsp//homePage//direction.jsp";
	/*
	 * 协议烧录及组网页面
	 */
	public static final String NETWORKING                 =         "//WEB-INF//jsp//networking//networking.jsp";
	/*
	 * 节点丢包率页面
	 */
	public static final String NODE_PACKET_LOSS           =          "//WEB-INF//jsp//performance_testing//node_packet_loss.jsp";
	/*
	 * 系统丢包率页面
	 */
	public static final String SYSTEM_PACKET_LOSS         =			 "//WEB-INF//jsp//performance_testing//system_packet_loss.jsp";
	/*
	 * 网络时延测试页面
	 */
	public static final String TIME_DELAY				   =         "//WEB-INF//jsp//performance_testing//time_delay.jsp";
	/*
	 * 网络吞吐量测试页面
	 */
	public static final String NETWORKING_THROUGHPUT       = 		  "//WEB-INF//jsp//performance_testing//network_throughput.jsp";
	/*
	 * 网络平均路径长度页面
	 */
	public static final String AVERAGE_PATH_LENGTH         =          "//WEB-INF//jsp//performance_testing//average_path_length.jsp";
	/*
	 * 网络连通度页面
	 */
	public static final String CONNECTIVITY_DEGREE		   =           "//WEB-INF//jsp//performance_testing//connectivity_degree.jsp";
	
	
	
	
	/*********************************************系统相关常量信息*********************************************************/
	/*
	 * 错误信息
	 */
	public static final String ERROR_MSG                 =           "errorMsg";
	/*
	 * 返回信息
	 */
	public static final String MESSAGE                   =            "msg";
	/*
	 * 用户名
	 */
	public static final String USERNAME                  =            "userName";
	/*
	 * 测试名称
	 */
	public static final String TESTID                    =            "testId";
	/*
	 * 导航项
	 */
	public static final String NAV_ITEM                  =            "navItem";
	/*
	 * 节点信息列表
	 */
	public static final String NODE_LIST                 =            "nodeList";
	/*
	 * 拓扑簇头与网关节点信息列表
	 */
	public static final String NODES                      =            "nodes";
	/*
	 * 拓扑普通节点信息列表
	 */
	public static final String CHILD_NODES                =            "childNodes";
	/*
	 * 拓扑簇头与网关节点连线信息列表
	 */
	public static final String LINKS                      =            "links";
	/*
	 * 拓扑普通节点连线信息列表
	 */
	public static final String CHILD_LINKS                =            "childLinks";
	/*
	 * 启动连接
	 */
	public static final String START_CONN				   =           "startConn";
	/*
	 * 成功
	 */
	public static final String SUCCESS				        =           "success";
	/*
	 * 失败
	 */
	public static final String FAIL				            =           "fail";
	/*
	 * 返回的结果
	 */
	public static final String RESULT				        =           "result";
	/*
	 * socket连接端口号
	 */
	public static final int PORT							=           6000;
	
	
	
	/***********************************************节点类型***************************************************************/
	/*
	 * 节点类型
	 */
	public static final String NODE_TYPE                  =           "nodeType";
	/*
	 * 普通节点
	 */
	public static final String COMMON_NODE                =           "commonNode";
	/*
	 * 簇头节点
	 */
	public static final String CLUSTER_HEAD_NODE          =           "clusterHeadNode";
	/*
	 * 网关节点
	 */
	public static final String GATEWAY_NODE               =           "gatewayNode";
	
	/************************************************协议文件所在路径***********************************************************/
	/*
	 * 普通节点烧录的协议所在路径
	 */
	public static final String COMMON_FILE                 =            "/protocolFile/common";
	
	/*
	 * 簇头节点烧录的协议所在路径
	 */
	public static final String CLUSTER_HEAD_FILE            =           "/protocolFile/clusterHead";
	
	/*
	 * 普通节点烧录的协议所在路径
	 */
	public static final String GATEWAY_FILE                 =            "/protocolFile/gateway";
}
