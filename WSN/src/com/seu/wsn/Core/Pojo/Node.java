package com.seu.wsn.Core.Pojo;

/**
 * 
 * @ClassName: Node 
 * @Description: �ڵ���Ϣ��
 * @author: CSS
 * @date: 2016-11-2 ����3:14:45
 */
public class Node {
	private String nodeId;					//�ڵ�id
	private String ip;					//�ڵ�ip
	private String parentId;			//���ڵ�id
	private String nodeType;			//�ڵ�����   
	private String testId;				//���Ա��
	private boolean onLine;				//�Ƿ�����
	private boolean download;			//�Ƿ���¼Э��
	private boolean joinNetwork;		//�Ƿ��������
	/**
	 * 
	 * @Title: getTestId 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getTestId() {
		return testId;
	}
	/**
	 * 
	 * @Title: setTestId 
	 * @Description: TODO
	 * @param testId
	 * @return: void
	 */
	public void setTestId(String testId) {
		this.testId = testId;
	}
	/**
	 * 
	 * @Title: getId 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * 
	 * @Title: setId 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * 
	 * @Title: getIp 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 
	 * @Title: setIp 
	 * @Description: TODO
	 * @param ip
	 * @return: void
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 
	 * @Title: getParentId 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 
	 * @Title: setParentId 
	 * @Description: TODO
	 * @param parentId
	 * @return: void
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 
	 * @Title: getNodeType 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 
	 * @Title: setNodeType 
	 * @Description: TODO
	 * @param nodeType
	 * @return: void
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * 
	 * @Title: isOnLine 
	 * @Description: TODO
	 * @return
	 * @return: boolean
	 */
	public boolean isOnLine() {
		return onLine;
	}
	/**
	 * @Title: setOnLine 
	 * @Description: TODO
	 * @param onLine
	 * @return: void
	 */
	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
	/**
	 * 
	 * @Title: isDownload 
	 * @Description: TODO
	 * @return
	 * @return: boolean
	 */
	public boolean isDownload() {
		return download;
	}
	/**
	 * 
	 * @Title: setDownload 
	 * @Description: TODO
	 * @param download
	 * @return: void
	 */
	public void setDownload(boolean download) {
		this.download = download;
	}
	/**
	 * 
	 * @Title: isJoinNetwork 
	 * @Description: TODO
	 * @return
	 * @return: boolean
	 */
	public boolean isJoinNetwork() {
		return joinNetwork;
	}
	/**
	 * 
	 * @Title: setJoinNetwork 
	 * @Description: TODO
	 * @param joinNetwork
	 * @return: void
	 */
	public void setJoinNetwork(boolean joinNetwork) {
		this.joinNetwork = joinNetwork;
	}
	
}
