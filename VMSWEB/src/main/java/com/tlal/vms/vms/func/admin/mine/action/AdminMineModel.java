package com.tlal.vms.vms.func.admin.mine.action;

import java.util.ArrayList;
import java.util.List;

import com.tlal.vms.vms.sys.login.entity.User;

public class AdminMineModel {
	private List<User> list = new ArrayList<User>();
	private User admin;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

}
