package com.tlal.vms.vms.func.user.finishbook.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookSearch;
import com.tlal.vms.vms.func.user.finishbook.entity.FinishSBook;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;

@MyBatisRepository
public interface FinishSBookDAO {
	/**
	 * 增加交易完成明细
	 * @param book
	 */
	public void addFinishSBook(FinishSBook book);
	
	/**
	 * 列表显示车辆完成明细
	 * @param page
	 * @return
	 */
	public List<UserFinishSBookPOJO> findFinishSBookByPage(UserFinishSBookSearch search);
	
	/**
	 * 获取明细数
	 * @return
	 */
	public int countFinishSBook(UserFinishSBookSearch search);
	
	/**
	 * 根据userid查找车辆记录
	 * @param userId
	 * @return
	 */
	public List<FinishSBook> findFinishSBookByUserId(String userId);
	
	/**
	 * 根据carid查找车辆记录
	 * @param carId
	 * @return
	 */
	public List<FinishSBook> findFinishSBookByCarid(String carId);
}
