package com.tlal.vms.vms.sys.supers.log.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogModel;

public interface SuperLogIHandler extends VMSIHandler{
	
	/**
	 * 获取模型
	 * @return
	 */
	public SuperLogModel getModel() ;
	
	/**
	 * 列表显示
	 * @return
	 */
	public String goMain();
}
