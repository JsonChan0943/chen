package com.tlal.vms.vms.func.admin.user.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.admin.user.handler.AdminUserIHandler;

/**
 * 管理员-用户逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/admin/user")
public class AdminUserAction extends BaseAction{
	private static final long serialVersionUID = 516496322997104192L;

	@Resource
	private AdminUserIHandler adminUserHandler;
	
	@Override
	public Object getModel() {
		return adminUserHandler.getModel();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/admin/user/AdminUserMain.jsp")})
	public String goMain(){
		return adminUserHandler.goMain();
	}
	
	/**
	 * 删除用户信息
	 * @return
	 */
	@Action(value="doDel",results={@Result(location="/pages/admin/user/AdminUserMain.jsp")})
	public String doDel(){
		return adminUserHandler.doDel();
	}
	
	/**
	 * 重置密码
	 * @return
	 */
	@Action(value="resetPwd")
	public String resetPwd(){
		return adminUserHandler.resetPwd();
	}
	
	/**
	 * 增加
	 * @return
	 */
	@Action(value="doAdd",results={@Result(location="/pages/admin/user/AdminUserMain.jsp")})
	public String doAdd(){
		return adminUserHandler.doAdd();
	}
	
	/**
	 * 添加用户时验证用户名是否可用
	 * @return
	 */
	@Action(value="isUserExists")
	public String isUserExists(){
		return adminUserHandler.isUserExists();
	}
}
