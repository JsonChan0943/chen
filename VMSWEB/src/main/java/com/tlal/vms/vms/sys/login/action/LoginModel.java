package com.tlal.vms.vms.sys.login.action;

import java.io.Serializable;

import com.tlal.vms.vms.sys.login.entity.User;

public class LoginModel implements Serializable{
	private static final long serialVersionUID = 8923358283170848216L;
	/**用户信息*/
	private User user;
	private String userid;
	private String oldPwd;
	private String newPwd;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
