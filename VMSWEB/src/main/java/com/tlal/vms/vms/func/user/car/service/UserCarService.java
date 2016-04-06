package com.tlal.vms.vms.func.user.car.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.car.action.UserCarSearch;
import com.tlal.vms.vms.func.user.sbook.dao.SBookDAO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;

@Service
@Transactional(rollbackFor = Exception.class)  
public class UserCarService implements UserCarIService{
	@Resource
	private CarDAO carDAO;
	@Resource
	private SBookDAO sBookDAO;

	/**
	 * 分页查找
	 */
	@Override
	public Pager<Car> findCarByPage(UserCarSearch search) {
		Pager<Car> page = new Pager<Car>();
		page.setList(carDAO.findCarByPage_User(search));
		page.setCount(carDAO.countCars_User(search));
		return page;
	}

	/**
	 * 租出车辆
	 */
	@Override
	public void rentCar(SBook sBook) {
		if(sBook!=null){
			sBookDAO.addSBook(sBook);
		}
	}

	/**
	 * 设置车辆已租用
	 */
	@Override
	public void setCarRentState(String carid) {
		if(carid!=null){
			carDAO.setCarRent(carid);
		}
	}
}
