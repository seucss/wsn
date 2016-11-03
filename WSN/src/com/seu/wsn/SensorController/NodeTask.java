package com.seu.wsn.SensorController;

import java.net.Socket;

import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Service.NodeService;

public class NodeTask implements Runnable{
	private Socket socket;			//���տͻ���socekt
	private String testId;			//���Ա��	
	private NodeService nodeService; //nodeService
	/**
	 * 
	 * @Title:NodeTask
	 * @Description:���캯�� 
	 * @param socket
	 * @param testId
	 */
	public NodeTask(Socket socket,String testId,NodeService nodeService){
		this.socket = socket;
		this.testId = testId;
		this.nodeService = nodeService;
	}
	/**
	 * �߳�ִ��
	 */
	@Override
	public void run() {
		String ip = socket.getInetAddress().toString().substring(1); //��ýڵ�ip
		Node node = new Node();
		node.setIp(ip);
		node.setTestId(testId);
		nodeService.insert(node);
	}

}
