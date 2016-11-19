package com.seu.wsn.Service;
/**
 * 
 * @ClassName: OrderSettingService 
 * @Description: 业务逻辑层系统指令设置接口
 * @author: CSS
 * @date: 2016-11-19 上午10:11:33
 */
public interface OrderSettingService {
	/**
	 * 
	 * @Title: setOrder 
	 * @Description: 根据orderType设置相应的指令类型
	 * @param orderType
	 * @return: void
	 */
	public void setOrder(String orderType);
}
