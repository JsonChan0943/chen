package com.tlal.vms.vms.func.user.car.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.user.car.action.UserCarModel;

public interface UserCarIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public UserCarModel getModel();
	
	/**
	 * 列表显示
	 * @return
	 */
	public String goMain();
	
	/**
	 * 租赁汽车
	 * @return
	 */
	public String doRentCar();
}
