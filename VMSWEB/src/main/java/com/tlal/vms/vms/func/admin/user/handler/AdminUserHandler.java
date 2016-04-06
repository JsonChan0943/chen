package com.tlal.vms.vms.func.admin.user.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.enums.enumc.UserTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.user.action.AdminUserModel;
import com.tlal.vms.vms.func.admin.user.action.AdminUserSearch;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.func.admin.user.service.AdminUserIService;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;

public class AdminUserHandler extends VMSHandler implements AdminUserIHandler{
	private static final Logger logger = LoggerFactory.getLogger(AdminUserHandler.class);
	
	@Resource
	private AdminUserIService adminUserService;
	@Resource
	private UserDAO userDAO;
	@Resource
	private SuperCompanyIService superConpanyService;
	
	//=================================productModel===================================
	private AdminUserModel productModel;
	@Override
	public AdminUserModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new AdminUserModel();
			}
		}
		return productModel;
	}
	
	public AdminUserModel getExtendModel() {
		return null;
	}

	//=================================goMain===================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for(Company company:superConpanyService.findAllCompany()){
			Map<String, String> map  = new HashMap<String,String>();
			map.put("company_id", company.getCompany_id());
			map.put("company_name", company.getCompany_name());
			list.add(map);
		}
		productModel.setCompanies(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息列表显示----");
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		AdminUserSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		if(!getUserCompany().equals(SysParams.getHeadquarters().trim())){//非总公司管理员
			search.setCompany(getUserCompany());
			productModel.getSearch().setIsZongGongsi("no");
		}else{//总公司管理员
			productModel.getSearch().setIsZongGongsi("yes");
			productModel.setIsZongGongsi("yes");
		}
		try {
			Pager<AdminUserPOJO> page = adminUserService.findUsersByPage(search);
			productModel.setUsers(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息列表显示->成功加载用户记录----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息列表显示->加载用户记录失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息列表显示完毕----");
		return SUCCESS;
	}

	//=================================doDel===================================
	/**
	 * 删除
	 */
	@Override
	public String doDel() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息删除----");
		String userid = productModel.getUserid();
		try {
			adminUserService.deleteUserById(userid);
			addMsg("删除成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息删除->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "删除用户信息,id:"+userid,
					LogOpeTypeEnum.DELUSER.getEnValue());
		} catch (Exception e) {
			e.printStackTrace();
			addMsg("该用户关联到台账表里的记录！", TipTypeEnum.WARN);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息删除->该用户关联到台账表里的记录----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：用户信息删除结束----");
		return goMain();
	}

	//=================================resetPwd===================================
	/**
	 * 密码重置
	 */
	@Override
	public String resetPwd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：重置用户密码----");
		JsonModel jsonModel = new JsonModel();
		String userid = productModel.getUserid();
		try {
			String resultString = adminUserService.resetUserPwd(userid);
			if(resultString!=null){
				jsonModel.setSuccess(true);
				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：重置用户密码->成功----");
			}else {
				jsonModel.setSuccess(false);
				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：重置用户密码->失败----");
			}
			super.writeJson(jsonModel);
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：重置用户密码->异常----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：重置用户密码结束----");
		return NONE;
	}

	//=================================doAdd===================================
	/**
	 * 增加
	 */
	@Override
	public String doAdd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加用户----");
		User user = productModel.getUser();
		user.setUserid(UUID.randomUUID().toString());
		user.setRole(UserTypeEnum.USER.getEnValue());
		user.setPassword(SysParams.getResetpwd().trim().toString());
		user.setCompany(getUserCompany());
		try {
			adminUserService.addUser(user);
			addMsg("添加成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加用户->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "增加用户信息,id:"+user.getUserid()+",用户名："+user.getName(),
					LogOpeTypeEnum.ADDUSER.getEnValue());
		} catch (Exception e) {
			addMsg("添加失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加用户->失败----");
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加用户结束----");
		return goMain();
	}

	//=================================isUserExists===================================
	/**
	 * 判断用户是否存在
	 */
	@Override
	public String isUserExists() {
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加用户前判断用户名是否可以使用----");
		JsonModel jsonModel = new JsonModel();
		String name = productModel.getName();
		try {
			User user = userDAO.findByUserName(name);
			if(user!=null){
				jsonModel.setSuccess(true);
				jsonModel.setMsg("用户名已存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加用户前判断用户名是否可以使用->用户名已存在----");
			}else{
				jsonModel.setSuccess(false);
				jsonModel.setMsg("用户名不存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加用户前判断用户名是否可以使用->用户名不存在----");
			}
			super.writeJson(jsonModel);
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加用户前判断用户名是否可以使用->异常----");
			LogUtil.log(e);
		}
		return NONE;
	}

}
