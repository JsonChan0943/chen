package com.tlal.vms.vms.sys.supers.admin.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.sys.supers.admin.handler.SuperAdminIHandler;

/**
 * 超级管理员-管理员逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/super/admin")
public class SuperAdminAction extends BaseAction{
	private static final long serialVersionUID = -4864838633372669795L;
	@Resource
	private SuperAdminIHandler superAdminHandler;
	
	@Override
	public Object getModel() {
		return superAdminHandler.getModel();
	}

	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/super/admin/SuperAdminMain.jsp")})
	public String goMain(){
		return superAdminHandler.goMain();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="doReport",results={@Result(location="/pages/super/admin/SuperAdminMain.jsp")})
	public String doReport(){
		return superAdminHandler.doReport();
	}
	
	/**
	 * 添加管理员
	 * @return
	 */
	@Action(value="doAdd",results={@Result(location="/pages/super/admin/SuperAdminMain.jsp")})
	public String doAdd(){
		return superAdminHandler.doAdd();
	}
	
	/**
	 * 删除管理员
	 * @return
	 */
	@Action(value="doDel",results={@Result(location="/pages/super/admin/SuperAdminMain.jsp")})
	public String doDel(){
		return superAdminHandler.doDel();
	}
	
	/**
	 * 重置密码
	 * @return
	 */
	@Action(value="resetPwd")
	public String resetPwd(){
		return superAdminHandler.resetPwd();
	}
	
	/**
	 * 添加用户时验证用户名是否可用
	 * @return
	 */
	@Action(value="isUserExists")
	public String isUserExists(){
		return superAdminHandler.isUserExists();
	}
}
