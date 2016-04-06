package com.tlal.vms.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.enums.enumc.UserTypeEnum;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.user.action.AdminUserSearch;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.func.admin.user.service.AdminUserIService;
import com.tlal.vms.vms.sys.login.entity.User;

/**
 * AdminUserServiceTest
 * @author chenhuaijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class AdminUserServiceTest {
	private static Logger logger = LoggerFactory.getLogger(AdminUserServiceTest.class);  
	@Resource
	private AdminUserIService adminUserService;
	/**
	 * testFindUserByPage
	 */
	@Test
	public void testFindUserByPage(){
		AdminUserSearch search = new AdminUserSearch();
		search.setToPage(2);
		Pager<AdminUserPOJO> pager = adminUserService.findUsersByPage(search);
		logger.info("==================================================");
		logger.info("总记录数："+pager.getCount());
		logger.info("本次查询记录数："+pager.getFindCnt());
		for(AdminUserPOJO pojo:pager.getList()){
			logger.info("======================================");
			logger.info("用户id："+pojo.getUserid());
			logger.info("用户名称："+pojo.getName());
			logger.info("用户昵称："+pojo.getNickname());
			logger.info("邮箱："+pojo.getEmail());
			logger.info("手机号码："+pojo.getPhonenumber());
			logger.info("部门："+pojo.getDept());
			logger.info("公司："+pojo.getCompany()+" "+pojo.getCompanyName());
		}
		logger.info("==================================================");
	}

	/**
	 * testAddUser
	 */
	public void testAddUser(){
		User user = new User();
		user.setUserid("111111");
		user.setNickname("nickname");
		user.setName("name");
		user.setEmail("chenhuaijie@aliyun.com");
		user.setPhonenumber("18989898737");
		user.setDept("科技部");
		user.setPassword("123245");
		user.setCompany("1001");
		user.setRole(UserTypeEnum.USER.getEnValue());
		adminUserService.addUser(user);
	}

	/**
	 * testDeleteUserById
	 */
	@Test
	public void testDeleteUserById(){
		adminUserService.deleteUserById("111111");
	}

	/**
	 * testResetPwd
	 */
	@Test
	public void testResetPwd(){
		adminUserService.resetUserPwd("111111");
	}

}
