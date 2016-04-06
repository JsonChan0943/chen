package com.tlal.vms.base.enums.enumc;

import com.tlal.vms.base.enums.enumi.IEnum;

/**
 * 汽车租赁状态枚举类 1已租用 2未租用
 * @author Administrator
 *
 */
public enum CarStatusEnum implements IEnum<String>{
	N("未租用","N"),
	Y("已租用","Y"),;

	/**
	 * 属性名
	 */
	private String enName;
	/**属性值*/
	private String enValue;
	
	private CarStatusEnum(String enName,String enValue){
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
