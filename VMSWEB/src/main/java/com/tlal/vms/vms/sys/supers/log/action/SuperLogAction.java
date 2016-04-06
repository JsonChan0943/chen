package com.tlal.vms.vms.sys.supers.log.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.sys.supers.log.handler.SuperLogIHandler;

/**
 * 超级管理员-业务日志逻辑控制器
 * @author Administrator
 *
 */
@Namespace("/super/log")
public class SuperLogAction extends BaseAction{
	private static final long serialVersionUID = -4864838633372669795L;
	
	@Resource
	private SuperLogIHandler superLogHandler;
	
	@Override
	public Object getModel() {
		return superLogHandler.getModel();
	}

	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/super/log/SuperLogMain.jsp")})
	public String goMain(){
		return superLogHandler.goMain();
	}
}
