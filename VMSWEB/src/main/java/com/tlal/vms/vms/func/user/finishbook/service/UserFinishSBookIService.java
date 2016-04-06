package com.tlal.vms.vms.func.user.finishbook.service;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookSearch;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;

public interface UserFinishSBookIService {
	/**
	 * 分页查找用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pager<UserFinishSBookPOJO> findFinishSBookByPage(UserFinishSBookSearch search);
}
