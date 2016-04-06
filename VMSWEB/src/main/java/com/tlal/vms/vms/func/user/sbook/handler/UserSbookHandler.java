package com.tlal.vms.vms.func.user.sbook.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.ISEmpireEnum;
import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.func.user.finishbook.entity.FinishSBook;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookModel;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookSearch;
import com.tlal.vms.vms.func.user.sbook.dao.SBookDAO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;
import com.tlal.vms.vms.func.user.sbook.service.UserSbookIService;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.ylink.eu.report.ReportUtil;
import com.ylink.eu.util.tools.CharSetUtil;
import com.ylink.eu.util.tools.enums.ExportEnum;

public class UserSbookHandler extends VMSHandler implements UserSbookIHandler{
	private static final Logger logger = LoggerFactory.getLogger(UserSbookHandler.class);

	@Resource
	private UserSbookIService userSbookService;
	@Resource
	private UserDAO userDAO;
	@Resource
	private CarDAO carDAO;
	@Resource
	private SBookDAO sBookDAO;
	
	//===============================productModel=====================================
	private UserSbookModel productModel;
	@Override
	public UserSbookModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new UserSbookModel();
			}
		}
		return productModel;
	}
	
	public UserSbookModel getExtendModel() {
		return null;
	}

	//===============================goMain=====================================
	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：Sbook信息列表----");
		List<User> users = new ArrayList<User>();
		if(!getUserCompany().equals(SysParams.getHeadquarters().trim())){
			users = userDAO.findAllUsersByConpanyId(getUserCompany());
		}else{
			users = userDAO.findAllUsers();
		}
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		for(User u:users){
			map = new HashMap<String, String>();
			map.put("id", u.getUserid());
			map.put("name", u.getName());
			list.add(map);
		}
		productModel.setUsers(list);
		productModel.setOrgins(CarOriginEnum.values());
		productModel.setStatus(ISEmpireEnum.values());
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		UserSbookSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		if(!getUserCompany().equals(SysParams.getHeadquarters().trim())){
			search.setCompany(getUserCompany());
		}
		try {
			Pager<UserSBookPOJO> page = userSbookService.findSBookByPage(search);
			productModel.setSbooks(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：Sbook信息列表->记录加载成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：Sbook信息列表->记录加载失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：Sbook信息列表结束----");
		return SUCCESS;
	}

	//===============================doReturnCar=====================================
	@Override
	@Transactional
	public String doReturnCar() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆----");
		String idsbook =  productModel.getIdsbook().toString().trim();
		SBook sbook = userSbookService.findSbookById(idsbook);
		FinishSBook finishSBook = new FinishSBook();
		BeanUtils.copyProperties(sbook, finishSBook);//这几个值是空的，需要去掉
		Date nowDate = new Date();
		if(sbook.getEnddate().before(nowDate)){//已过期还车
			finishSBook.setIsexpire(ISEmpireEnum.Y.getEnValue());
		}else{
			finishSBook.setIsexpire(ISEmpireEnum.N.getEnValue());
		}
		finishSBook.setActual_date(nowDate);//实际归还时间
		try {
			userSbookService.addFinishSBook(finishSBook);//添加记录到已完成表
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆->添加记录到已完成表成功----");
			userSbookService.deleteSbookById(idsbook);//删除未完成记录
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆->删除未完成记录成功----");
			userSbookService.setCarUnRent(sbook.getCarid().toString().trim());//设置车辆未被租用
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆->设置车辆未被租用成功----");
			addMsg("车辆退租成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(),
					"汽车退租,汽车id是："+sbook.getCarid(), LogOpeTypeEnum.RETURNSBOOK.getEnValue());
		} catch (Exception e) {
			addMsg("车辆退租失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆->失败----");
			LogUtil.log(e);
			
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：退租车辆结束----");
		return goMain();
	}

	//===============================doDel=====================================
	@Override
	public String doDel() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息----");
		String idsBook = productModel.getIdsbook();
		SBook sBook = userSbookService.findSbookById(idsBook.trim());
		try {
			userSbookService.deleteSbookById(idsBook);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息->删除租赁信息陈功----");
			userSbookService.setCarUnRent(sBook.getCarid().toString().trim());//设置车辆未被租用
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息->设置车辆未被租用----");
			addMsg("删除成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(),
					"删除租赁信息,id是："+idsBook, LogOpeTypeEnum.DELSBOOK.getEnValue());
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：删除租赁信息结束----");
		return goMain();
	}

	//===============================doEdit=====================================
	@Override
	public String doEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改租赁信息----");
		SBook sBook = productModel.getSbook();
		String idsBook = sBook.getIdsbook();
		SBook sBook2 = userSbookService.findSbookById(idsBook.trim());
		sBook2.setLessee(sBook.getLessee());
		sBook2.setLease(sBook.getLease());
		sBook2.setStartdate(sBook.getStartdate());
		sBook2.setEnddate(sBook.getEnddate());
		sBook2.setDriver(sBook.getDriver());
		sBook2.setComment(sBook.getComment());
		sBook2.setUsedept(sBook.getUsedept());
		userSbookService.updateSbook(sBook2);
		//判断车辆是否过期
		Date now = new Date();
		if(sBook2.getEnddate().before(now)){
			sBookDAO.setExpire(sBook2.getIdsbook().toString().trim());
		}else{
			sBookDAO.setUnExpire(sBook2.getIdsbook().toString().trim());
		}
		addMsg("修改成功！", TipTypeEnum.SUCCESS);
		superLogService.addLog(getUserInfoForLog(), new Date(),
				"修改租赁信息,id是："+idsBook, LogOpeTypeEnum.EDITSBOOK.getEnValue());
		logger.info(WebUtil.getCurrentUserInfo()+"----用户：修改租赁信息结束----");
		return goMain();
	}

	//===============================doAll=====================================
	@Override
	public String doAll() {
		List<SBook> list = sBookDAO.findAllSBook();
		for(SBook book:list){
			Car car = carDAO.findCarById(book.getCarid());
			List<AdminUserPOJO> users = userDAO.findUsersByCompany(car.getCompany());
			if(users!=null&&users.size()>0){
				String useridString = users.get(0).getUserid();
				book.setUserid(useridString);
				sBookDAO.updateSbook(book);
			}
		}
		return NONE;
	}
	
	//===============================doReport=====================================
	@Override
	public String doReport() {
		List<UserSBookPOJO> sbooks = null;
		if(getUserCompany().equals(SysParams.getHeadquarters().trim())){
			sbooks = userSbookService.findAllSBooks();
		}else{
			sbooks = userSbookService.findAllSBooksByUser(getUserCompany().trim());
		}
		Map<String,Object> map = new HashMap<String,Object>();
		int i= sbooks==null?0:sbooks.size();
		map.put("SIZE", i);
		map.put("title", "租赁信息列表清单");
		ReportUtil.exportToResponse(ExportEnum.excel,"report-jasper-common", "UserSbookList_goMain.jasper", sbooks,map,CharSetUtil.UTF_8, "租赁信息列表清单");
		return NONE;
	}

}
