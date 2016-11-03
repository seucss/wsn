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
 * @Description: �ڵ�ҵ���߼���ʵ����
 * @author: CSS
 * @date: 2016-11-3 ����2:12:41
 */
@Service("nodeService")
public class NodeServiceImpl implements NodeService{
	
	@Autowired
	private NodeDao nodeDao;
	/**
	 * 
	 * @Title: setNodeDao 
	 * @Description: ע��nodeDao
	 * @param nodeDao
	 * @return: void
	 */
	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
	/**
	 * �����½ڵ�
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
	 * ���½ڵ���Ϣ
	 */
	@Override
	public void update(Node node) {
		nodeDao.update(node);
	}
	/**
	 * ��ȡ�ڵ��б�
	 */
	@Override
	public List<Node> nodeList() {
		return nodeDao.nodeList();
	}
	/**
	 * ���ݲ��Ա�Ż�ȡ�ڵ��б�
	 */
	@Override
	public List<Node> getNodeListByTestId(String testId) {
		return nodeDao.getNodeListByTestId(testId);
	}
}
