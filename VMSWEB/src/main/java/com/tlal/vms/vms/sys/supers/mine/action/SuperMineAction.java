package com.tlal.vms.vms.sys.supers.mine.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.mine.handler.SuperMineIHandler;

/**
 * 超级管理员-我的信息
 * @author Administrator
 *
 */
@Namespace("/super/mine")
public class SuperMineAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(SuperMineAction.class);

	@Resource
	private SuperMineIHandler superMineHandler;
	
	@Override
	public Object getModel() {
		return superMineHandler.getModel();
	}
	
	
	/**
	 * 我的信息
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/super/SuperInfo.jsp")})
	public String goMain(){
		return superMineHandler.goMain();
	}
	
	/**
	 * 编辑我的信息
	 * @return
	 */
	@Action(value="myInfoEdit",results={@Result(location="/pages/super/SuperInfo.jsp")})
	public String myInfoEdit(){
		return superMineHandler.myInfoEdit();
	}
	
	/**
	 * 密码修改
	 * @return
	 */
	@Action(value="editPwd")
	public String editPwd(){
		return superMineHandler.editPwd();
	}
}
