package com.tlal.vms.supers;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.sys.supers.car.service.SuperCarIService;

/**
 * SuperCarServiceTest
 * @author chenhuaijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SuperCarServiceTest {
	private static Logger logger = LoggerFactory.getLogger(SuperCarServiceTest.class);
	@Resource
	private SuperCarIService superCarService;
	
	/**
	 * testAddCar
	 */
	@Test
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
		superCarService.addCar(car);
		logger.info("添加车辆成功！");
	}
}
