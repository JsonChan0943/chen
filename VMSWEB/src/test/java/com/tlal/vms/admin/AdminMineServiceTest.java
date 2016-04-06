package com.tlal.vms.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.vms.func.admin.mine.service.AdminMineIService;
import com.tlal.vms.vms.sys.login.entity.User;

/**
 * AdminMineServiceTest
 * @author chenhuaijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class AdminMineServiceTest {
	private static Logger logger = LoggerFactory.getLogger(AdminMineServiceTest.class);  
	@Resource
	private AdminMineIService adminMineIService;
	
	/**
	 * 测试findAdminMineInfo方法
	 */
	@Test
	public void testFindAdminMineInfo(){
		String adminId = "6081be24-08ea-4acc-98df-1ea06c71f957";
		User user = adminMineIService.findAdminMineInfo(adminId);
		logger.info("==================================================");
		logger.info("用户id:"+user.getUserid());
		logger.info("用户名:"+user.getName());
		logger.info("用户昵称:"+user.getNickname());
		logger.info("用户邮箱:"+user.getEmail());
		logger.info("用户手机号码:"+user.getPhonenumber());
		logger.info("用户角色:"+user.getRole()+""+user.getRoleName());
		logger.info("用户部门:"+user.getDept());
		logger.info("用户密码:"+user.getPassword());
		logger.info("用户所属公司:"+user.getCompany()+" "+user.getCompanyName());
		logger.info("==================================================");
	}
}
