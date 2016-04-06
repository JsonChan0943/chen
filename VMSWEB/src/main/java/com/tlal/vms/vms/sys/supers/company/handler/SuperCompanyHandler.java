package com.tlal.vms.vms.sys.supers.company.handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanyModel;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanySearch;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;
import com.ylink.eu.report.ReportUtil;
import com.ylink.eu.util.tools.CharSetUtil;
import com.ylink.eu.util.tools.enums.ExportEnum;

public class SuperCompanyHandler extends VMSHandler implements SuperCompanyIHandler{
	private static final Logger logger = LoggerFactory.getLogger(SuperCompanyHandler.class);
	
	@Resource
	private SuperCompanyIService superCompanyService;
	
	//===============================productModel===========================================
	private SuperCompanyModel productModel;
		
	@Override
	public SuperCompanyModel getModel() {
		if(null == productModel){
			productModel = getExtendModel();
			if(null == productModel){
				productModel = new SuperCompanyModel();
			}
		}
		return productModel;
	}
	
	/**
	 * 获取拓展模型
	 * @return
	 */
	public SuperCompanyModel getExtendModel(){
		return null;
	}

	//===============================goMain===========================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：子公司列表显示----");
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		SuperCompanySearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		try {
			Pager<Company> page = superCompanyService.findCompanyByPage(search);
			productModel.setCompanies(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：子公司列表显示->成功获取子公司记录----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：子公司列表显示->获取子公司记录失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：子公司列表显示结束----");
		return SUCCESS;
	}

	//===============================doAdd===========================================
	/**
	 * 增加
	 */
	@Override
	public String doAdd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司信息----");
		Company company = productModel.getCompany();
		try {
			superCompanyService.addCompany(company);
			addMsg("添加公司成功", TipTypeEnum.SUCCESS);
			superLogService.addLog(getUserInfoForLog(), new Date(), "添加子公司,id:"+company.getCompany_id()+",公司名："+
					company.getCompany_name(),LogOpeTypeEnum.ADDCOMPANY.getEnValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMsg("添加公司失败", TipTypeEnum.ERROR);
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司信息结束----");
		return goMain();
	}

	//===============================isCompanyIdExists================================
	/**
	 * 判断公司Id是否可用
	 */
	@Override
	public String isCompanyIdExists() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司前判断公司id是否可用----");
		JsonModel jsonModel = new JsonModel();
		String company_id = productModel.getCompany_id();
		try {
			Company company = superCompanyService.findCompanyById(company_id);
			if(company!=null){
				jsonModel.setSuccess(true);
				jsonModel.setMsg("此公司id已存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司前判断公司id是否可用->id已存在----");
			}else{
				jsonModel.setSuccess(false);
				jsonModel.setMsg("此公司id不存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司前判断公司id是否可用->id不存在----");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司前判断公司id是否可用->异常----");
		}
		super.writeJson(jsonModel);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加子公司前判断公司id是否可用结束----");
		return NONE;
	}

	//===============================doDel===========================================
	/**
	 * 删除
	 */
	@Override
	public String doDel() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除子公司信息----");
		String company_id = productModel.getCompany_id();
		try {
			superCompanyService.deleteCompanyById(company_id);
			addMsg("删除成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除子公司信息成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "删除子公司,id:"+company_id,LogOpeTypeEnum.ADDCOMPANY.getEnValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMsg("删除失败！", TipTypeEnum.ERROR);
			LogUtil.log(e);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除子公司信息异常----");
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除子公司信息结束----");
		return goMain();
	}

	//===============================doEdit===========================================
	/**
	 */
	@Override
	public String doEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改子公司信息----");
		Company company = productModel.getCompany();
		try {
			superCompanyService.updateCompany(company);
			addMsg("修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改子公司信息成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "修改子公司,id:"+company.getCompany_id()+",公司名："+company.getCompany_name(),
					LogOpeTypeEnum.EDITCOMPANY.getEnValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMsg("修改失败！", TipTypeEnum.ERROR);
			LogUtil.log(e);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改子公司信息异常----");
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改子公司信息结束----");
		return goMain();
	}

	/**
	 * 上传文件
	 */
	@Override
	public String fileUpLoad(File file,String fileName,String someContentType){
		if(file==null){
			addMsg("上传文件为空", TipTypeEnum.ERROR);
		}
		String folder = File.separator+"upload"+File.separator;//存放文件夹名
		String path = ServletActionContext.getServletContext().getRealPath(folder+fileName);//文件相对路径
		File outFile = new File(path);
		File parent = new File(outFile.getParent());//文件所在目录
		if(!parent.exists()){//不存在就先创建目录
			parent.mkdirs();
		}
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(new File(path)));
			byte[] bts = new byte[1024];
			int len = -1;
			while ((len = bis.read(bts))!=-1) {
				bos.write(bts,0,len);
			}
			addMsg("上传文件成功！", TipTypeEnum.SUCCESS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			addMsg("文件没有找到！", TipTypeEnum.ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			addMsg("IO异常！", TipTypeEnum.ERROR);
		} finally{
			try {
				if(bis!=null){bis.close();}
				if(bos!=null){bos.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return goMain();
	}

	@Override
	public String doReport() {
		List<Company> cars = superCompanyService.findAllCompany();
		Map<String,Object> map = new HashMap<String,Object>();
		int i= cars.size();
		map.put("SIZE", i);
		map.put("title", "系统公司信息清单");
		ReportUtil.exportToResponse(ExportEnum.excel,"report-jasper-common", "SuperCompanyList_goMain.jasper", cars,map,CharSetUtil.UTF_8, "系统公司信息清单");
		return NONE;
	}
}
