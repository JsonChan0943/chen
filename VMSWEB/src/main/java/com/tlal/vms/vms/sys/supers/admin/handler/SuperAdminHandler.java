package com.tlal.vms.vms.sys.supers.admin.handler;

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
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.admin.action.SuperAdminModel;
import com.tlal.vms.vms.sys.supers.admin.action.SuperAdminSearch;
import com.tlal.vms.vms.sys.supers.admin.pojo.SuperAdminPOJO;
import com.tlal.vms.vms.sys.supers.admin.service.SuperAdminIService;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.ylink.eu.report.ReportUtil;
import com.ylink.eu.util.tools.CharSetUtil;
import com.ylink.eu.util.tools.enums.ExportEnum;

public class SuperAdminHandler extends VMSHandler implements SuperAdminIHandler{
	private static final Logger logger = LoggerFactory.getLogger(SuperAdminHandler.class);
	
	private SuperAdminModel productModel;
	
	@Resource
	private SuperAdminIService superAdminService;
	@Resource
	private UserDAO userDAO;
	
	//===============================productModel===========================================
	
	/**
	 * 获取模型
	 */
	public SuperAdminModel getModel() {
		if(null == productModel){
			productModel = getExtendModel();
			if(null == productModel){
				productModel = new SuperAdminModel();
			}
		}
		return productModel;
	}
	
	/**
	 * 获取拓展模型
	 * @return
	 */
	public SuperAdminModel getExtendModel(){
		return null;
	}
	
	//===============================goMain===========================================
	@Override
	public String goMain() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for(Company company:superAdminService.findAllCompany()){
			Map<String, String> map  = new HashMap<String,String>();
			map.put("company_id", company.getCompany_id());
			map.put("company_name", company.getCompany_name());
			list.add(map);
		}
		productModel.setCompanies(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：管理员用户信息列表显示----");
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		SuperAdminSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		Pager<SuperAdminPOJO> page;
		try {
			page = superAdminService.findAdminsByPage(search);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：管理员用户信息列表显示->成功----");
			productModel.setAdmins(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：管理员用户信息列表显示->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：管理员用户信息列表显示结束----");
		return SUCCESS;
	}
	
	//===============================doReport===========================================
	@Override
	public String doReport() {
		List<SuperAdminPOJO> admins = superAdminService.listAllAdmins();
		Map<String,Object> map = new HashMap<String,Object>();
		int i= admins.size();
		map.put("SIZE", i);
		map.put("title", "系统管理员清单");
		ReportUtil.exportToResponse(ExportEnum.excel,"report-jasper-common", "SuperAdminList_goMain.jasper", admins,map,CharSetUtil.UTF_8, "系统管理员清单");
		return NONE;
	}
	
	//===============================doAdd===========================================
	@Override
	public String doAdd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员----");
		User user = productModel.getUser();
		user.setUserid(UUID.randomUUID().toString());
		user.setRole(UserTypeEnum.ADMIN.getEnValue());
		user.setPassword(SysParams.getResetpwd().trim().toString());
		try {
			superAdminService.addAdmin(user);
			addMsg("添加成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "添加管理员,id:"+user.getUserid()+",用户名："+
			user.getName(),LogOpeTypeEnum.ADDADMIN.getEnValue());
		} catch (Exception e) {
			addMsg("添加失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员结束----");
		return goMain();
	}
	
	//===============================doDel===========================================
	@Override
	public String doDel() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除管理员----");
		String userid = productModel.getUserid();
		try {
			superAdminService.deleteAdminById(userid);
			addMsg("删除成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除管理员->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "删除管理员,id:"+userid,LogOpeTypeEnum.DELADMIN.getEnValue());
		} catch (Exception e) {
			addMsg("删除失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除管理员->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员： 删除管理员结束----");
		return goMain();
	}
	
	//===============================resetPwd===========================================
	@Override
	public String resetPwd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：重置管理员密码----");
		JsonModel jsonModel = new JsonModel();
		String userid = productModel.getUserid();
		String resultString;
		try {
			resultString = superAdminService.resetAdminPwd(userid);
			if(resultString!=null){
				jsonModel.setSuccess(true);
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：重置管理员密码->成功----");
			}else {
				jsonModel.setSuccess(false);
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：重置管理员密码->失败----");
			}
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：重置管理员密码->异常----");
		}
		super.writeJson(jsonModel);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：重置管理员密码结束----");
		return NONE;
	}
	
	//===============================isUserExists===========================================
	@Override
	public String isUserExists() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员前判断用户名是否可用----");
		JsonModel jsonModel = new JsonModel();
		String name = productModel.getName();
		try {
			User user = userDAO.findByUserName(name);
			if(user!=null){
				jsonModel.setSuccess(true);
				jsonModel.setMsg("用户名已存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员前判断用户名是否可用->用户名已存在----");
			}else{
				jsonModel.setSuccess(false);
				jsonModel.setMsg("用户名不存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员前判断用户名是否可用->用户名不存在----");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员前判断用户名是否可用->异常----");
		}
		super.writeJson(jsonModel);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加管理员前判断用户名是否可用结束----");
		return NONE;
	}

	
}
