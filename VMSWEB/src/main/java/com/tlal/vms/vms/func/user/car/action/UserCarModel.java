package com.tlal.vms.vms.func.user.car.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;

public class UserCarModel {
	private PageModel pageModel = new PageModel();
	private UserCarSearch search = new UserCarSearch();
	private List<Car> cars = new ArrayList<Car>();
	
	private CarStatusEnum[] status;
	private CarOriginEnum[] origins;
	
	private SBook sbook;
	
	private List<Map<String, String>> companies;
	private String isZongGongsi;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public UserCarSearch getSearch() {
		return search;
	}
	public void setSearch(UserCarSearch search) {
		this.search = search;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public CarStatusEnum[] getStatus() {
		return status;
	}
	public void setStatus(CarStatusEnum[] status) {
		this.status = status;
	}
	public CarOriginEnum[] getOrigins() {
		return origins;
	}
	public void setOrigins(CarOriginEnum[] origins) {
		this.origins = origins;
	}
	public SBook getSbook() {
		return sbook;
	}
	public void setSbook(SBook sbook) {
		this.sbook = sbook;
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

