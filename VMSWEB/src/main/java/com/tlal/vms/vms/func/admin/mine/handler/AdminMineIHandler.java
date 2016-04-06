package com.tlal.vms.vms.func.admin.mine.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.admin.mine.action.AdminMineModel;

public interface AdminMineIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public AdminMineModel getModel();
	
	/**
	 * 列表
	 * @return
	 */
	public String goMain();
	
	/**
	 * 我的信息修改
	 * @return
	 */
	public String myInfoEdit();
	
	/**
	 * 修改密码
	 * @return
	 */
	public String editPwd();
}
