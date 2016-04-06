package com.tlal.vms.vms.sys.supers.company.dto;

import java.io.Serializable;

/**
 * 公司实体类
 * @author Administrator
 *
 */
public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8124107166514634839L;
	//公司id
	private String company_id;
	//公司名字
	private String company_name;
	//地址
	private String address;
	//电话
	private String telephone;
	//总经理
	private String manager;
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
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
