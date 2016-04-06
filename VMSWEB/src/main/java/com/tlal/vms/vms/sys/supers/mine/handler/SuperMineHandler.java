package com.tlal.vms.vms.sys.supers.mine.handler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.mine.action.SuperMineAction;
import com.tlal.vms.vms.sys.supers.mine.action.SuperMineModel;

public class SuperMineHandler extends VMSHandler implements SuperMineIHandler{
	private static final Logger logger = LoggerFactory.getLogger(SuperMineAction.class);
	
	@Resource
	private UserDAO userDAO;
	//==================================productModel==============================
	private SuperMineModel productModel;
	
	@Override
	public SuperMineModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new SuperMineModel();
			}
		}
		return productModel;
	}
	
	public SuperMineModel getExtendModel() {
		// TODO Auto-generated method stub
		return null;
	}

	//==================================goMain==============================
	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示----");
		String userid = (String) WebUtil.getCurrentSession().getAttribute("userid");
		List<User> list = new ArrayList<User>();
		list.add(userDAO.findById(userid));
		productModel.setList(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示完毕----");
		return SUCCESS;
	}

	//==================================myInfoEdit==============================
	@Override
	public String myInfoEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示编辑----");
		User dto = productModel.getUser();
		User user = userDAO.findById(dto.getUserid());
		user.setName(dto.getName());
		user.setNickname(dto.getNickname());
		user.setEmail(dto.getEmail());
		user.setPhonenumber(dto.getPhonenumber());
		try {
			userDAO.updateUser(user);
			addMsg("信息修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示编辑->成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示编辑->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：我的信息显示编辑完毕----");
		return goMain();
	}

	//==================================editPwd==============================
	@Override
	public String editPwd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改密码----");
		JsonModel jsonModel = new JsonModel();
		User admin = productModel.getUser();
		User user = userDAO.findById(admin.getUserid());
		user.setPassword(admin.getPassword());
		try {
			userDAO.updateUser(user);
			jsonModel.setSuccess(true);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改密码->成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改密码->失败----");
			LogUtil.log(e);
		}
		super.writeJson(jsonModel);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改密码完毕----");
		return NONE;
	}

}
