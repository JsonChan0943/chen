package com.tlal.vms.vms.sys.supers.car.pojo;

public class FilePOJO {
	private String no;
	private String time;
	private String  fileName;

	public FilePOJO(){
		
	}
	public FilePOJO( String time,String  fileName){
		this.time = time;
		this.fileName = fileName;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
