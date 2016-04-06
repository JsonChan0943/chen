package com.tlal.vms.vms.func.admin.user.pojo;

import java.io.Serializable;

public class AdminUserPOJO implements Serializable{
	private static final long serialVersionUID = -1208109532779475302L;
	//用户id
	private String userid;
	//用户名称
	private String name;
	//用户昵称
	private String nickname;
	//邮箱
	private String email;
	//手机号码
	private String phonenumber;
	//部门
	private String dept;
	//公司
	private String company;
	//公司名字
	private String companyName;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
