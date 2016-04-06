package com.tlal.vms.vms.sys.login.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.sys.login.action.LoginModel;

public interface LoginIHandler extends VMSIHandler{
	
	/**
	 * 获取模型
	 * @return
	 */
	public LoginModel getModel();
	
	/**
	 * 去到登录页面
	 * @return
	 */
	public String toLogin();
	
	/**
	 * 登录
	 * @return
	 */
	public String doLogin();
	
	/**
	 * 登出
	 * @return
	 */
	public String loginOut();
	
}
