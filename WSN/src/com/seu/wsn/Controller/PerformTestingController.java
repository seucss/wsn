package com.seu.wsn.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.seu.wsn.Service.OrderSettingService;

/**
 * 
 * @ClassName: PerformTestingController 
 * @Description: 性能测试
 * @author: CSS
 * @date: 2016-11-19 上午10:10:47
 */
@Controller
public class PerformTestingController {
	@Autowired
	private OrderSettingService orderSettingService;
	/**
	 * 
	 * @Title: setOrderSettingService 
	 * @Description: 注入orderSettingService
	 * @param orderSettingService
	 * @return: void
	 */
	public void setOrderSettingService(OrderSettingService orderSettingService) {
		this.orderSettingService = orderSettingService;
	}
	/**
	 * 
	 * @Title: modifyNodeInformation 
	 * @Description: 修改节点类型
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/modifyNodeInformation")
	@ResponseBody
	public ModelMap modifyNodeInformation(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: downloadProtocol 
	 * @Description: 下载协议文件
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/downloadProtocol")
	@ResponseBody
	public ModelMap downloadProtocol(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: burnProtocol 
	 * @Description: 烧录协议文件
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/burnProtocol")
	@ResponseBody
	public ModelMap burnProtocol(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: packetLossTesting 
	 * @Description: 丢包率测试
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/packetLossTesting")
	@ResponseBody
	public ModelMap packetLossTesting(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: timeDelayTesting 
	 * @Description: 网络时延测试
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/timeDelayTesting")
	@ResponseBody
	public ModelMap timeDelayTesting(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: networkThroughput 
	 * @Description: 网络吞吐量测试
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/networkThroughput")
	@ResponseBody
	public ModelMap networkThroughput(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: averagePathLength 
	 * @Description: 网络平均路径长度测试
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/averagePathLength")
	@ResponseBody
	public ModelMap averagePathLength(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	/**
	 * 
	 * @Title: connectivityDegree 
	 * @Description: 网络联通度测试
	 * @param req
	 * @param resp
	 * @param model
	 * @param orderType
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/connectivityDegree")
	@ResponseBody
	public ModelMap connectivityDegree(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String orderType){
		orderSettingService.setOrder(orderType);
		return model;
	}
	

}
