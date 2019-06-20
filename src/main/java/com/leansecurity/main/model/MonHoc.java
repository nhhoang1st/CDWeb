package com.leansecurity.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "monhoc")
public class MonHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idmh")
	private int idmh;

	@Column(name = "tenmh")
	private String tenmh;

	@Column(name = "tenrutgon")
	private String tenrutgon;

	@Column(name = "mucmh")
	private String mucmh;

	@Column(name = "mota")
	private String mota;

	@Column(name = "ngaybd")
	private String ngaybd;
	
	@Column(name = "ngaykt")
	private String ngaykt;
	
	@ManyToMany()
	@JoinTable(name = "monhoc_user", joinColumns = @JoinColumn(name = "idmh"), inverseJoinColumns = @JoinColumn(name = "iduser"))
	private List<User> users;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "monhoc", cascade = {CascadeType.ALL}, orphanRemoval = false)
	private List<ThongBao> listTB;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "monhoc", cascade = {CascadeType.ALL}, orphanRemoval = false)
	private List<BaiTap> listBT;

	public int getIdmh() {
		return idmh;
	}

	public void setIdmh(int idmh) {
		this.idmh = idmh;
	}

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

	public String getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(String ngaykt) {
		this.ngaykt = ngaykt;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<ThongBao> getListTB() {
		return listTB;
	}

	public void setListTB(List<ThongBao> listTB) {
		this.listTB = listTB;
	}

	public List<BaiTap> getListBT() {
		return listBT;
	}

	public void setListBT(List<BaiTap> listBT) {
		this.listBT = listBT;
	}

	@Override
	public String toString() {
		return "MonHoc [tenmh=" + tenmh + ", tenrutgon=" + tenrutgon + ", mucmh=" + mucmh + ", mota=" + mota
				+ ", ngaybd=" + ngaybd + ", ngaykt=" + ngaykt + ", users=" + users + ", listTB=" + listTB + ", listBT="
				+ listBT + "]";
	}

}
