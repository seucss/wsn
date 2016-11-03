package com.seu.wsn.Common.Dao;

import java.util.List;

import com.seu.wsn.Core.Pojo.Node;

/**
 * 
 * @ClassName: NodeDao 
 * @Description: �ڵ����ݷ��ʲ�ӿ�
 * @author: CSS
 * @date: 2016-11-3 ����9:55:30
 */
public interface NodeDao {
	/**
	 * 
	 * @Title: select 
	 * @Description: ���ݽڵ�Id�Ͳ��Ա��ѡ��ڵ�
	 * @param nodeId
	 * @param testId
	 * @return
	 * @return: Node
	 */
	//public Node select(String nodeId,String testId);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: ����һ���ڵ�
	 * @param node
	 * @return: void
	 */
	public void insert(Node node);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: ���½ڵ���Ϣ
	 * @param node
	 * @return: void
	 */
	public void update(Node node); 
	
	/**
	 * 
	 * @Title: remove 
	 * @Description: ���ݽڵ�id�Ͳ��Ա��ɾ��һ���ڵ�
	 * @param nodeId
	 * @param testId
	 * @return: void
	 */
	//public void remove(String nodeId,String testId);
	
	/**
	 * �������нڵ�
	 * @return
	 */
	public List<Node> nodeList();
	/**
	 * 
	 * @Title: getNodeListByTestId 
	 * @Description: ���ݲ��Ա�ŷ��ؽڵ��б�
	 * @param testId
	 * @return
	 * @return: List<Node>
	 */
	public List<Node> getNodeListByTestId(String testId);
}
