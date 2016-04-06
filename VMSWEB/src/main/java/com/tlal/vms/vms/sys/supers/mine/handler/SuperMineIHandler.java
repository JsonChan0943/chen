package com.tlal.vms.vms.sys.supers.mine.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.sys.supers.mine.action.SuperMineModel;

public interface SuperMineIHandler extends VMSIHandler{
	
	/**
	 * 获取模型
	 * @return
	 */
	public SuperMineModel getModel();
	
	/**
	 * 列表显示我的信息
	 * @return
	 */
	public String goMain();
	
	/**
	 * 我的信息编辑
	 * @return
	 */
	public String myInfoEdit();
	
	/**
	 * 修改密码
	 * @return
	 */
	public String editPwd();
}
