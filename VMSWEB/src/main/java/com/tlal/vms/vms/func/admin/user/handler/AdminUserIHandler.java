package com.tlal.vms.vms.func.admin.user.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.admin.user.action.AdminUserModel;

public interface AdminUserIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public AdminUserModel getModel() ;
	
	/**
	 * 列表
	 * @return
	 */
	public String goMain();
	
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
	 * 增加
	 * @return
	 */
	public String doAdd();
	
	/**
	 * 判断用户是否存在 工号
	 * @return
	 */
	public String isUserExists();
}
