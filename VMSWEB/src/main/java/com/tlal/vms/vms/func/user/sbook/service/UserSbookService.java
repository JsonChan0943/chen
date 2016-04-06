package com.tlal.vms.vms.func.user.sbook.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.admin.car.dao.CarDAO;
import com.tlal.vms.vms.func.user.finishbook.dao.FinishSBookDAO;
import com.tlal.vms.vms.func.user.finishbook.entity.FinishSBook;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookSearch;
import com.tlal.vms.vms.func.user.sbook.dao.SBookDAO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;

@Service
@Transactional(rollbackFor = Exception.class)  
public class UserSbookService implements UserSbookIService{
	@Resource
	private SBookDAO sBookDAO;
	@Resource
	private FinishSBookDAO finishSBookDAO;
	@Resource
	private CarDAO carDAO;

	/**
	 * 分页查找
	 */
	@Override
	public Pager<UserSBookPOJO> findSBookByPage(UserSbookSearch search) {
		Pager<UserSBookPOJO> page = new Pager<UserSBookPOJO>();
		page.setList(sBookDAO.findSBookByPage(search));
		page.setCount(sBookDAO.countSBook(search));
		return page;
	}

	/**
	 * 根据id查找Sbook信息
	 */
	@Override
	public SBook findSbookById(String idsbook) {
		if(idsbook!=null){
			SBook sBook = sBookDAO.findSBookById(idsbook);
			if(sBook!=null){
				return sBook;
			}
		}
		return null;
	}

	/**
	 * 添加FinishSBook信息
	 */
	@Override
	public void addFinishSBook(FinishSBook finishSBook) {
		if(finishSBook!=null){
			finishSBookDAO.addFinishSBook(finishSBook);
		}
	}

	/**
	 *根据id删除Sbook信息
	 */
	@Override
	public void deleteSbookById(String idsbook) {
		if(idsbook!=null){
			sBookDAO.deleleSBook(idsbook);
		}
	}

	/**
	 * 设置车辆未被租用
	 */
	@Override
	public void setCarUnRent(String carid) {
		if(carid!=null){
			carDAO.setCarUnRent(carid);
		}
	}

	/**
	 * 更新Sbook实体类
	 */
	@Override
	public void updateSbook(SBook book) {
		if(book!=null){
			sBookDAO.updateSbook(book);
		}
	}

	@Override
	public SBook findByCarId(String carid) {
		if(carid!=null){
			SBook sBook = sBookDAO.findByCarId(carid);
			if(sBook!=null){
				return sBook;
			}
		}
		return null;
	}

	/**
	 * 查找所有的租赁信息
	 */
	@Override
	public List<UserSBookPOJO> findAllSBooks() {
		return sBookDAO.findAllSBooks();
	}

	/**
	 * 根据用户查找所有的租赁信息
	 */
	@Override
	public List<UserSBookPOJO> findAllSBooksByUser(String company) {
		return  sBookDAO.findAllSBooksByUser(company);
	}
}
