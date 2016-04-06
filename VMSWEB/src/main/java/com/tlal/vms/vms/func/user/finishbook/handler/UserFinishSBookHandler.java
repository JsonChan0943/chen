package com.tlal.vms.vms.func.user.finishbook.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.ISEmpireEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookModel;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookSearch;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;
import com.tlal.vms.vms.func.user.finishbook.service.UserFinishSBookIService;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

public class UserFinishSBookHandler extends VMSHandler implements UserFinishSBookIHandler{
	private static final Logger logger = LoggerFactory.getLogger(UserFinishSBookHandler.class);

	@Resource
	private UserFinishSBookIService userFinishSBookService;
	@Resource
	private UserDAO userDAO;
	//====================================productModel======================================
	private UserFinishSBookModel productModel;
	@Override
	public UserFinishSBookModel getModel() {
		if(null==productModel){
			productModel = getExtendModel();
			if(null==productModel){
				productModel = new UserFinishSBookModel();
			}
		}
		return productModel;
	}
	
	public UserFinishSBookModel getExtendModel() {
		return null;
	}

	@Override
	public String goMain() {
		logger.info(WebUtil.getCurrentUserInfo()+"----用户:finishsBook信息列表----");
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
		UserFinishSBookSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		if(!getUserCompany().equals(SysParams.getHeadquarters().trim())){
			search.setCompany(getUserCompany());
		}
		try {
			Pager<UserFinishSBookPOJO> page = userFinishSBookService.findFinishSBookByPage(search);
			productModel.setFinishSBooks(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----用户:finishsBook信息列表->加载记录成功----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----用户:finishsBook信息列表->加载记录失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----用户:finishsBook信息列表结束----");
		return SUCCESS;
	}

}
