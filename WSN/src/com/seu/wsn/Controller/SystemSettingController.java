package com.seu.wsn.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.wsn.Core.StaticConst.Order;
import com.seu.wsn.Core.StaticConst.WebConst;
import com.seu.wsn.SensorController.ServerController;
import com.seu.wsn.Service.NodeService;
/**
 * 
 * @ClassName: SystemSettingController 
 * @Description: 系统设置
 * @author: CSS
 * @date: 2016-11-14 下午3:15:02
 */
@Controller
public class SystemSettingController {
	private ServerSocket serverSocket = null;
	@Autowired
	private NodeService nodeService;
	/**
	 * 注入nodeService
	 */
	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	/**
	 * 
	 * @Title: startConnection 
	 * @Description: 启动连接
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/startConnection")
	@ResponseBody
	public ModelMap startConnection(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		String testId = UUID.randomUUID().toString();
		//req.getSession().setAttribute(WebConst.TESTID, "6ae39f95-9465-4fcf-8abd-71797171ccf4");
		req.getSession().setAttribute(WebConst.TESTID, testId);
		if(serverSocket==null){
			try {
				serverSocket = new ServerSocket(WebConst.PORT);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Order.startConnection = true;
		new Thread(new ServerController(testId,nodeService,serverSocket)).start();
		req.getSession().setAttribute(WebConst.START_CONN, "true");
		return model;
	}
	/**
	 * 
	 * @Title: stopConnection 
	 * @Description: 关闭连接
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/stopConnection")
	@ResponseBody
	public ModelMap stopConnection(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		Order.startConnection = false;
		req.getSession().setAttribute(WebConst.TESTID, "");
		req.getSession().setAttribute(WebConst.START_CONN, "false");
		try {
			new Socket("localhost",WebConst.PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {    
			e.printStackTrace();
		}
		return model;
	}
	
}
