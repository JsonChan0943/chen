package com.tlal.vms.vms.func.admin.car.service;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.action.AdminCarSearch;
import com.tlal.vms.vms.func.admin.car.entity.Car;

/**
 * 管理员-汽车逻辑控制器-处理服务类接口
 * @author Administrator
 *
 */
public interface AdminCarIService {
	
	/**
	 * 分页查找
	 * @param search
	 * @return
	 */
	public Pager<Car> findCarByPage(AdminCarSearch search);
	
	/**
	 * 添加车辆
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * 根绝车牌号查找
	 * @param plate_num
	 * @return
	 */
	public Car findCarByPlateNum(String plate_num);
	
	/**
	 * 根据id删除
	 * @param carid
	 */
	public void deleteCarById(String carid);
	
	/**
	 * 根据id查找
	 * @param carid
	 * @return
	 */
	public Car findCarById(String carid);
	
	/**
	 * 更新车辆信息
	 * @param car
	 */
	public void updateCar(Car car);
}
