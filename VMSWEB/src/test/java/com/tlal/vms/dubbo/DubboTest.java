package com.tlal.vms.dubbo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.smm.dubbo.DubboServiceTest;

/**
 * Dubbo 测试类
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-comsumer.xml" })
public class DubboTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private DubboServiceTest dubboServiceTest;
	
	@Test
	public void test(){
		logger.info(dubboServiceTest.sayHello("chenhuaijie"));
		System.out.println(dubboServiceTest.sayHello("chenhuaijie"));
	}
}
