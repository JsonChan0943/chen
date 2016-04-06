package com.tlal.vms.vms.sys.supers.log.action;

import java.util.ArrayList;
import java.util.List;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.sys.supers.log.entity.LogDTO;


public class SuperLogModel {
	private PageModel pageModel = new PageModel();
	private SuperLogSearch search = new SuperLogSearch();
	private List<LogDTO> logs = new ArrayList<LogDTO>();
	
	private LogOpeTypeEnum[] operateTypies;
	
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public SuperLogSearch getSearch() {
		return search;
	}
	public void setSearch(SuperLogSearch search) {
		this.search = search;
	}
	
	public List<LogDTO> getLogs() {
		return logs;
	}
	public void setLogs(List<LogDTO> logs) {
		this.logs = logs;
	}
	public LogOpeTypeEnum[] getOperateTypies() {
		return operateTypies;
	}
	public void setOperateTypies(LogOpeTypeEnum[] operateTypies) {
		this.operateTypies = operateTypies;
	}
}
