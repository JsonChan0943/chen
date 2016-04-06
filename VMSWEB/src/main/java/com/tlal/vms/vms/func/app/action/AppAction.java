package com.tlal.vms.vms.func.app.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSON;
import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.app.pojo.AppEJB;
import com.tlal.vms.vms.func.app.service.AppIService;

/**
 * Android应用程序访问程序入口
 * @author Administrator
 *
 */
@Namespace("/app")
@Scope("prototype")
public class AppAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(AppAction.class);

	private static final long serialVersionUID = 3071552226246575566L;
	
	private AppModel model = new AppModel();
	@Override
	public Object getModel() {
		return model;
	}
	@Resource
	private AppIService appService;
	
	/**
	 * 根据车牌号查找车辆信息
	 * @return
	 */
	@Action(value="findCarByPlateNum")
	public String findCarByPlateNum(){
		logger.info(WebUtil.getCurrentUserInfo()+"----APP应用程序根据车牌号查询车辆信息----");
		String plate_num = model.getPlate_num();
		AppEJB ejb = appService.findCarByPlateNum(plate_num);
		logger.info(WebUtil.getCurrentUserInfo()+"----APP应用程序根据车牌号查询车辆信息:"+JSON.toJSONString(ejb)+"----");
		super.writeJson(ejb);
		logger.info(WebUtil.getCurrentUserInfo()+"----APP应用程序根据车牌号查询车辆信息完毕----");
		return SUCCESS;
	}
}
