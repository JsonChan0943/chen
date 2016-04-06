package com.tlal.vms.base.enums.enumc;

import com.tlal.vms.base.enums.enumi.IEnum;

/**
 * 车辆来源枚举类
 * @author Administrator
 *
 */
public enum CarOriginEnum implements IEnum<String>{
	CT01("自有生产","CT01"),
	CT02("自有非生产","CT02"),
	CT03("租赁生产","CT03"),
	CT04("租赁非生产","CT04"),
	;

	/**
	 * 属性名
	 */
	private String enName;
	/**属性值*/
	private String enValue;
	
	private CarOriginEnum(String enName,String enValue){
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
