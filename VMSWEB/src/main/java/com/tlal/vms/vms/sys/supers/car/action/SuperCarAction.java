package com.tlal.vms.vms.sys.supers.car.action;


import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.sys.supers.car.handler.SuperCarIHandler;

/**
 * 超级管理员-汽车逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/super/car")
public class SuperCarAction extends BaseAction{
	private static final long serialVersionUID = 1877523299211116686L;
	@Resource
	private SuperCarIHandler superCarHandler;
	@Override
	public Object getModel() {
		return superCarHandler.getModel();
	}
	
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/super/car/SuperCarMain.jsp")})
	public String goMain(){
		return superCarHandler.goMain();
	}
	
	/**
	 * 报表导出
	 * @return
	 */
	@Action(value="doReport")
	public String doReport(){
		return superCarHandler.doReport();
	}
	
	/**
	 * 添加
	 * @return
	 */
	@Action(value="doAdd",results={@Result(location="/pages/super/car/SuperCarMain.jsp")})
	public String doAdd(){
		return superCarHandler.doAdd();
	}
	
	/**
	 * 批量添加
	 * @return
	 */
	@Action(value="doAddBatch",results={@Result(location="/pages/super/car/SuperCarMain.jsp")})
	public String doAddBatch(){
		return superCarHandler.doAddBatch(some,someFileName,someContentType);
	}
	
	/**
	 * 错误详情记录文件查看
	 * @return
	 */
	@Action(value="detailError",results={@Result(location="/pages/super/car/SuperCarMain_goErrView.jsp")})
	public String detailError(){
		return superCarHandler.detailError();
	}
	
	/**
	 * 下载错误详情文件
	 * @return
	 */
	@Action(value="doErrFileDownload",results={@Result(location="/pages/super/car/SuperCarMain_goErrView.jsp")})
	public String doErrFileDownload(){
		return superCarHandler.doErrFileDownload();
	}
	
	/**
	 * 模板下载
	 * @return
	 */
	@Action(value="download")
	public String download(){
		return superCarHandler.download();
	}
	
	/**
	 * 验证车牌号是否可用
	 * @return
	 */
	@Action(value="isPalteNumExists")
	public String isPalteNumExists(){
		return superCarHandler.isPalteNumExists();
	}
	/**
	 * 错误详情文件删除
	 */
	@Action(value="doErrFileDel",results={@Result(location="/pages/super/car/SuperCarMain_goErrView.jsp")})
	public String doErrFileDel(){
		return superCarHandler.doErrFileDel();
	}
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value="doDel",results={@Result(location="/pages/super/car/SuperCarMain.jsp")})
	public String doDel(){
		return superCarHandler.doDel();
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@Action(value="doEdit",results={@Result(location="/pages/super/car/SuperCarMain.jsp")})
	public String doEdit(){
		return superCarHandler.doEdit();
	}
	
	private File some;//上传文件
	private String someFileName;//上传文件文件名
	private String someContentType;//上传文件类型

	public File getSome() {
		return some;
	}

	public void setSome(File some) {
		this.some = some;
	}

	public String getSomeFileName() {
		return someFileName;
	}

	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}

	public String getSomeContentType() {
		return someContentType;
	}

	public void setSomeContentType(String someContentType) {
		this.someContentType = someContentType;
	}
}
