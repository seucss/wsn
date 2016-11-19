package com.seu.wsn.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.seu.wsn.Core.Pojo.TopologyLink;
import com.seu.wsn.Core.Pojo.TopologyNode;
import com.seu.wsn.Core.StaticConst.WebConst;
import com.seu.wsn.Service.NodeService;
/**
 * 
 * @ClassName: NetworkingController 
 * @Description: 自主组网
 * @author: CSS
 * @date: 2016-11-11 下午1:36:04
 */
@Controller
public class NetworkingController {
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
	 * @Title: getTopology 
	 * @Description: 获取拓扑图信息
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/getTopology")
	@ResponseBody
	public ModelMap getTopology(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		String testId = (String)req.getSession().getAttribute(WebConst.TESTID);
		List<List<TopologyNode>> topologyNodeList = nodeService.getTopologyNodes(testId);
		List<List<TopologyLink>> topologyLinkList = nodeService.getTopologyLinks(testId);
		if(topologyNodeList.size()==2 && topologyLinkList.size()==2){
			model.put(WebConst.NODES, topologyNodeList.get(0));
			model.put(WebConst.CHILD_NODES, topologyNodeList.get(1));
			model.put(WebConst.LINKS, topologyLinkList.get(0));
			model.put(WebConst.CHILD_LINKS, topologyLinkList.get(1));
		}else{
			model.put(WebConst.ERROR_MSG, "拓扑图信息错误");
		}
		return model;
	}
	/**
	 * 
	 * @Title: fileUpload 
	 * @Description: 上传协议文件
	 * @param file
	 * @param nodeType
	 * @param req
	 * @param model
	 * @return
	 * @return: ModelMap
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("file")CommonsMultipartFile file,String nodeType,
			HttpServletRequest req,ModelMap model){
		String path;
		if(WebConst.COMMON_NODE.equals(nodeType)){
			path = req.getRealPath(WebConst.COMMON_FILE);
		}else if(WebConst.CLUSTER_HEAD_NODE.equals(nodeType)){
			path = req.getRealPath(WebConst.CLUSTER_HEAD_FILE);
		}else{
			path = req.getRealPath(WebConst.GATEWAY_FILE);
		}
		nodeService.fileUpload(file, path);
		model.put(WebConst.NODE_TYPE, nodeType);
		model.put(WebConst.NAV_ITEM, "networking");
		return WebConst.NETWORKING;
	}
}
