package com.tlal.vms.vms.func.admin.car.entity;

import java.io.Serializable;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.utils.EnumUtil;

/**
 * 汽车实体类
 * @author Administrator
 *
 */
public class Car implements Serializable{
	private static final long serialVersionUID = 3423683648539772465L;
    //序号
    private String carid;
    //设备名称
    private String name;
    //车牌号
    private String plate_num;
    //型号
    private String type;
    //状态\n是否被租\n	Y,N
    private String status;
    //来自\n	自有非生产\n	自有生产
    private String origin;
    //汽车所属公司
    private String dept;
    //汽车所属公司
    private String company;
    //状态名
    @SuppressWarnings("unused")
	private transient String statusName;
    //汽车来源名
    @SuppressWarnings("unused")
	private transient String originName;
    //汽车所属公司名
    private transient String company_name;
    
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStatusName() {
		return EnumUtil.getNameByValue(CarStatusEnum.class, status);
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getOriginName() {
		return EnumUtil.getNameByValue(CarOriginEnum.class, origin);
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}  
}
