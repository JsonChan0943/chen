package com.tlal.vms.vms.sys.supers.company.action;

import java.util.ArrayList;
import java.util.List;

import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.sys.supers.company.dto.Company;

public class SuperCompanyModel {
	private PageModel pageModel = new PageModel();
	private SuperCompanySearch search = new SuperCompanySearch();
	private List<Company> companies = new ArrayList<Company>();
	
	private Company company;
	private String company_id;
	
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public SuperCompanySearch getSearch() {
		return search;
	}
	public void setSearch(SuperCompanySearch search) {
		this.search = search;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
}
