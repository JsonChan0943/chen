package com.tlal.vms.vms.sys.supers.log.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogModel;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogSearch;
import com.tlal.vms.vms.sys.supers.log.entity.LogDTO;
import com.tlal.vms.vms.sys.supers.log.service.SuperLogIService;

public class SuperLogHandler extends VMSHandler implements SuperLogIHandler{
	private static final Logger logger = LoggerFactory.getLogger(SuperLogHandler.class);

	@Resource
	private SuperLogIService superLogService;
	
	//=================================productModel=================================
	private SuperLogModel productModel;
	/**
	 * 获取模型
	 */
	@Override
	public SuperLogModel getModel() {
		if(null==productModel){
			productModel =  getExtendModel();
			if(null==productModel){
				productModel = new SuperLogModel();
			}
		}
		return productModel;
	}

	/**
	 * 获取拓展模型
	 * @return
	 */
	public SuperLogModel getExtendModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//=================================productModel=================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		productModel.setOperateTypies(LogOpeTypeEnum.values());
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：业务日志信息列表显示----");
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		SuperLogSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		Pager<LogDTO> page;
		try {
			page = superLogService.findLogsByPage(search);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：业务日志信息列表显示->成功----");
			productModel.setLogs(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：业务日志信息列表显示->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：业务日志信息列表显示结束----");
		return SUCCESS;
	}

}
