package com.tlal.vms.vms.sys.supers.car.handler;

import java.io.File;

import com.tlal.vms.base.handler.VMSIHandler;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarModel;

public interface SuperCarIHandler extends VMSIHandler{
	/**
	 * 获取模型
	 * @return
	 */
	public SuperCarModel getModel();
	
	/**
	 * 列表页面
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
	 * 判断车牌号是否存在
	 * @return
	 */
	public String isPalteNumExists();
	
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
	 * 批量增加汽车信息
	 * @return
	 */
	public String doAddBatch(File some,String someFileName,String someContentType);
	
	/**
	 * 下载模板
	 * @return
	 */
	public String download();
	
	/**
	 * 错误详情记录文件查看
	 * @return
	 */
	public String detailError();
	
	/**
	 * 下载错误详情
	 * @return
	 */
	public String doErrFileDownload();
	
	/**
	 * 删除错误详情文件
	 * @return
	 */
	public String doErrFileDel();
}
