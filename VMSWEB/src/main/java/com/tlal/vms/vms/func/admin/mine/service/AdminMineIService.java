package com.tlal.vms.vms.func.admin.mine.service;

import com.tlal.vms.vms.sys.login.entity.User;


public interface AdminMineIService {
	/**
	 * 根据userid查找用户信息
	 * @param userid
	 * @return
	 */
	public User findAdminMineInfo(String userid);
}
