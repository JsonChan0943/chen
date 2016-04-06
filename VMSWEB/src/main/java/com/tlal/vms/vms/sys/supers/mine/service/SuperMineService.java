package com.tlal.vms.vms.sys.supers.mine.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

@Service
@Transactional(rollbackFor = Exception.class)  
public class SuperMineService implements SuperMineIService{
	@Resource
	private UserDAO userDAO;
	
	/**
	 * 根据id查找超级管理员的信息
	 */
	@Override
	public User findSuperMineInfo(String userid) {
		if(userid!=null){
			User user = userDAO.findById(userid);
			if(user!=null){
				return user;
			}
		}
		return null;
	}
}
