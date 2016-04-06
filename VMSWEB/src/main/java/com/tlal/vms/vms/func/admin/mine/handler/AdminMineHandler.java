package com.tlal.vms.vms.func.admin.mine.handler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.ConstantsIHandler;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.mine.action.AdminMineModel;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

public class AdminMineHandler extends VMSHandler implements AdminMineIHandler{
	private static final Logger logger = LoggerFactory.getLogger(AdminMineHandler.class);
	
	@Resource
	private UserDAO userDAO;
	
	//===============================productModel=================================
	
	private AdminMineModel productModel;
	
	@Override
	public AdminMineModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new AdminMineModel();
			}
		}
		return productModel;
	}
	
	public AdminMineModel getExtendModel() {
		return null;
	}

	//===============================goMain=================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：我的信息列表显示----");
		String userid = (String) WebUtil.getCurrentSession().getAttribute(ConstantsIHandler.USERID);
		List<User> list = new ArrayList<User>();
		User user = userDAO.findById(userid.trim());
		list.add(user);
		productModel.setList(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：我的信息列表显示完毕----");
		return SUCCESS;
	}

	//===============================myInfoEdit=================================
	/**
	 * 我的信息编辑
	 */
	@Override
	public String myInfoEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：编辑我的信息----");
		User dto = productModel.getAdmin();
		User user = userDAO.findById(dto.getUserid());
		user.setName(dto.getName());
		user.setNickname(dto.getNickname());
		user.setEmail(dto.getEmail());
		user.setPhonenumber(dto.getPhonenumber());
		try {
			userDAO.updateUser(user);
			addMsg("信息修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：编辑我的信息->成功----");
		} catch (Exception e) {
			addMsg("信息修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：编辑我的信息->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：编辑我的信息结束----");
		return goMain();
	}

	//===============================editPwd=================================
	/**
	 * 修改密码
	 */
	@Override
	public String editPwd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改密码----");
		JsonModel jsonModel = new JsonModel();
		User admin = productModel.getAdmin();
		User user = userDAO.findById(admin.getUserid());
		user.setPassword(admin.getPassword());
		try {
			userDAO.updateUser(user);
			jsonModel.setSuccess(true);
			super.writeJson(jsonModel);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改密码->成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改密码->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改密码结束----");
		return NONE;
	}

}
