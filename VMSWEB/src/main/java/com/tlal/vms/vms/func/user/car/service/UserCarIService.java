package com.tlal.vms.vms.func.user.car.service;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.car.action.UserCarSearch;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;

public interface UserCarIService {
	/**
	 * 分页查找
	 * @param search
	 * @return
	 */
	public Pager<Car> findCarByPage(UserCarSearch search);
	
	/**
	 * 租赁车辆
	 * @param sBook
	 */
	public void rentCar(SBook sBook);
	
	/**
	 * 设置车辆为租用
	 * @param carid
	 */
	public void setCarRentState(String carid);
}
