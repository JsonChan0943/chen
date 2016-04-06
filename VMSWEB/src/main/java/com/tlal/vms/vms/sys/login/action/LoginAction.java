package com.tlal.vms.vms.sys.login.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.sys.login.handler.LoginIHandler;

/**
 * 项目名称：VMS
 * 类描述：登陆控制的Action
 */
@Namespace("/login")
@Scope("prototype")
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 4907742518949115311L;
	@Resource
	private LoginIHandler loginHandler;
	
	@Override
	public Object getModel() {
		return loginHandler.getModel();
	}
	
	
	/**
	 * 去到登陆页面
	 * @return
	 */
	@Action(value="toLogin",results={@Result(type="dispatcher",location="/pages/login/login.jsp")})
	public String toLogin(){
		return loginHandler.toLogin();
	}
	
	/**
	 * 登陆
	 * @return
	 */
	@Action(value="doLogin",results={
			@Result(name="super",type="dispatcher",location="/pages/super/SuperMain.jsp"),
			@Result(name="admin",type="dispatcher",location="/pages/admin/AdminMain.jsp"),
			@Result(name="user",type="dispatcher",location="/pages/user/UserMain.jsp"),	
			@Result(name="login",type="dispatcher",location="/pages/login/login.jsp")	
		}
	)
	public String doLogin(){
		return loginHandler.doLogin();
	}
	/**
	 * 登出
	 * @return
	 */
	@Action(value="loginOut",results={@Result(type="dispatcher",location="/pages/login/login.jsp")})	
	public String loginOut(){
		return loginHandler.loginOut();
	}
	
}
