package com.tlal.vms.vms.func.admin.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.user.action.AdminUserSearch;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

@Service
@Transactional(rollbackFor = Exception.class)  
public class AdminUserService implements AdminUserIService{
	@Resource
	private UserDAO userDAO;
	
	/**
	 * 分页查找
	 */
	@Override
	public Pager<AdminUserPOJO> findUsersByPage(AdminUserSearch search) {
		Pager<AdminUserPOJO> page = new Pager<AdminUserPOJO>();
		page.setList(userDAO.findUsersByPage(search));
		page.setCount(userDAO.countUsers(search));
		return page;
	}

	/**
	 * 根据id删除
	 */
	@Override
	public String deleteUserById(String userid) {
		if(userid!=null){
			userDAO.deleteUser(userid);
			return userid;
		}
		return null;
	}

	/**
	 * 重置用户密码
	 */
	@Override
	public String resetUserPwd(String userid) {
		if(userid!=null){
			User user = userDAO.findById(userid);
			if(user!=null){
				user.setPassword(SysParams.getResetpwd());
				userDAO.updateUser(user);
				return userid;
			}
		}
		return null;
	}

	/**
	 * 添加用户
	 */
	@Override
	public User addUser(User user) {
		if(user!=null){
			userDAO.addUser(user);
			return user;
		}
		return null;
	}

}
