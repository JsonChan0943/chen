package com.tlal.vms.vms.func.user.finishbook.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.user.finishbook.handler.UserFinishSBookIHandler;

/**
 * 用户-台账逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/user/finishSBook")
public class UserFinishSBookAction extends BaseAction{
	private static final long serialVersionUID = 300263961066925367L;
	@Resource
	private UserFinishSBookIHandler userFinishSBookHandler;
	@Override
	public Object getModel() {
		return userFinishSBookHandler.getModel();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/user/finishsbook/UserFinishSBookMain.jsp")})
	public String goMain(){
		return userFinishSBookHandler.goMain();
	}
}
