package com.tlal.vms.vms.func.admin.car.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.admin.car.action.AdminCarModel;

/**
 * 管理员-汽车逻辑控制器-处理类接口
 * @author Administrator
 *
 */
public interface AdminCarIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public AdminCarModel getModel();
	
	/**
	 * 列表页面
	 * @return
	 */
	public String goMain();
}
