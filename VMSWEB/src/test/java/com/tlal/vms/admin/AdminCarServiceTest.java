package com.tlal.vms.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.action.AdminCarSearch;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.admin.car.service.AdminCarIService;

/**
 * AdminCarServiceTest
 * @author chenhuaijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class AdminCarServiceTest {
	private static Logger logger = LoggerFactory.getLogger(AdminCarServiceTest.class);  
	@Resource
	private AdminCarIService adminCarService;
	
	/**
	 * 测试分页语句
	 */
	@Test
	public void testFindByPage(){
		AdminCarSearch search = new AdminCarSearch();
		search.setToPage(2);
		Pager<Car> pager = adminCarService.findCarByPage(search);
		logger.info("==================================================");
		logger.info("本次查询记录数:"+pager.getFindCnt());
		logger.info("总记录数:"+pager.getCount());
		for(Car car:pager.getList()){
			logger.info("================================");
			logger.info("汽车id:"+car.getCarid());
			logger.info("汽车名称:"+car.getName());
			logger.info("汽车车牌号:"+car.getPlate_num());
			logger.info("汽车类型:"+car.getType());
			logger.info("汽车状态:"+car.getStatus()+" "+car.getStatusName());
			logger.info("汽车来源:"+car.getOrigin()+""+car.getOriginName());
			logger.info("汽车所属公司:"+car.getCompany());
		}
		logger.info("==================================================");
	}
	
	/**
	 * 测试findCarById方法
	 */
	@Test
	public void testFindCarById(){
		String carid = "111111";
		Car car = adminCarService.findCarById(carid);
		logger.info("==================================================");
		logger.info("汽车id:"+car.getCarid());
		logger.info("汽车名称:"+car.getName());
		logger.info("汽车车牌号:"+car.getPlate_num());
		logger.info("汽车类型:"+car.getType());
		logger.info("汽车状态:"+car.getStatus()+" "+car.getStatusName());
		logger.info("汽车来源:"+car.getOrigin()+""+car.getOriginName());
		logger.info("汽车所属公司:"+car.getCompany());
		logger.info("==================================================");
	}
	
	/**
	 * testAddCar
	 */
	@Test
	@Transactional
	public void testAddCar(){
		Car car = new Car();
		car.setCarid("111111");
		car.setCompany("1001");
		car.setDept("科技部");
		car.setName("保时捷");
		car.setOrigin(CarOriginEnum.CT01.getEnValue());
		car.setStatus(CarStatusEnum.N.getEnValue());
		car.setPlate_num("沪A-9999");
		car.setType("敞篷车");
		adminCarService.addCar(car);
		throw new NullPointerException();
	}

	/**
	 * testFindCarByPlateNum
	 */
	@Test
	public void testFindCarByPlateNum(){
		String plate_num = "沪A-9999";
		Car car = adminCarService.findCarByPlateNum(plate_num);
		logger.info("汽车id:"+car.getCarid());
		logger.info("汽车名称:"+car.getName());
		logger.info("汽车车牌号:"+car.getPlate_num());
		logger.info("汽车类型:"+car.getType());
		logger.info("汽车状态:"+car.getStatus()+" "+car.getStatusName());
		logger.info("汽车来源:"+car.getOrigin()+" "+car.getOriginName());
		logger.info("汽车所属公司:"+car.getCompany());
	}
	
	/**
	 * testDeleteCarById
	 */
	@Test
	public void testDeleteCarById(){
		String carid = "111111";
		adminCarService.deleteCarById(carid);
	}

	/**
	 * testUpdateCar
	 */
	@Test
	public void testUpdateCar(){
		String carid = "111111";
		Car car = adminCarService.findCarById(carid);
		car.setName("法拉利");
		adminCarService.updateCar(car);
	}

}
