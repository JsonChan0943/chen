package com.tlal.vms.vms.func.user.sbook.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookSearch;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;

@MyBatisRepository
public interface SBookDAO {
	
	/**
	 * 分页查找
	 * @param page
	 * @return
	 */
	public List<UserSBookPOJO> findSBookByPage(UserSbookSearch search);
	
	public List<UserSBookPOJO> findAllSBooks();
	
	/**
	 * 获取SBOOk表的记录数
	 * @return
	 */
	public int countSBook(UserSbookSearch search);
	
	/**
	 * 根据Id查看台账记录
	 * @param idsbook
	 * @return
	 */
	public SBook findSBookById(String idsbook);
	
	/**
	 * 
	 * @param book
	 */
	public void addSBook(SBook book);
	
	
	
	/**
	 * 根据id删除
	 * @param idsbook
	 */
	public void deleleSBook(String idsbook);
	
	/**
	 * 设置记录已过期
	 */
	public void setExpire(String idsbook);
	
	/**
	 * 设置记录未过期
	 */
	public void setUnExpire(String idsbook);
	
	/**
	 * 查找所有未过期的记录
	 * @return
	 */
	public List<SBook> findAllUnExpire();
	
	/**
	 * 根据carid查找台账记录
	 * @param carid
	 * @return
	 */
	public SBook findSBookByCarid(String carid);
	
	/**
	 * 根据userid查找台账
	 * @param userid
	 * @return
	 */
	public List<SBook> findSBookByUserId(String userid);
	
	/**
	 * 更新Sbook
	 * @param book
	 */
	public void updateSbook(SBook book);
	
	/**
	 * 根据carid查找汽车信息
	 * @param carid
	 * @return
	 */
	public SBook findByCarId(String carid);
	
	public List<SBook> findAllSBook();
	
	public List<UserSBookPOJO> findAllSBooksByUser(String company);
	
}
