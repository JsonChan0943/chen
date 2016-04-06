package com.tlal.vms.base.utils;

import java.util.List;

/**
 * 分页查找的工具类
 * 返回总记录数和总List列表
 * @author Administrator
 *
 * @param <T>
 */
public class Pager<T> {
	/**分页查找找到的记录*/
	private List<T> list;
	/**分页查找找到的记录数*/
	private long count;
	
	private int findCnt;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
		this.findCnt = this.list.size();
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getFindCnt() {
		return findCnt;
	}
	public void setFindCnt(int findCnt) {
		this.findCnt = findCnt;
	}
}
