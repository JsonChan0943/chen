package com.tlal.vms.vms.func.user.sbook.service;

import java.util.List;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.user.finishbook.entity.FinishSBook;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookSearch;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;

public interface UserSbookIService {
	/**
	 * 分页查找用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pager<UserSBookPOJO> findSBookByPage(UserSbookSearch search);
	
	/**
	 * 根据id查找sBook信息
	 * @param idsbook
	 * @return
	 */
	public SBook findSbookById(String idsbook);
	
	/**
	 * 退租添加信息到台账表
	 * @param finishSBook
	 */
	public void addFinishSBook(FinishSBook finishSBook);
	
	/**
	 * 根据id删除Sbook信息
	 * @param idsbook
	 */
	public void deleteSbookById(String idsbook);
	
	/**
	 * 设置车辆未被租用
	 * @param carid
	 */
	public void setCarUnRent(String carid);
	
	/**
	 * 更新Sbook
	 * @param book
	 */
	public void updateSbook(SBook book);
	
	/**
	 * 根据车辆id查找
	 * @param carid
	 * @return
	 */
	public SBook findByCarId(String carid);
	
	/**
	 * 查找所有租赁信息
	 * @return
	 */
	public List<UserSBookPOJO> findAllSBooks();
	
	/**
	 * 根据公司查找所有租赁信息
	 * @param company
	 * @return
	 */
	public List<UserSBookPOJO> findAllSBooksByUser(String company);
}
