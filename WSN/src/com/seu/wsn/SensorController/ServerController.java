package com.seu.wsn.SensorController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.seu.wsn.Core.StaticConst.Order;
import com.seu.wsn.Service.NodeService;

/**
 * 
 * @ClassName: ServerController 
 * @Description:节点控制器
 * @author: CSS
 * @date: 2016-11-3 下午8:01:18
 */
public class ServerController implements Runnable{
	private String testId;
	private NodeService nodeService;
	private ServerSocket serverSocket ;
	public static List<NodeTask> taskList = new ArrayList<NodeTask>();
	public ServerController(String testId,NodeService nodeService,ServerSocket serverSocket ){
		this.testId = testId;
		this.nodeService = nodeService;
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		try {
			ExecutorService executor = Executors.newCachedThreadPool();
			while(Order.startConnection){
				Socket socket = serverSocket.accept();
				NodeTask task = new NodeTask(socket,testId,nodeService);
				taskList.add(task);
				executor.execute(task);
			}
			serverSocket = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
