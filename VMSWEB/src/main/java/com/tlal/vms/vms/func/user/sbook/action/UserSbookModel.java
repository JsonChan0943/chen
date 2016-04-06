package com.tlal.vms.vms.func.user.sbook.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.ISEmpireEnum;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;

public class UserSbookModel {
	private PageModel pageModel = new PageModel();
	private UserSbookSearch search = new UserSbookSearch();
	private List<UserSBookPOJO> sbooks = new ArrayList<UserSBookPOJO>();
	
	private CarOriginEnum[] orgins;
	private ISEmpireEnum[] status;
	private List<Map<String, String>> users;
	
	private String idsbook;
	private SBook sbook;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public UserSbookSearch getSearch() {
		return search;
	}
	public void setSearch(UserSbookSearch search) {
		this.search = search;
	}
	public List<UserSBookPOJO> getSbooks() {
		return sbooks;
	}
	public void setSbooks(List<UserSBookPOJO> sbooks) {
		this.sbooks = sbooks;
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
	public String getIdsbook() {
		return idsbook;
	}
	public void setIdsbook(String idsbook) {
		this.idsbook = idsbook;
	}
	public SBook getSbook() {
		return sbook;
	}
	public void setSbook(SBook sbook) {
		this.sbook = sbook;
	}
}
