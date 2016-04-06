package com.tlal.vms.vms.sys.supers.log.action;

import com.tlal.vms.base.utils.PageModel;

public class SuperLogSearch{
	private Integer toPage;
	/**从哪一行开始*/
	public Integer startRow;
	/**一页的大小*/
	public Integer pageSize = PageModel.PAGE_SIZE;

	private String operate_type;
	
	public Integer getToPage() {
		return toPage;
	}
	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}
	public String getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(String operate_type) {
		this.operate_type = operate_type;
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
