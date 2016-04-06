package com.tlal.vms.vms.func.admin.car.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.car.action.AdminCarModel;
import com.tlal.vms.vms.func.admin.car.action.AdminCarSearch;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.admin.car.service.AdminCarIService;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;

/**
 * 管理员-汽车逻辑控制器-处理类
 * @author Administrator
 *
 */
public class AdminCarHandler extends VMSHandler implements AdminCarIHandler{
	private static final Logger logger = LoggerFactory.getLogger(AdminCarHandler.class);
	
	@Resource
	private AdminCarIService adminCarService;
	@Resource
	private SuperCompanyIService superConpanyService;
	
	//=================================productModel===================================
	private AdminCarModel productModel;
	@Override
	public AdminCarModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new AdminCarModel();
			}
		}
		return productModel;
	}
	
	public AdminCarModel getExtendModel() {
		return null;
	}
	
	//=================================productModel===================================
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
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：车辆列表显示----");
		productModel.setStatus(CarStatusEnum.values());
		productModel.setOrigins(CarOriginEnum.values());
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		AdminCarSearch search = productModel.getSearch();
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
			Pager<Car> page = adminCarService.findCarByPage(search);
			productModel.setCars(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),page.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：车辆列表显示->成功获取用户记录----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：车辆列表显示->获取用户记录失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：车辆列表显示结束----");
		return SUCCESS;
	}

}
