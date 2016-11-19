package com.seu.wsn.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Core.StaticConst.WebConst;
import com.seu.wsn.Service.NodeService;
/**
 * 
 * @ClassName: NodeManageController 
 * @Description: 节点管理控制器
 * @author: CSS
 * @date: 2016-11-8 下午3:20:48
 */
@Controller
public class NodeManageController {
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
	 * @Title: getNodeList 
	 * @Description: 获取节点信息列表
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/getNodeList")
	@ResponseBody
	public ModelMap getNodeList(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		String testId = (String)req.getSession().getAttribute(WebConst.TESTID);
		List<Node> nodeList = nodeService.getNodeListByTestId(testId);
		model.put(WebConst.NODE_LIST, nodeList);
		return model;
	}
	/**
	 * 
	 * @Title: getNodeList 
	 * @Description: 根据节点类型获取节点信息列表
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/getNodeListByType")
	@ResponseBody
	public ModelMap getNodeListByType(HttpServletRequest req,HttpServletResponse resp,ModelMap model,String nodeType){
		String testId = (String)req.getSession().getAttribute(WebConst.TESTID);
		List<Node> nodeList = nodeService.getNodeListByNodeType(testId,nodeType);
		model.put(WebConst.NODE_LIST, nodeList);
		return model;
	}
	
	/**
	 * 
	 * @Title: modifyNodeInfo 
	 * @Description: 接受请求修改节点信息
	 * @param req
	 * @param resp
	 * @param model
	 * @param nodeId
	 * @param nodeType
	 * @param joinNetwork
	 * @return
	 * @return: ModelMap
	 */
	 @RequestMapping("/modifyNodeInfo")
	 @ResponseBody
	 public ModelMap modifyNodeInfo(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			 String nodeId,String nodeType,String joinNetwork){
		 String testId = (String)req.getSession().getAttribute(WebConst.TESTID);
		 Node node = nodeService.select(nodeId, testId);
		 node.setNodeType(nodeType);
		 if("true".equals(joinNetwork)){
			 node.setJoinNetwork(true);
		 }else{
			 node.setJoinNetwork(false);
		 }
		 nodeService.update(node);
		 model.put(WebConst.MESSAGE,"success");
		 return model;
	 }
	
}
