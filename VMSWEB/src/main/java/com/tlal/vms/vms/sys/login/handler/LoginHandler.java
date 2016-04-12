package com.tlal.vms.vms.sys.login.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.enums.enumc.UserTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.ConstantsIHandler;
import com.tlal.vms.base.utils.EnumUtil;
import com.tlal.vms.base.utils.SendMailUtil;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.login.action.LoginModel;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.login.service.LoginIService;
import com.tlal.vms.vms.sys.supers.company.dao.CompanyDAO;

public class LoginHandler extends VMSHandler implements LoginIHandler{
	private static final Logger logger = LoggerFactory.getLogger(LoginHandler.class);

	private LoginModel productModel;
	
	//===============================productModel===========================================
	@Override
	public LoginModel getModel() {
		if(null == productModel){
			productModel = getExtendModel();
			if(null == productModel){
				productModel = new LoginModel();
			}
		}
		return productModel;
	}
	
	/**
	 * 获取拓展模型
	 * @return
	 */
	public LoginModel getExtendModel(){
		return null;
	}
	

	@Resource
	private LoginIService loginService;
	@Resource
	private CompanyDAO companyDAO;
	
	//========================================toLogin========================================
	/**
	 * 去到登录界面
	 */
	@Override
	public String toLogin() {
		logger.info("----去到登陆页面----");
		return SUCCESS;
	}

	//========================================doLogin========================================
	/**
	 * 登录
	 */
	@Override
	public String doLogin() {
		logger.info("----用户登陆系统----");
		User user = loginService.doLogin(productModel.getUser());
		HttpSession  session = WebUtil.getCurrentSession();
		HttpServletRequest request = WebUtil.getCurrentServletRequest();
		if(user==null){//用户名不存在，返回登陆页面，并提示"用户名不存在"
//			request.setAttribute(ConstantsIHandler.MSG, "用户名不存在！");
			addMsg("用户名不存在！", TipTypeEnum.ERROR);
			return LOGIN;
		}else{		//存在
			//密码错误，返回登陆页面，并提示"密码错误"
			if(!user.getPassword().trim().toString().equals(productModel.getUser().getPassword())){
//				request.setAttribute(ConstantsIHandler.MSG, "密码错误！");
				addMsg("密码错误！", TipTypeEnum.ERROR);
				return LOGIN;
			}else{
				String userType = user.getRole();
				session.setAttribute(ConstantsIHandler.LOGIN_USER, user);
				session.setAttribute(ConstantsIHandler.ROLE, EnumUtil.getNameByValue(UserTypeEnum.class, userType));
				session.setAttribute(ConstantsIHandler.NAME, user.getName());
				session.setAttribute(ConstantsIHandler.NICKNAME, user.getNickname());
				session.setAttribute(ConstantsIHandler.USERID, user.getUserid());
				session.setAttribute(ConstantsIHandler.PASSWORD, user.getPassword());
				session.setAttribute(ConstantsIHandler.COMPANY, user.getCompany());
				session.setAttribute(ConstantsIHandler.COMPANY_NAME, companyDAO.findCompanyById(user.getCompany().trim()).getCompany_name());
				logger.info("----用户登陆成功！登陆用户名:"+user.getName()+" 用户昵称："+user.getNickname()+"----");
				SendMailUtil.sendCommonMail("chenhuaijie@aliyun.com", "登陆成功",
						"----用户登陆成功！登陆用户名:"+user.getName()+" 用户昵称："+user.getNickname()+"----");
				if(userType.toString().trim().equals(UserTypeEnum.SUPER.getEnValue().toString().trim())){
					return UserTypeEnum.SUPER.getEnValue();
				}else if(userType.toString().trim().equals(UserTypeEnum.ADMIN.getEnValue().toString().trim())){
					return UserTypeEnum.ADMIN.getEnValue();
				}else{
					return UserTypeEnum.USER.getEnValue();
				}
			}
		}
	}

	//========================================loginOut========================================
	/**
	 * 登出
	 */
	@Override
	public String loginOut() {
		logger.info(WebUtil.getCurrentUserInfo()+"----退出系统----");
		//销毁sessio
		WebUtil.getCurrentSession().removeAttribute(ConstantsIHandler.NAME);
		WebUtil.getCurrentSession().removeAttribute(ConstantsIHandler.NICKNAME);
		WebUtil.getCurrentSession().removeAttribute(ConstantsIHandler.USERID);
		WebUtil.getCurrentSession().removeAttribute(ConstantsIHandler.PASSWORD);
		WebUtil.getCurrentSession().removeAttribute(ConstantsIHandler.COMPANY);
		WebUtil.getCurrentSession().invalidate();
		return SUCCESS;
	}
	
}
