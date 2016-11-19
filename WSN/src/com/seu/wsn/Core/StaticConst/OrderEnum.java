package com.seu.wsn.Core.StaticConst;

/**
 * 
 * @ClassName: OrderEnum 
 * @Description: 系统相关指令信息
 * @author: CSS
 * @date: 2016-11-19 上午9:49:41
 */
public enum OrderEnum {
	
	MODIFY_NODE_INFORMATION("modifyNodeInformation"),                //修改节点信息
	DOWNLOAD_PROTOCOL("downloadProtocol"),                           //下载协议
	BURN_PROTOCOL("burnProtocol"),			                         //烧录协议
	PACKET_LOSS_TESTING("packetLossTesting"),                        //丢包率测试
	TIME_DELAY_TESTING("timeDelayTesting"),                          //时延测试
	NETWORK_THROUGHPUT("networkThroughput"),                         //网络吞吐量测试
	AVERAGE_PATH_LENGTH("averagePathLength"),                        //平均路径长度测试
	CONNECTIVITY_DEGREE("connectivityDegree"),                       //网络连通度测试
	WAITING("waiting");			                                     //默认指定，等待
	
	private String orderType;
	/**
	 * 
	 * @Title:OrderEnum
	 * @Description:构造函数
	 * @param orderType
	 */
	private OrderEnum(String orderType){
		this.orderType = orderType;
	}
	/**
	 * 
	 * @Title: getOrderType 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getOrderType(){
		return orderType;
	}
	/**
	 * 
	 * @Title: setOrderType 
	 * @Description: TODO
	 * @param orderType
	 * @return: void
	 */
	public void setOrderType(String orderType){
		this.orderType = orderType;
	}
	/**
	 * 
	 * @Title: getOrderByType 
	 * @Description: 根据指令类型获得相应的枚举指令
	 * @param orderType
	 * @return
	 * @return: OrderEnum
	 */
	public static OrderEnum getOrderByType(String orderType){
		for(OrderEnum order : OrderEnum.values()){
			if(order.getOrderType().equals(orderType)){
				return order;
			}
		}
		return OrderEnum.WAITING;
	}
}
