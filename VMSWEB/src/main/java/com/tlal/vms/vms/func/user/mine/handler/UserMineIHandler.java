package com.tlal.vms.vms.func.user.mine.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.user.mine.action.UserMineModel;

public interface UserMineIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public UserMineModel getModel() ;

	/**
	 * 我的信息
	 * @return
	 */
	public String goMain();
	
	/**
	 * 编辑我的信息
	 * @return
	 */
	public String myInfoEdit();
	
	/**
	 * 修改密码
	 * @return
	 */
	public String editPwd();
}
