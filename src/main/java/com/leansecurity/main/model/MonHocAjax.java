package com.leansecurity.main.model;

import java.util.Arrays;

import javax.persistence.Column;

public class MonHocAjax {
	private String tenmh;

	private String tenrutgon;

	private String mucmh;

	private String mota;

	private String ngaybd;
	
	private String ngaykt;
	
	private int soBaiTap;
	
	private int soThongBao;
	 
	private int soThanhVien;

	public String getTenmh() {
		return tenmh;
	}

	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}

	public String getTenrutgon() {
		return tenrutgon;
	}

	public void setTenrutgon(String tenrutgon) {
		this.tenrutgon = tenrutgon;
	}

	public String getMucmh() {
		return mucmh;
	}

	public void setMucmh(String mucmh) {
		this.mucmh = mucmh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(String ngaybd) {
		this.ngaybd = ngaybd;
	}

	public String getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(String ngaykt) {
		this.ngaykt = ngaykt;
	}

	public int getSoBaiTap() {
		return soBaiTap;
	}

	public void setSoBaiTap(int soBaiTap) {
		this.soBaiTap = soBaiTap;
	}

	public int getSoThongBao() {
		return soThongBao;
	}

	public void setSoThongBao(int soThongBao) {
		this.soThongBao = soThongBao;
	}

	public int getSoThanhVien() {
		return soThanhVien;
	}

	public void setSoThanhVien(int soThanhVien) {
		this.soThanhVien = soThanhVien;
	}
	
}
