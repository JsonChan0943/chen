package com.tlal.vms.vms.func.admin.user.service;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.user.action.AdminUserSearch;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.sys.login.entity.User;

public interface AdminUserIService {
	/**
	 * 分页查找用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pager<AdminUserPOJO> findUsersByPage(AdminUserSearch search);
	
	/**
	 * 根据id删除用户
	 * @param userid
	 * @return
	 */
	public String deleteUserById(String userid);
	
	/**
	 * 重置用户的密码
	 * @param userid
	 */
	public String resetUserPwd(String userid);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public User addUser(User user);
}
