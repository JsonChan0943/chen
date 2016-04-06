package com.tlal.vms.vms.func.user.finishbook.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookModel;

public interface UserFinishSBookIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public UserFinishSBookModel getModel() ;
	

	/**
	 * 列表显示
	 * @return
	 */
	public String goMain();
}
