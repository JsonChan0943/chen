package com.tlal.vms.vms.func.user.mine.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.user.mine.handler.UserMineIHandler;

/**
 * 用户-我的信息逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/user/mine")
public class UserMineAction extends BaseAction{
	private static final long serialVersionUID = 8116858471046490745L;
	@Resource
	private UserMineIHandler userMineHandler;
	
	@Override
	public Object getModel() {
		return userMineHandler.getModel();
	}
	
	/**
	 * 我的信息
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/user/UserInfo.jsp")})
	public String goMain(){
		return userMineHandler.goMain();
	}
	
	/**
	 * 编辑我的信息
	 * @return
	 */
	@Action(value="myInfoEdit",results={@Result(location="/pages/user/UserInfo.jsp")})
	public String myInfoEdit(){
		return userMineHandler.myInfoEdit();
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@Action(value="editPwd")
	public String editPwd(){
		return userMineHandler.editPwd();
	}
}
