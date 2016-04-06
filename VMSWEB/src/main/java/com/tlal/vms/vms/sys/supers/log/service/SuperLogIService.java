package com.tlal.vms.vms.sys.supers.log.service;

import java.util.Date;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogSearch;
import com.tlal.vms.vms.sys.supers.log.entity.LogDTO;

public interface SuperLogIService {
	/**
	 * 分页查找日记信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pager<LogDTO> findLogsByPage(SuperLogSearch search);
	
	/**
	 * 记录日志
	 * @param log
	 */
	public void addLog(String operator,Date operate_time,String operate_content,String operate_type);
	
}
