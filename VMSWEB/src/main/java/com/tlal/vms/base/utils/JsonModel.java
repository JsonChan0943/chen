package com.tlal.vms.base.utils;

import java.io.Serializable;

/**
 * 后台给前端传递的json信息实体类
 * @author Administrator
 *
 */
public class JsonModel implements Serializable{
	
	private static final long serialVersionUID = 6042139256943778936L;
	/**
	 * 是否成功
	 */
	private boolean success = false;
	/**
	 * 信息
	 */
	private String msg = "";
	/**
	 * 其他信息
	 */
	private Object obj = null;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
