package com.leansecurity.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "thongbao")
public class ThongBao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtb")
	private int idtb;

	@Column(name = "tieude")
	private String tieude;

	@Column(name = "noidung")
	private String noidung;

	@Column(name = "filepath")
	private String filepath;

	@Column(name = "ngaytb")
	private String ngaytb;

	@ManyToOne
	@JoinColumn(name = "mh_id", nullable = false)
	private MonHoc monhoc;

	public int getIdtb() {
		return idtb;
	}

	public void setIdtb(int idtb) {
		this.idtb = idtb;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getNgaytb() {
		return ngaytb;
	}

	public void setNgaytb(String ngaytb) {
		this.ngaytb = ngaytb;
	}

	public MonHoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(MonHoc monhoc) {
		this.monhoc = monhoc;
	}

}
