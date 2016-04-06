package com.tlal.vms.vms.sys.supers.car.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarSearch;

@Service
@Transactional(rollbackFor = Exception.class)  
public class SuperCarService implements SuperCarIService{
	@Resource
	private CarDAO carDAO;

	/**
	 * 分页查找
	 */
	@Override
	public Pager<Car> findCarByPage(SuperCarSearch search) {
		Pager<Car> page = new Pager<Car>();
		page.setList(carDAO.findCarByPage_Super(search));
		page.setCount(carDAO.countCars_Super(search));
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
			return carDAO.findCarByPlateNum(plate_num);
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

	/**
	 * 超级管理员用方法--查找所有汽车
	 */
	@Override
	public List<Car> findAllCar_Super() {
		return carDAO.findAllCar_Super();
	}

	
}
