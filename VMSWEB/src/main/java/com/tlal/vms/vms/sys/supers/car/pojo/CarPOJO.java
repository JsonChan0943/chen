package com.tlal.vms.vms.sys.supers.car.pojo;

import com.ylink.eu.office.com.enums.ColIndexEnum;
import com.ylink.eu.office.excel.imp.annotations.ExcelColumn;

public class CarPOJO{
    //设备名称
	@ExcelColumn(index = ColIndexEnum.A)
    private String name;
    //车牌号
	@ExcelColumn(index = ColIndexEnum.B)
    private String plate_num;
    //型号
	@ExcelColumn(index = ColIndexEnum.C)
    private String type;
    //来自\n	自有非生产\n	自有生产
	@ExcelColumn(index = ColIndexEnum.D)
    private String origin;
    //汽车所属公司
    @ExcelColumn(index = ColIndexEnum.E)
    private String company;
    
    private String FLAG = "|";
    
    public String getDetailStr(){
    	return name+FLAG+plate_num+FLAG+type+FLAG+origin+FLAG+company;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFLAG() {
		return FLAG;
	}
	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}
}