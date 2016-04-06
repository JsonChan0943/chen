package com.tlal.vms.vms.sys.supers.admin.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.admin.pojo.SuperAdminPOJO;


public class SuperAdminModel {
	private PageModel pageModel = new PageModel();
	private SuperAdminSearch search = new SuperAdminSearch();
	private List<SuperAdminPOJO> admins = new ArrayList<SuperAdminPOJO>();
	
	private User user;
	private String userid;
	private String name;
	
	private List<Map<String, String>> companies;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public SuperAdminSearch getSearch() {
		return search;
	}
	public void setSearch(SuperAdminSearch search) {
		this.search = search;
	}
	public List<SuperAdminPOJO> getAdmins() {
		return admins;
	}
	public void setAdmins(List<SuperAdminPOJO> admins) {
		this.admins = admins;
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
}
