package com.seu.wsn.Service;

import org.springframework.stereotype.Service;

import com.seu.wsn.Core.StaticConst.OrderEnum;
import com.seu.wsn.SensorController.NodeTask;
import com.seu.wsn.SensorController.ServerController;

@Service("orderSettingService")
public class OrderSettingServiceImpl implements OrderSettingService{

	/**
	 * 根据orderType设置相应的指令类型
	 */
	@Override
	public void setOrder(String orderType) {
		OrderEnum order = OrderEnum.getOrderByType(orderType);
		for(NodeTask task : ServerController.taskList){
			task.setOrder(order);
		}
	}

}
