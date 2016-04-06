package com.tlal.vms.vms.func.user.sbook.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.user.sbook.handler.UserSbookIHandler;

/**
 * 用户-租赁逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/user/sbook")
public class UserSbookAction extends BaseAction{
	private static final long serialVersionUID = -1647010349419732558L;
	
	@Resource
	private UserSbookIHandler userSbookHandler;
	
	@Override
	public Object getModel() {
		return userSbookHandler.getModel();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/user/sbook/UserSBookMain.jsp")})
	public String goMain(){
		return userSbookHandler.goMain();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="doReport",results={@Result(location="/pages/user/sbook/UserSBookMain.jsp")})
	public String doReport(){
		return userSbookHandler.doReport();
	}
	
	/**
	 * 租出车辆
	 * @return
	 */
	@Action(value="doReturnCar",results={@Result(location="/pages/user/sbook/UserSBookMain.jsp")})
	public String doReturnCar(){
		return userSbookHandler.doReturnCar();
	}
	
	/**
	 * 删除租赁信息
	 * @return
	 */
	@Action(value="doDel",results={@Result(location="/pages/user/sbook/UserSBookMain.jsp")})
	public String doDel(){
		return userSbookHandler.doDel();
	}
	
	/**
	 * 删除租赁信息
	 * @return
	 */
	@Action(value="doEdit",results={@Result(location="/pages/user/sbook/UserSBookMain.jsp")})
	public String doEdit(){
		return userSbookHandler.doEdit();
	}
	
	/**
	 * 修复功能
	 * @return
	 */
	@Action(value="repaire")
	public String doAll(){
		return userSbookHandler.doAll();
	}
}
