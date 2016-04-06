package com.tlal.vms.vms.func.admin.mine.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

@Service
@Transactional(rollbackFor = Exception.class)  
public class AdminMineService implements AdminMineIService{
	@Resource
	private UserDAO userDAO;
	
	/**
	 * 根据userid查找用户信息
	 */
	@Override
	public User findAdminMineInfo(String userid) {
		if(userid!=null){
			User user = userDAO.findById(userid);
			if(user!=null){
				return user;
			}
		}
		return null;
	}
}
