package com.seu.wsn.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seu.wsn.Core.StaticConst.WebConst;
/**
 * 
 * @ClassName: NavigationController 
 * @Description: 导航栏控制器
 * @author: CSS
 * @date: 2016-11-8 上午9:45:01
 */
@Controller
public class NavigationController {
	/**
	 * 
	 * @Title: homePage 
	 * @Description: 获取系统简介页面
	 * @param req
	 * @param resp
	 * @return
	 * @return: String
	 */
	@RequestMapping("/homePage")
	public String homePage(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "homePage");
		String start = (String)req.getSession().getAttribute(WebConst.START_CONN);
		if("true".equals(start)){
			model.put(WebConst.START_CONN, "true");
		}else if("false".equals(start)){
			model.put(WebConst.START_CONN, "false");
		}
		return WebConst.INTRODUCTION;
	}
	
	
	
	/**
	 * 
	 * @Title: nodeInfo 
	 * @Description: 获取节点信息页面
	 * @param req
	 * @param resp
	 * @return
	 * @return: String
	 */
	@RequestMapping("/nodeInfo")
	public String nodeInfo(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "nodeInfo");
		return WebConst.NODE_INFO;
	}
	/**
	 * 
	 * @Title: nodeInfo 
	 * @Description: 获取节点信息页面
	 * @param req
	 * @param resp
	 * @return
	 * @return: String
	 */
	@RequestMapping("/networking")
	public String networking(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "networking");
		return WebConst.NETWORKING;
	}
	/**
	 * 
	 * @Title: packet_loss 
	 * @Description: 获取节点丢包率页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/node_packet_loss")
	public String nodePacketLoss(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.NODE_PACKET_LOSS;
	}
	/**
	 * 
	 * @Title: systemPacketLoss 
	 * @Description: 获取系统丢包率页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/system_packet_loss")
	public String systemPacketLoss(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.SYSTEM_PACKET_LOSS;
	}
	/**
	 * 
	 * @Title: timeDelay 
	 * @Description: 获取网络时延页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/time_delay")
	public String timeDelay(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.TIME_DELAY;
	}
	/**
	 * 
	 * @Title: networkThroughput 
	 * @Description: 获取网络吞吐量页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/network_throughput")
	public String networkThroughput(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.NETWORKING_THROUGHPUT;
	}
	/**
	 * 
	 * @Title: averagePathLength 
	 * @Description: 获取平均路径长度页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/average_path_length")
	public String averagePathLength(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.AVERAGE_PATH_LENGTH;
	}
	/**
	 * 
	 * @Title: connectivityDegree 
	 * @Description: 获取网络连通度页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/connectivity_degree")
	public String connectivityDegree(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		model.put(WebConst.NAV_ITEM, "performance_testing");
		return WebConst.CONNECTIVITY_DEGREE;
	}
}
