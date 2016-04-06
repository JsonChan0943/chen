package com.tlal.vms.vms.sys.login.service;

import com.tlal.vms.vms.sys.login.entity.User;

/**
 * 项目名称：VMS
 * 类描述： 登录逻辑服务实现类
 * 作者：陈怀结
 */
public interface LoginIService {
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User doLogin(User user);
}
