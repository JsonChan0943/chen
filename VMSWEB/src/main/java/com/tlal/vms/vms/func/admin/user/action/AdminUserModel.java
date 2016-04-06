package com.tlal.vms.vms.func.admin.user.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.sys.login.entity.User;

public class AdminUserModel {
	private PageModel pageModel = new PageModel();
	private AdminUserSearch search = new AdminUserSearch();
	private List<AdminUserPOJO> users = new ArrayList<AdminUserPOJO>();
	
	private User user;
	private String userid;
	private String name;
	
	private List<Map<String, String>> companies;
	private String isZongGongsi;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public AdminUserSearch getSearch() {
		return search;
	}
	public void setSearch(AdminUserSearch search) {
		this.search = search;
	}
	public List<AdminUserPOJO> getUsers() {
		return users;
	}
	public void setUsers(List<AdminUserPOJO> users) {
		this.users = users;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Map<String, String>> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Map<String, String>> companies) {
		this.companies = companies;
	}
	public String getIsZongGongsi() {
		return isZongGongsi;
	}
	public void setIsZongGongsi(String isZongGongsi) {
		this.isZongGongsi = isZongGongsi;
	}
}
