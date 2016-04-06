package com.tlal.vms.vms.func.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.app.pojo.AppEJB;
import com.tlal.vms.vms.func.app.pojo.AppPOJO;
import com.tlal.vms.vms.func.user.sbook.dao.SBookDAO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

@Service
@Transactional(rollbackFor = Exception.class)  
public class APPService implements AppIService{

	@Resource
	private CarDAO carDAO;
	@Resource
	private SBookDAO sBookDAO;
	@Resource
	private UserDAO userDAO;
	
	/**
	 * 根据车牌号查找车辆信息
	 */
	@Override
	public AppEJB findCarByPlateNum(String plate_num) {
		AppEJB appEJB = new AppEJB();
		List<Car> cars = carDAO.findCarLikePlateNum(plate_num);
		if(cars!=null&&cars.size()>0){
			appEJB.setExists(true);//表示找到了匹配的车
			List<AppPOJO> list = new ArrayList<AppPOJO>();
			for(Car car:cars){
				AppPOJO pojo = new AppPOJO();
				pojo.setCar(car);
				if(car.getStatus().equals(CarStatusEnum.Y.getEnValue())){//已租用的情况下还需要附加上租赁情况
					SBook sBook = sBookDAO.findSBookByCarid(car.getCarid().toString().trim());
					pojo.setBook(sBook);
					User operator = userDAO.findById(sBook.getUserid());
					User user = new User();
					user.setName(operator.getName());
					user.setDept(operator.getDept());
					user.setCompany(operator.getCompany());
					pojo.setUser(user);
				}
				list.add(pojo);
			}
			appEJB.setCars(list);
		}else{
			appEJB.setExists(false);//表示没有找到匹配的车
			appEJB.setCars(null);
		}
		return appEJB;
	}
}
