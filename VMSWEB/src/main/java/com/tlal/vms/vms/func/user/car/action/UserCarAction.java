package com.tlal.vms.vms.func.user.car.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.user.car.handler.UserCarIHandler;

/**
 * 用户-车辆逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/user/car")
public class UserCarAction extends BaseAction{
	private static final long serialVersionUID = 5154530675312702429L;
	@Resource
	private UserCarIHandler userCarHandler;
	
	@Override
	public Object getModel() {
		return userCarHandler.getModel();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/user/car/UserCarMain.jsp")})
	public String goMain(){
		return userCarHandler.goMain();
	}
	
	/**
	 * 租赁汽车
	 * @return
	 */
	@Action(value="doRentCar",results={@Result(location="/pages/user/car/UserCarMain.jsp")})
	public String doRentCar(){
		return userCarHandler.doRentCar();
	}
}
