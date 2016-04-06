package com.tlal.vms.app;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tlal.vms.vms.func.app.pojo.AppEJB;
import com.tlal.vms.vms.func.app.service.AppIService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class AppServiceTest {
	private static Logger logger = LoggerFactory.getLogger(AppServiceTest.class); 
	@Resource
	private AppIService appService;
	
	/**
	 * 测试按照
	 */
	@Test
	public void testFindCarByPlateNum(){
		AppEJB ejb = appService.findCarByPlateNum("9");
		String json = JSON.toJSONString(ejb);
		logger.info(json);
	}
	
}
