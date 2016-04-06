package com.tlal.vms.base.enums.enumc;

import com.tlal.vms.base.enums.enumi.IEnum;

/**
 * 用户身份枚举类
 * @author Administrator
 *
 */
public enum UserTypeEnum implements IEnum<String> {
	SUPER("超级管理员","super"),
	ADMIN("系统管理员","admin"),
	USER("用户","user"),
	;

	/**
	 * 属性名
	 */
	private String enName;
	/**属性值*/
	private String enValue;
	
	private UserTypeEnum(String enName,String enValue){
		this.enName = enName;
		this.enValue = enValue;
	}
	@Override
	public String getEnName() {
		return enName;
	}

	@Override
	public String getEnValue() {
		return enValue;
	}

}
