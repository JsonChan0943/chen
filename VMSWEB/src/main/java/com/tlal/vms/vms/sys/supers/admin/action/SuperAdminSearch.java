package com.tlal.vms.vms.sys.supers.admin.action;

import com.tlal.vms.base.utils.PageModel;

public class SuperAdminSearch{
	private Integer toPage;
	/**从哪一行开始*/
	public Integer startRow;
	/**一页的大小*/
	public Integer pageSize = PageModel.PAGE_SIZE;

	private String name;
	private String nickname;
	private String email;
	private String phonenumber;
	private String dept;
	private String company;
	
	public Integer getToPage() {
		return toPage;
	}
	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	
}
