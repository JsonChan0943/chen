package com.tlal.vms.vms.sys.supers.mine.action;

import java.util.ArrayList;
import java.util.List;

import com.tlal.vms.vms.sys.login.entity.User;

public class SuperMineModel {
	private List<User> list = new ArrayList<User>();
	private User user;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
