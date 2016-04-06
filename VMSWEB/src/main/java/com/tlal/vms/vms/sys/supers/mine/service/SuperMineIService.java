package com.tlal.vms.vms.sys.supers.mine.service;

import com.tlal.vms.vms.sys.login.entity.User;


public interface SuperMineIService {
	
	/**
	 * 根据id查找超级管理员的信息
	 * @param userid
	 * @return
	 */
	public User findSuperMineInfo(String userid);
}
