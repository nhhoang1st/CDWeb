package com.learnajax.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "thanhvien")
public class Thanhvien {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name = "matkhau")
	private String matkhau;
	@Column(name = "hoten")
	private String hoten;
	@Column(name = "ngaysinh")
	private String ngaysinh;
	@Column(name = "diachi")
	private String diachi;
	@Column(name = "dienthoai")
	private String dienthoai;
	@Column(name = "gioitinh")
	private String gioitinh;
	@Column(name = "tdvanhoa")
	private String tdvanhoa;
	public Thanhvien() {
		super();
	}
	public Thanhvien(int id, String email, String matkhau, String hoten, String ngaysinh, String diachi,
			String dienthoai, String gioitinh, String tdvanhoa) {
		super();
		this.id = id;
		this.email = email;
		this.matkhau = matkhau;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
		this.gioitinh = gioitinh;
		this.tdvanhoa = tdvanhoa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getTdvanhoa() {
		return tdvanhoa;
	}
	public void setTdvanhoa(String tdvanhoa) {
		this.tdvanhoa = tdvanhoa;
	}
}
