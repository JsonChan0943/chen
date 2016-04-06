package com.tlal.vms.vms.func.user.sbook.action;

import com.tlal.vms.base.utils.PageModel;


public class UserSbookSearch {
	private Integer toPage;
	/**从哪一行开始*/
	public Integer startRow;
	/**一页的大小*/
	public Integer pageSize = PageModel.PAGE_SIZE;
	
	//经办人id
	private String userid;
	//乘租方
	private String lessee;
	//出租放方\n租出车辆的公司
	private String lease;
	//设备名称
    private String name;
    //车牌号
    private String plate_num;
    //型号
    private String type;
    //来源
    private String origin;
	//使用部门
	private String usedept;
	//是否过期
	private String isexpire;
	
	//公司信息 
	private String company;
	
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLessee() {
		return lessee;
	}
	public void setLessee(String lessee) {
		this.lessee = lessee;
	}
	public String getLease() {
		return lease;
	}
	public void setLease(String lease) {
		this.lease = lease;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getUsedept() {
		return usedept;
	}
	public void setUsedept(String usedept) {
		this.usedept = usedept;
	}
	public String getIsexpire() {
		return isexpire;
	}
	public void setIsexpire(String isexpire) {
		this.isexpire = isexpire;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
