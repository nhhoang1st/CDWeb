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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "baitap")
public class BaiTap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idbt")
	private int idbt;
	
	@Column(name = "tenbt")
	private String tenbt;
	
	@Column(name = "mota")
	private String mota;
	
	@Column(name = "ngaybd")
	private String ngaybd;
	
	@Column(name = "ngaykt")
	private String ngaykt;
	
	@Column(name = "filesize")
	private int filesize;
	
	@Column(name = "folder")
	private String folder;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baitap", cascade = {CascadeType.ALL}, orphanRemoval = false)
	private List<FileBaiTap> listFileBT;
	
	@ManyToOne
	@JoinColumn(name = "mh_id", nullable = false)
	private MonHoc monhoc;

	public int getIdbt() {
		return idbt;
	}

	public void setIdbt(int idbt) {
		this.idbt = idbt;
	}

	public String getTenbt() {
		return tenbt;
	}

	public void setTenbt(String tenbt) {
		this.tenbt = tenbt;
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

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public MonHoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(MonHoc monhoc) {
		this.monhoc = monhoc;
	}

	public List<FileBaiTap> getListFileBT() {
		return listFileBT;
	}

	public void setListFileBT(List<FileBaiTap> listFileBT) {
		this.listFileBT = listFileBT;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}
