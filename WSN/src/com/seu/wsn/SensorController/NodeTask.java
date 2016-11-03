package com.seu.wsn.SensorController;

import java.net.Socket;

import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Service.NodeService;

public class NodeTask implements Runnable{
	private Socket socket;			//接收客户端socekt
	private String testId;			//测试编号	
	private NodeService nodeService; //nodeService
	/**
	 * 
	 * @Title:NodeTask
	 * @Description:构造函数 
	 * @param socket
	 * @param testId
	 */
	public NodeTask(Socket socket,String testId,NodeService nodeService){
		this.socket = socket;
		this.testId = testId;
		this.nodeService = nodeService;
	}
	/**
	 * 线程执行
	 */
	@Override
	public void run() {
		String ip = socket.getInetAddress().toString().substring(1); //获得节点ip
		Node node = new Node();
		node.setIp(ip);
		node.setTestId(testId);
		nodeService.insert(node);
	}

}
