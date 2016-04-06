package com.tlal.vms.vms.sys.supers.company.action;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.sys.supers.company.handler.SuperCompanyIHandler;

/**
 * 超级管理员维护子公司信息
 * @author Administrator
 *
 */
@Namespace("/super/company")
@Scope("prototype")
public class SuperCompanyAction extends BaseAction{
	private static final long serialVersionUID = 8440250895065115212L;
	
	@Resource
	private SuperCompanyIHandler superCompanyHandler;

	@Override
	public Object getModel() {
		return superCompanyHandler.getModel();
	}
	
	/**
	 * 列表
	 * @return
	 */
	@Action(value="goMain",results={@Result(type="dispatcher",location="/pages/super/company/SuperCompanyMain.jsp")})
	public String goMain(){
		return superCompanyHandler.goMain();
	}
	
	/**
	 * 报表导出
	 * @return
	 */
	@Action(value="doReport")
	public String doReport(){
		return superCompanyHandler.doReport();
	}
	
	/**
	 * 添加子公司记录
	 * @return
	 */
	@Action(value="doAdd",results={@Result(type="dispatcher",location="/pages/super/company/SuperCompanyMain.jsp")})
	public String doAdd(){
		return superCompanyHandler.doAdd();
	}
	
	/**
	 * 判断id是否可用
	 * @return
	 */
	@Action(value="isCompanyIdExists")
	public String isCompanyIdExists(){
		return superCompanyHandler.isCompanyIdExists();
	}
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value="doDel",results={@Result(type="dispatcher",location="/pages/super/company/SuperCompanyMain.jsp")})
	public String doDel(){
		return superCompanyHandler.doDel();
	}
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value="doEdit",results={@Result(type="dispatcher",location="/pages/super/company/SuperCompanyMain.jsp")})
	public String doEdit(){
		return superCompanyHandler.doEdit();
	}
	
	/**
	 * 上传文件
	 * @return
	 */
	@Action(value="fileUpLoad",results={@Result(type="dispatcher",location="/pages/super/company/SuperCompanyMain.jsp")})
	public String fileUpLoad(){
		return superCompanyHandler.fileUpLoad(some,someFileName,someContentType);
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
