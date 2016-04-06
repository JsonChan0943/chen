package com.tlal.vms.vms.func.admin.car.action;

import com.tlal.vms.base.utils.PageModel;

/**
 * 管理员-汽车逻辑控制器-search
 * @author Administrator
 *
 */
public class AdminCarSearch {
	private Integer toPage;
	/**从哪一行开始*/
	public Integer startRow;
	/**一页的大小*/
	public Integer pageSize = PageModel.PAGE_SIZE;

	private String name;
	private String plate_num;
	private String type;
	private String status;
	private String origin;
	
	private String company;//部门信息
	
	private String isZongGongsi;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIsZongGongsi() {
		return isZongGongsi;
	}
	public void setIsZongGongsi(String isZongGongsi) {
		this.isZongGongsi = isZongGongsi;
	}
}
