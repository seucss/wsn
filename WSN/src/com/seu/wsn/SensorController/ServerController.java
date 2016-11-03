package com.seu.wsn.SensorController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.seu.wsn.Service.NodeService;


public class ServerController implements Runnable{
	private String testId;
	private NodeService nodeService;
	public ServerController(String testId,NodeService nodeService){
		this.testId = testId;
		this.nodeService = nodeService;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			ExecutorService executor = Executors.newCachedThreadPool();
			while(true){
				Socket socket = serverSocket.accept();
				executor.execute(new NodeTask(socket,testId,nodeService));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
