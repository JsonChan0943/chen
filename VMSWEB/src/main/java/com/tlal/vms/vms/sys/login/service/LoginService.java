package com.tlal.vms.vms.sys.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.login.entity.User;

/**
 * 项目名称：VMS
 * 类描述： 登录逻辑服务实现类
 * 作者：陈怀结
 */
@Service
@Transactional(rollbackFor = Exception.class)  
public class LoginService implements LoginIService {

	@Resource
	private UserDAO userDAO;
	
	/**
	 * 登陆方法的实现
	 */
	@Override
	public User doLogin(User user) {
		if(user!=null){
			User dtoUser = userDAO.findByUserName(user.getName());
			if(dtoUser!=null){
				return dtoUser;
			}
		}
		return null;
	}
}
