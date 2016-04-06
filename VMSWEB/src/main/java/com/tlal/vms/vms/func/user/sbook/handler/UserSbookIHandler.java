package com.tlal.vms.vms.func.user.sbook.handler;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookModel;

public interface UserSbookIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public UserSbookModel getModel() ;
	
	/**
	 * 列表显示
	 * @return
	 */
	public String goMain();
	
	/**
	 * 租出车辆
	 * @return
	 */
	public String doReturnCar();
	/**
	 * 删除租赁信息
	 * @return
	 */
	public String doDel();
	
	/**
	 * 删除租赁信息
	 * @return
	 */
	public String doEdit();
	/**
	 * 修复功能
	 * @return
	 */
	public String doAll();
	
	public String doReport();
}
