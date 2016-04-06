package com.tlal.vms.vms.sys.supers.log.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.utils.EnumUtil;

/**
 * 业务日志实体类
 * @author Administrator
 *
 */
public class LogDTO implements Serializable{
	private static final long serialVersionUID = -6863054608835004195L;
	/**id*/
	private String id;
	/**操作人*/
	private String operator;
	/**操作时间*/
	private Date operate_time;
	/**操作内容*/
	private String operate_content;
	/**操作类型 */
	private String operate_type;
	
	@SuppressWarnings("unused")
	private transient String operate_timeString;
	@SuppressWarnings("unused")
	private transient String operate_typeString;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
	public String getOperate_content() {
		return operate_content;
	}
	public void setOperate_content(String operate_content) {
		this.operate_content = operate_content;
	}
	public String getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(String operate_type) {
		this.operate_type = operate_type;
	}
	public String getOperate_timeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(operate_time);
	}
	public void setOperate_timeString(String operate_timeString) {
		this.operate_timeString = operate_timeString;
	}
	public String getOperate_typeString() {
		return EnumUtil.getNameByValue(LogOpeTypeEnum.class, operate_type);
	}
	public void setOperate_typeString(String operate_typeString) {
		this.operate_typeString = operate_typeString;
	}
}
