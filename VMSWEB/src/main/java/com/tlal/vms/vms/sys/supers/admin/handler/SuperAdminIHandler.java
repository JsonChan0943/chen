package com.tlal.vms.vms.sys.supers.admin.handler;

import com.tlal.vms.vms.sys.supers.admin.action.SuperAdminModel;

public interface SuperAdminIHandler {
	/**
	 * 获取模型
	 * @return
	 */
	public SuperAdminModel getModel();
	
	/**
	 * 列表
	 * @return
	 */
	public String goMain();
	
	/**
	 * 报表打印
	 * @return
	 */
	public String doReport();
	
	/**
	 * 增加
	 * @return
	 */
	public String doAdd();
	
	/**
	 * 删除
	 * @return
	 */
	public String doDel();
	
	/**
	 * 密码重置
	 * @return
	 */
	public String resetPwd();
	
	/**
	 * 判断用户是否存在
	 * @return
	 */
	public String isUserExists();
}
