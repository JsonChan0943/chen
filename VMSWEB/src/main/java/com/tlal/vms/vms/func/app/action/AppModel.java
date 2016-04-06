package com.tlal.vms.vms.func.app.action;

import java.io.Serializable;

public class AppModel implements Serializable{
	private static final long serialVersionUID = -8400332665345614076L;
	private String plate_num;
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
	
}
