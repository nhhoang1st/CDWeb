package com.leansecurity.main.model;

public class UpdateUser {
	private int id;
	private String userName;
	private String email;
	private String sdt;
	private String dc;
	
	public UpdateUser(int id, String userName, String email, String sdt,String dc) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.sdt = sdt;
		this.dc = dc;
	}
	public int getID() {
		return this.id;
	}
	public String getName() {
		return this.userName;
	}
	public String getEmail() {
		return this.email;
	}
	public String getSdt() {
		return this.sdt;
	}
	public String getDC() {
		return this.dc;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
}
