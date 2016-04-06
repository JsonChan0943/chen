package com.tlal.vms.vms.func.admin.car.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.func.admin.car.action.AdminCarSearch;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.car.action.UserCarSearch;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarSearch;

/**
 * Car的数据库访问层DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface CarDAO {
	/**
	 * 列表显示车辆信息
	 * @param model
	 * @return
	 */
	public List<Car> findCarByPage(AdminCarSearch search);
	
	/**
	 * 获取车辆数
	 * @return
	 */
	public int countCars(AdminCarSearch search);
	
	/**
	 * 根据id查找车辆
	 * @param carid
	 * @return
	 */
	public Car findCarById(String carid);
	
	
	
	/**
	 * 增加车辆
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * 根据id删除车辆
	 * @param carid
	 */
	public void deleteCarById(String carid);
	
	/**
	 * 更新车辆
	 * @param car
	 */
	public void updateCar(Car car);
	
	/**
	 * 设置车辆未被租用
	 * @param carid
	 */
	public void setCarUnRent(String carid);
	
	/**
	 * 设置车辆已被租用
	 * @param carid
	 */
	public void setCarRent(String carid);
	
	/**
	 * 根据车牌号获取汽车信息
	 * @param plate_num
	 * @return
	 */
	public Car findCarByPlateNum(String plate_num);
	
	/**
	 * 车牌的模糊查询
	 * @param plate_num
	 * @return
	 */
	public List<Car> findCarLikePlateNum(String plate_num);
	
	/**
	 * 用户汽车分页查找
	 * @param search
	 * @return
	 */
	public List<Car> findCarByPage_User(UserCarSearch search);
	
	/**
	 * 用户汽车数量统计
	 * @param search
	 * @return
	 */
	public Integer countCars_User(UserCarSearch search);
	
	/**
	 * 超级管理员汽车分页查找
	 * @param search
	 * @return
	 */
	public List<Car> findCarByPage_Super(SuperCarSearch search);
	
	/**
	 * 超级管理员汽车数量统计
	 * @param search
	 * @return
	 */
	public Integer countCars_Super(SuperCarSearch search);
	
	/**
	 * 超级管理员-查询所有车辆
	 * @return
	 */
	public List<Car> findAllCar_Super();
}
