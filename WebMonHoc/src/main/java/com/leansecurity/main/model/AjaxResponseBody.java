package com.leansecurity.main.model;

import java.util.List;

public class AjaxResponseBody {
	String mes;
	List<User> result;
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public List<User> getResult() {
		return result;
	}
	public void setResult(List<User> result) {
		this.result = result;
	}

	
	
}
