package com.tlal.vms.vms.sys.supers.company.action;

import com.tlal.vms.base.utils.PageModel;

public class SuperCompanySearch {
	private Integer toPage;
	/**从哪一行开始*/
	public Integer startRow;
	/**一页的大小*/
	public Integer pageSize = PageModel.PAGE_SIZE;

	//公司名字
	private String company_name;
	//地址
	private String address;
	//电话
	private String telephone;
	//总经理
	private String manager;
	
	public Integer getToPage() {
		return toPage;
	}
	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}
	public Integer getStartRow() {
		return (toPage-1)*pageSize;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
}
