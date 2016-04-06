package com.tlal.vms.vms.func.user.finishbook.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.ISEmpireEnum;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;

public class UserFinishSBookModel {
	private PageModel pageModel = new PageModel();
	private UserFinishSBookSearch search = new UserFinishSBookSearch();
	private List<UserFinishSBookPOJO> finishSBooks = new ArrayList<UserFinishSBookPOJO>();
	
	private CarOriginEnum[] orgins;
	private ISEmpireEnum[] status;
	private List<Map<String, String>> users;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public UserFinishSBookSearch getSearch() {
		return search;
	}
	public void setSearch(UserFinishSBookSearch search) {
		this.search = search;
	}
	public List<UserFinishSBookPOJO> getFinishSBooks() {
		return finishSBooks;
	}
	public void setFinishSBooks(List<UserFinishSBookPOJO> finishSBooks) {
		this.finishSBooks = finishSBooks;
	}
	public CarOriginEnum[] getOrgins() {
		return orgins;
	}
	public void setOrgins(CarOriginEnum[] orgins) {
		this.orgins = orgins;
	}
	public ISEmpireEnum[] getStatus() {
		return status;
	}
	public void setStatus(ISEmpireEnum[] status) {
		this.status = status;
	}
	public List<Map<String, String>> getUsers() {
		return users;
	}
	public void setUsers(List<Map<String, String>> users) {
		this.users = users;
	}
}
