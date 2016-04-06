package com.tlal.vms.vms.func.app.pojo;

import java.io.Serializable;

import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.sys.login.entity.User;

public class AppPOJO implements Serializable{
	private static final long serialVersionUID = 6536966593199759428L;
	
	private Car car;
	private SBook book;
	private User user;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public SBook getBook() {
		return book;
	}
	public void setBook(SBook book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
