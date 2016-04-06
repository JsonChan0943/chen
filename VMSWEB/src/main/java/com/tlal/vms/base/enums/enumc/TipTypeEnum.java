package com.tlal.vms.base.enums.enumc;

import com.tlal.vms.base.enums.enumi.IEnum;

/**
 * 提示信息类别枚举类
 * @author Administrator
 *
 */
public enum TipTypeEnum implements IEnum<String>{
	SUCCESS("成功提示", "success"), 
	WARN("警告提示", "warn"), 
	ERROR("错误提示", "error"),
	;

	private String enName;
	private String enValue;

	private TipTypeEnum(String enName, String enValue){
		this.enName = enName;
		this.enValue = enValue;
	}

	public String getEnName(){
		return this.enName;
	}

	public void setEnName(String enName){
		this.enName = enName;
	}
	
	public String getEnValue(){
		return this.enValue;
	}
	
	public void setEnValue(String enValue){
		this.enValue = enValue;
	}
}
