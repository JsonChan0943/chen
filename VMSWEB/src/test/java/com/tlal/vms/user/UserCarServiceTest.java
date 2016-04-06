package com.tlal.vms.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.admin.AdminCarServiceTest;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.car.action.UserCarSearch;
import com.tlal.vms.vms.func.user.car.service.UserCarIService;

/**
 * UserCarServiceTest
 * @author chenhuaijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class UserCarServiceTest {
	private static Logger logger = LoggerFactory.getLogger(AdminCarServiceTest.class);  
	@Resource
	private UserCarIService userCarService;
	
	/**
	 * testFindByPage
	 */
	@Test
	public void testFindByPage(){
		UserCarSearch search = new UserCarSearch();
		search.setToPage(1);
		Pager<Car> pager = userCarService.findCarByPage(search);
		logger.info("=======================================================");
		logger.info("总记录数："+pager.getCount());
		logger.info("本次查询总数:"+pager.getFindCnt());
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
		logger.info("=======================================================");
	}
}
