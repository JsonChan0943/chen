package com.tlal.vms.vms.func.admin.car.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.action.AdminCarSearch;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.admin.car.entity.Car;

/**
 * 管理员-汽车逻辑控制器-处理服务类
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)  
public class AdminCarService implements AdminCarIService{
	@Resource
	private CarDAO carDAO;

	/**
	 * 分页查找
	 */
	@Override
	public Pager<Car> findCarByPage(AdminCarSearch search) {
		Pager<Car> page = new Pager<Car>();
		page.setList(carDAO.findCarByPage(search));
		page.setCount(carDAO.countCars(search));
		return page;
	}

	/** 
	 * 添加车辆
	 */
	@Override
	public void addCar(Car car) {
		if(car!=null){
			carDAO.addCar(car);
		}
	}

	/**
	 * 根据车牌号查找
	 */
	@Override
	public Car findCarByPlateNum(String plate_num) {
		if(plate_num!=null){
			Car car = carDAO.findCarByPlateNum(plate_num);
			if(car!=null){
				return car;
			}
		}
		return null;
	}

	/**
	 * 根据id删除车辆
	 */
	@Override
	public void deleteCarById(String carid) {
		if(carid!=null){
			carDAO.deleteCarById(carid);
		}
	}

	/**
	 * 根据id查找
	 */
	@Override
	public Car findCarById(String carid) {
		if(carid!=null){
			Car car = carDAO.findCarById(carid);
			if(car!=null){
				return car;
			}
		}
		return null;
	}

	/**
	 * 更新车辆信息
	 */
	@Override
	public void updateCar(Car car) {
		if(car!=null){
			carDAO.updateCar(car);
		}
	}

	
}
