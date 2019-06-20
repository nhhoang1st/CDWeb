package com.leansecurity.main.model;

import java.util.List;

public class AjaxResponseBody2 {
	User user;
	List<?> datg;
	List<?> chuatg;
	
	public User getUser() {
		return user;
	}
	public void setUser(User mes) {
		this.user = mes;
	}
	public List<?> getDatg() {
		return datg;
	}
	public void setDatg(List<?> result) {
		this.datg = result;
	}
	public List<?> getChuatg(){
		return this.chuatg;
	}
	public void setChuatg(List<?> chuatg) {
		this.chuatg = chuatg;
	}

	
	
}
