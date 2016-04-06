package com.tlal.vms.vms.sys.supers.log.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.sys.supers.log.action.SuperLogSearch;
import com.tlal.vms.vms.sys.supers.log.entity.LogDTO;

@MyBatisRepository
public interface LogDAO {
	/**
	 * 分页查找日志
	 * @param search
	 * @return
	 */
	public List<LogDTO> findLogByPage(SuperLogSearch search);
	/**
	 * 统计日志条数
	 * @param search
	 * @return
	 */
	public Integer countLogs(SuperLogSearch search);
	/**
	 * 记录日志
	 * @param log
	 */
	public void addLog(LogDTO log);
}
