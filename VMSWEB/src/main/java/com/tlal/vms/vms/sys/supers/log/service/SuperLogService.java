package com.tlal.vms.vms.sys.supers.log.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogSearch;
import com.tlal.vms.vms.sys.supers.log.dao.LogDAO;
import com.tlal.vms.vms.sys.supers.log.entity.LogDTO;

@Service
@Transactional(rollbackFor = Exception.class)  
public class SuperLogService implements SuperLogIService{
	@Resource
	private LogDAO logDAO;

	/**
	 * 分页查找日志
	 */
	@Override
	public Pager<LogDTO> findLogsByPage(SuperLogSearch search) {
		Pager<LogDTO> pager = new Pager<LogDTO>();
		pager.setList(logDAO.findLogByPage(search));
		pager.setCount(logDAO.countLogs(search));
		return pager;
	}

	/**
	 * 记录日志
	 */
	@Override
	public void addLog(String operator, Date operate_time,String operate_content, String operate_type) {
		LogDTO log = new LogDTO();
		log.setId(UUID.randomUUID().toString());
		log.setOperator(operator);
		log.setOperate_time(operate_time);
		log.setOperate_content(operate_content);
		log.setOperate_type(operate_type);
		logDAO.addLog(log);
	}
}
