package com.seu.wsn.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.seu.wsn.Common.Dao.NodeDao;
import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Core.Pojo.TopologyLink;
import com.seu.wsn.Core.Pojo.TopologyNode;
import com.seu.wsn.Core.StaticConst.WebConst;
/**
 * 
 * @ClassName: NodeServiceImpl 
 * @Description: 节点业务逻辑层实现类
 * @author: CSS
 * @date: 2016-11-3 下午2:12:41
 */
@Service("nodeService")
public class NodeServiceImpl implements NodeService{
	
	@Autowired
	private NodeDao nodeDao;
	/**
	 * 
	 * @Title: setNodeDao 
	 * @Description: 注入nodeDao
	 * @param nodeDao
	 * @return: void
	 */
	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
	/**
	 * 插入新节点
	 */
	@Override
	public void insert(Node node) {
		String ip = node.getIp();
		String nodeId = ip.substring(8);
		//注入节点初始信息
		node.setNodeId(nodeId);
		node.setDownload(false);
		node.setJoinNetwork(true);
		node.setNodeType(WebConst.COMMON_NODE);
		node.setOnLine(true);
		node.setBurner(false);
		node.setParentId("null");
		nodeDao.insert(node);
	}
	/**
	 * 更新节点信息
	 */
	@Override
	public void update(Node node) {
		nodeDao.update(node);
	}
	/**
	 * 获取节点列表
	 */
	@Override
	public List<Node> nodeList() {
		return nodeDao.nodeList();
	}
	/**
	 * 根据测试编号获取满足条件的节点列表
	 */
	@Override
	public List<Node> getNodeListByTestId(String testId) {
		return nodeDao.getNodeListByTestId(testId);
	}
	/**
	 * 根据条件选择节点
	 */
	@Override
	public Node select(String nodeId,String testId) {
		Node node = new Node();
		node.setNodeId(nodeId);
		node.setTestId(testId);
		return nodeDao.select(node);
	}
	/**
	 * 根据节点类型获取满足条件的节点列表
	 */
	@Override
	public List<Node> getNodeListByNodeType(String testId,String nodeType) {
		Node node = new Node();
		node.setTestId(testId);
		node.setNodeType(nodeType);
		return nodeDao.getNodeListByNodeType(node);
	}
	/**
	 * 获得拓扑图中节点信息
	 */
	@Override
	public List<List<TopologyNode>> getTopologyNodes(String testId) {
		List<List<TopologyNode>> list = new ArrayList<List<TopologyNode>>();
		List<Node> nodeList = nodeDao.getNodeListByTestId(testId);
		List<TopologyNode> topologyNodeList = new ArrayList<TopologyNode>();
		List<TopologyNode> topologyChildNodeList = new ArrayList<TopologyNode>();
		for(int i=0;i<nodeList.size();i++){
			TopologyNode topologyNode = new TopologyNode();
			topologyNode.setIp(nodeList.get(i).getIp());
			topologyNode.setType(nodeList.get(i).getNodeType());
			if("commonNode".equals(topologyNode.getType())){
				topologyNode.setStatus(1);
				topologyNode.setExpand(false);
				topologyChildNodeList.add(topologyNode);
			}else{
				if("gatewayNode".equals(topologyNode.getType())){
					topologyNode.setStatus(0);
					topologyNode.setExpand(false);
				}else{
					topologyNode.setStatus(1);
					topologyNode.setExpand(true);
				}
				topologyNodeList.add(topologyNode);
			}
		}
		list.add(topologyNodeList);
		list.add(topologyChildNodeList);
		return list;
	}
	/**
	 * 获得拓扑图中节点连接信息
	 */
	@Override
	public List<List<TopologyLink>> getTopologyLinks(String testId) {
		List<List<TopologyLink>> list = new ArrayList<List<TopologyLink>>();
		List<Node> nodeList = nodeDao.getNodeListByTestId(testId);
		List<TopologyLink> topologyLinkList = new ArrayList<TopologyLink>();
		List<TopologyLink> topologyChildLinkList = new ArrayList<TopologyLink>();
		for(int i=0;i<nodeList.size();i++){
			if(!"null".equals(nodeList.get(i).getParentId())){
				TopologyLink topologyLink = new TopologyLink();
				String parentIp = nodeList.get(i).getIp().substring(0,8)+nodeList.get(i).getParentId();  //所有节点ip均由10.10.1.**开头
				topologyLink.setSource(parentIp);
				topologyLink.setTarget(nodeList.get(i).getIp());
				
				if("clusterHeadNode".equals(nodeList.get(i).getNodeType())){
					topologyLinkList.add(topologyLink);
				}else{
					topologyChildLinkList.add(topologyLink);
				}
			}
		}
		list.add(topologyLinkList);
		list.add(topologyChildLinkList);
		return list;
	}
	/**
	 * 上传协议文件
	 * @throws IOException 
	 */
	@Override
	public String fileUpload(CommonsMultipartFile file, String path){
		try {
			InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(
					new File(path,file.getOriginalFilename()));
			int len = 0;
			byte[] buffer = new byte[400];
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			return WebConst.FAIL;
		}
		return WebConst.SUCCESS;
	}
}
