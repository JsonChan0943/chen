package com.tlal.vms.vms.func.admin.mine.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.admin.mine.handler.AdminMineIHandler;

/**
 * 管理员自身信息逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/admin/mine")
public class AdminMineAction extends BaseAction{
	private static final long serialVersionUID = -7917598745152634565L;
	
	@Resource
	private AdminMineIHandler adminMineHandler;
	
	@Override
	public Object getModel() {
		return adminMineHandler.getModel();
	}
	
	/**
	 * 我的信息
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/admin/AdminInfo.jsp")})
	public String goMain(){
		return adminMineHandler.goMain();
	}
	
	/**
	 * 编辑我的信息
	 * @return
	 */
	@Action(value="myInfoEdit",results={@Result(location="/pages/admin/AdminInfo.jsp")})
	public String myInfoEdit(){
		return adminMineHandler.myInfoEdit();
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@Action(value="editPwd")
	public String editPwd(){
		return adminMineHandler.editPwd();
	}
}
