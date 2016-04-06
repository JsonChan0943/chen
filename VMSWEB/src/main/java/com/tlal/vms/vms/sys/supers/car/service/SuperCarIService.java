package com.tlal.vms.vms.sys.supers.car.service;

import java.util.List;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarSearch;

public interface SuperCarIService {
	
	/**
	 * 分页查找
	 * @param search
	 * @return
	 */
	public Pager<Car> findCarByPage(SuperCarSearch search);
	
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
	
	/**
	 * 超级管理员-查询所有车辆信息
	 * @return
	 */
	public List<Car> findAllCar_Super();
}
