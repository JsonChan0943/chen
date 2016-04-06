package com.tlal.vms.base.enums.enumc;

import com.tlal.vms.base.enums.enumi.IEnum;

/**
 * 车辆来源枚举类
 * @author Administrator
 *
 */
public enum LogOpeTypeEnum implements IEnum<String>{
	ADDADMIN("增加管理员","addAdmin"),
	DELADMIN("删除管理员","delAdmin"),
	EDITADMIN("修改管理员","editAdmin"),
	ADDCOMPANY("增加子公司","addCompany"),
	DELCOMPANY("删除子公司","delCompany"),
	EDITCOMPANY("修改子公司","editCompany"),
	ADDUSER("增加系统用户","addUser"),
	DELUSER("删除系统用户","delUser"),
	EDITUSER("修改系统用户","editUser"),
	ADDCAR("增加车辆","addCar"),
	DELCAR("删除车辆","delCar"),
	EDITCAR("修改车辆","editCar"),
	RENTCAR("出租车辆","rentCar"),
	EDITSBOOK("修改租赁信息","editSbook"),
	DELSBOOK("删除租赁信息","delSbook"),
	RETURNSBOOK("退租车辆","returnCar"),
	;

	/**
	 * 属性名
	 */
	private String enName;
	/**属性值*/
	private String enValue;
	
	private LogOpeTypeEnum(String enName,String enValue){
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
