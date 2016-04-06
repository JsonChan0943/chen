package com.tlal.vms.vms.func.user.car.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.enums.enumc.ISEmpireEnum;
import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.car.action.UserCarModel;
import com.tlal.vms.vms.func.user.car.action.UserCarSearch;
import com.tlal.vms.vms.func.user.car.service.UserCarIService;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;

public class UserCarHandler extends VMSHandler implements UserCarIHandler{
	private static final Logger logger = LoggerFactory.getLogger(UserCarHandler.class);
	
	@Resource
	private UserCarIService userCarService;
	@Resource
	private SuperCompanyIService superConpanyService;
	
	//==================================productModel===================================
	private UserCarModel productModel;
	@Override
	public UserCarModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new UserCarModel();
			}
		}
		return productModel;
	}
	
	public UserCarModel getExtendModel() {
		return null;
	}

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
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：车辆信息列表----");
		productModel.setStatus(CarStatusEnum.values());
		productModel.setOrigins(CarOriginEnum.values());
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		UserCarSearch search = productModel.getSearch();
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
			Pager<Car> page = userCarService.findCarByPage(search);
			productModel.setCars(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info("----用户：车辆信息列表->车辆记录加载成功----");
		} catch (Exception e) {
			logger.info("----用户：车辆信息列表->车辆记录加载失败----");
			LogUtil.log(e);
		}
		logger.info("----用户：车辆信息列表结束----");
		return SUCCESS;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)  
	public String doRentCar() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆----");
		SBook sbook = productModel.getSbook();
		sbook.setIdsbook(UUID.randomUUID().toString().trim());
		sbook.setIsexpire(ISEmpireEnum.N.getEnValue());//默认未过期
		try {
			userCarService.rentCar(sbook);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆->添加记录到SBook表成功----");
//			String str = null;
//			str.length();
			userCarService.setCarRentState(sbook.getCarid().toString().trim());//设置车辆已被租用
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆->设置车辆已被租用成功----");
			addMsg("车辆租赁成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(),
					"租赁汽车,汽车id是："+sbook.getCarid(), LogOpeTypeEnum.RENTCAR.getEnValue());
		} catch (Exception e) {
			addMsg("车辆租赁失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：租赁车辆结束----");
		return goMain();
	}

}
