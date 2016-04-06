package com.tlal.vms.vms.sys.supers.car.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.sys.supers.car.pojo.FilePOJO;

public class SuperCarModel {
	private PageModel pageModel = new PageModel();
	private SuperCarSearch search = new SuperCarSearch();
	private List<Car> cars = new ArrayList<Car>();
	
	private CarStatusEnum[] status; //汽车状态
	private CarOriginEnum[] origins; //汽车来源
	private String plate_num;		
	private Car car;	
	private String carid;
	
	private List<Map<String, String>> companies;
	
	private List<FilePOJO> filePOJO;
	private String fileName;
	
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public SuperCarSearch getSearch() {
		return search;
	}
	public void setSearch(SuperCarSearch search) {
		this.search = search;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public CarStatusEnum[] getStatus() {
		return status;
	}
	public void setStatus(CarStatusEnum[] status) {
		this.status = status;
	}
	public CarOriginEnum[] getOrigins() {
		return origins;
	}
	public void setOrigins(CarOriginEnum[] origins) {
		this.origins = origins;
	}
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public List<Map<String, String>> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Map<String, String>> companies) {
		this.companies = companies;
	}
	public List<FilePOJO> getFilePOJO() {
		return filePOJO;
	}
	public void setFilePOJO(List<FilePOJO> filePOJO) {
		this.filePOJO = filePOJO;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
