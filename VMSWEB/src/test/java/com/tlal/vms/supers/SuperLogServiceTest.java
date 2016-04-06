package com.tlal.vms.supers;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.vms.sys.supers.log.service.SuperLogIService;

/**
 * SuperLogServiceTest
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SuperLogServiceTest {
	private static Logger logger = LoggerFactory.getLogger(SuperLogServiceTest.class);
	@Resource
	private SuperLogIService superLogService;
	/**
	 * testAddLog
	 */
	@Test
	public void testAddLog(){
		superLogService.addLog("1001", new Date(), "操作内容", LogOpeTypeEnum.ADDCAR.getEnValue());
		logger.info("添加日志成功！");
	}
}
