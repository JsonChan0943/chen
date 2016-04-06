package com.tlal.vms.vms.func.user.mine.handler;

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
import com.tlal.vms.vms.func.user.mine.action.UserMineModel;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

public class UserMineHandler extends VMSHandler implements UserMineIHandler{
	private static final Logger logger = LoggerFactory.getLogger(UserMineHandler.class);
	
	@Resource
	private UserDAO userDAO;
	//======================================produceModel================================
	private UserMineModel produceModel;
	@Override
	public UserMineModel getModel() {
		if(null==produceModel){
			produceModel = getExtendModel();
			if(null==produceModel){
				produceModel = new UserMineModel();
			}
		}
		return produceModel;
	}
	
	public UserMineModel getExtendModel() {
		return null;
	}

	//======================================goMain================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：显示我的信息----");
		String userid = (String) WebUtil.getCurrentSession().getAttribute("userid");
		List<User> list = new ArrayList<User>();
		list.add(userDAO.findById(userid));
		produceModel.setList(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：显示我的信息结束----");
		return SUCCESS;
	}

	//======================================myInfoEdit================================
	/**
	 * 编辑我的信息
	 */
	@Override
	public String myInfoEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：编辑我的信息----");
		User dto = produceModel.getUser();
		User user = userDAO.findById(dto.getUserid());
		/**
		 * 设置我的信息
		 */
		user.setName(dto.getName());
		user.setNickname(dto.getNickname());
		user.setEmail(dto.getEmail());
		user.setPhonenumber(dto.getPhonenumber());
		try {
			userDAO.updateUser(user);//修改我的信息
			addMsg("信息修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：编辑我的信息->成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：编辑我的信息->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：编辑我的信息结束----");
		return goMain();
	}

	//======================================editPwd================================
	/**
	 * 修改密码
	 */
	@Override
	public String editPwd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改密码----");
		JsonModel jsonModel = new JsonModel();
		User admin = produceModel.getUser();
		User user = userDAO.findById(admin.getUserid());
		user.setPassword(admin.getPassword());//重置密码
		try {
			userDAO.updateUser(user);//修改密码
			jsonModel.setSuccess(true);
			super.writeJson(jsonModel);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改密码->陈功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改密码->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改密码结束----");
		return NONE;
	}

}
