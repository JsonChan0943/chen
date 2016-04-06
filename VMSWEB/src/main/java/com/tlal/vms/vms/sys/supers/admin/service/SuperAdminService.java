package com.tlal.vms.vms.sys.supers.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.sysparam.SysParams;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.admin.action.SuperAdminSearch;
import com.tlal.vms.vms.sys.supers.admin.pojo.SuperAdminPOJO;
import com.tlal.vms.vms.sys.supers.company.dao.CompanyDAO;
import com.tlal.vms.vms.sys.supers.company.dto.Company;

@Service
@Transactional(rollbackFor = Exception.class)  
public class SuperAdminService implements SuperAdminIService{
	@Resource
	private UserDAO userDAO;
	@Resource
	private CompanyDAO companyDAO;
	
	/**
	 * 分页查找
	 */
	@Override
	public Pager<SuperAdminPOJO> findAdminsByPage(SuperAdminSearch search) {
		Pager<SuperAdminPOJO> page = new Pager<SuperAdminPOJO>();
		page.setList(userDAO.findAdminsByPage(search));
		page.setCount(userDAO.countAdmins(search));
		return page;
	}

	/**
	 * 根据id删除管理员
	 */
	@Override
	public String deleteAdminById(String userid) {
		if(userid!=null){
			userDAO.deleteUser(userid);
			return userid;
		}
		return null;
		
	}

	/**
	 * 重置管理员的密码
	 */
	@Override
	public String resetAdminPwd(String userid) {
		if(userid!=null){
			User user = userDAO.findById(userid);
			if(user!=null){
				user.setPassword(SysParams.getResetpwd());
				userDAO.updateUser(user);
				return userid;
			}
		}
		return null;
	}

	/**
	 * 添加管理员
	 */
	@Override
	public User addAdmin(User user) {
		if(user!=null){
			userDAO.addUser(user);
			return user;
		}
		return null;
	}

	@Override
	public List<Company> findAllCompany() {
		return companyDAO.findAllCompany();
	}

	@Override
	public List<SuperAdminPOJO> listAllAdmins() {
		// TODO Auto-generated method stub
		return userDAO.listAdmins();
	}
}
