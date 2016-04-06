package com.tlal.vms.base.utils;

import com.tlal.vms.base.sysparam.SysParams;

/**
 * 分页工具
 * @author Administrator
 *
 */
public class PageModel{
	public static final int PAGE_SIZE = SysParams.getPage_size();
	/**当前页*/
	private Integer current_page;
	/**总页数*/
	private Long total_page;
	/**要去到哪一页*/
	private Integer toPage;
	private Long totalData;
	private Integer from;
	private Integer to;
	private int findCnt;
	
	/**
	 * 根据传入的记录数计算总页数
	 * @param accouns
	 */
	public void countPage(Long accounts,int findCnt){
		this.findCnt = findCnt;
		setTotalData(accounts);
		if(accounts%PAGE_SIZE==0){
			this.total_page = accounts/PAGE_SIZE;
		}else{
			this.total_page = accounts/PAGE_SIZE+1;
		}
	}
	
	public Integer getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}
	public Long getTotal_page() {
		return total_page;
	}
	public void setTotal_page(Long total_page) {
		this.total_page = total_page;
	}
	public Integer getToPage() {
		return toPage;
	}
	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}

	public Long getTotalData() {
		return totalData;
	}

	public void setTotalData(Long totalData) {
		this.totalData = totalData;
	}

	public Integer getFrom() {
		return (current_page-1)*PageModel.PAGE_SIZE+1;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return (current_page-1)*PageModel.PAGE_SIZE+findCnt;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public int getFindCnt() {
		return findCnt;
	}

	public void setFindCnt(int findCnt) {
		this.findCnt = findCnt;
	}
}
