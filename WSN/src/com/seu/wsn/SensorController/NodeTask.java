package com.seu.wsn.SensorController;

import java.net.Socket;
import java.util.UUID;

import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Core.StaticConst.Order;
import com.seu.wsn.Core.StaticConst.OrderEnum;
import com.seu.wsn.Service.NodeService;
/**
 * 
 * @ClassName: NodeTask 
 * @Description: 节点任务类
 * @author: CSS
 * @date: 2016-11-3 下午8:06:12
 */
public class NodeTask implements Runnable{
	private Socket socket;			//客户端socekt
	private String testId;			//测试编号	
	private NodeService nodeService; //nodeService
	private String nodeId;           //节点id 
	private String nodeType;	     //节点类型
	private volatile OrderEnum order = OrderEnum.WAITING; //指令类型
	/**
	 * 
	 * @Title: getNodeId 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * 
	 * @Title: setNodeId 
	 * @Description: TODO
	 * @param nodeId
	 * @return: void
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
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
	 * @Title: getOrder 
	 * @Description: TODO
	 * @return
	 * @return: OrderEnum
	 */
	public OrderEnum getOrder() {
		return order;
	}
	/**
	 * 
	 * @Title: setOrder 
	 * @Description: TODO
	 * @param order
	 * @return: void
	 */
	public void setOrder(OrderEnum order) {
		this.order = order;
	}
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
	 * 线程执行函数
	 */
	@Override
	public void run() {
		String ip = socket.getInetAddress().toString().substring(1); //节点ip
		if(!"127.0.0.1".equals(ip)){
			Node node = new Node();
			node.setIp(ip);
			node.setTestId(testId);
			nodeService.insert(node);
			System.out.println("========="+ip);
			while(Order.startConnection){
				switch(order){
					case MODIFY_NODE_INFORMATION:{
						System.out.println("修改节点信息");
						order = OrderEnum.WAITING;
						break;
					}
					case DOWNLOAD_PROTOCOL:{
						System.out.println("下载协议");
						order = OrderEnum.WAITING;
						break;
					}
					case BURN_PROTOCOL:{
						System.out.println("烧录协议");
						order = OrderEnum.WAITING;
						break;
					}
					case PACKET_LOSS_TESTING:{
						System.out.println("丢包率测试");
						order = OrderEnum.WAITING;
						break;
					}
					case TIME_DELAY_TESTING:{
						System.out.println("时延测试");
						order = OrderEnum.WAITING;
						break;
					}
					case NETWORK_THROUGHPUT:{
						System.out.println("网络吞吐量测试");
						order = OrderEnum.WAITING;
						break;
					}
					case AVERAGE_PATH_LENGTH:{
						System.out.println("平均路径长度测试");
						order = OrderEnum.WAITING;
						break;
					}
					case CONNECTIVITY_DEGREE:{
						System.out.println("网络联通度测试");
						order = OrderEnum.WAITING;
						break;
					}
					default:{
						order = OrderEnum.WAITING;
					}
				}
			}
		}
	}

}
