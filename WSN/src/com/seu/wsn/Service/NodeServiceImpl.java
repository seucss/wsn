package com.seu.wsn.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seu.wsn.Common.Dao.NodeDao;
import com.seu.wsn.Core.Pojo.Node;
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
		node.setNodeId(nodeId);
		node.setDownload(false);
		node.setJoinNetwork(true);
		node.setNodeType(WebConst.COMMON_NODE);
		node.setOnLine(true);
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
}
