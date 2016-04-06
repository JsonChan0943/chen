package com.tlal.vms.vms.func.user.finishbook.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookSearch;
import com.tlal.vms.vms.func.user.finishbook.dao.FinishSBookDAO;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;

@Service
@Transactional(rollbackFor = Exception.class)  
public class UserFinishSBookService implements UserFinishSBookIService{
	@Resource
	private FinishSBookDAO finishSBookDAO;

	/**
	 * 分页查找
	 */
	@Override
	public Pager<UserFinishSBookPOJO> findFinishSBookByPage(UserFinishSBookSearch search) {
		Pager<UserFinishSBookPOJO> page = new Pager<UserFinishSBookPOJO>();
		page.setList(finishSBookDAO.findFinishSBookByPage(search));
		page.setCount(finishSBookDAO.countFinishSBook(search));
		return page;
	}
}
