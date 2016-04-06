package com.tlal.vms.vms.sys.supers.company.handler;

import java.io.File;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanyModel;

public interface SuperCompanyIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public SuperCompanyModel getModel();
	
	/**
	 * 列表
	 * @return
	 */
	public String goMain();
	
	/**
	 * 增加
	 * @return
	 */
	public String doAdd();
	
	/**
	 * 判断公司Id是否可用
	 * @return
	 */
	public String isCompanyIdExists();
	
	/**
	 * 删除
	 * @return
	 */
	public String doDel();
	
	/**
	 * 修改
	 * @return
	 */
	public String doEdit();
	
	/**
	 * 
	 * @return
	 */
	public String fileUpLoad(File file,String fileName,String someContentType);
	
	/**
	 * 报表导出
	 * @return
	 */
	public String doReport();
}
