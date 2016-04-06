package com.tlal.vms.vms.func.app.service;

import com.tlal.vms.vms.func.app.pojo.AppEJB;


public interface AppIService {
	/**
	 * 根据车牌号查找车辆信息
	 * @param plate_num
	 * @return
	 */
	public AppEJB findCarByPlateNum(String plate_num);
}
