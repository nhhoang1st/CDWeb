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
@Table(name = "file_bai_tap")
public class FileBaiTap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfile")
	private int idfile;
	
	@Column(name = "path")
	private String filepath;
	
	@ManyToOne
	@JoinColumn(name = "bt_id", nullable = false)
	private BaiTap baitap;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public int getIdfile() {
		return idfile;
	}

	public void setIdfile(int idfile) {
		this.idfile = idfile;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public BaiTap getBaitap() {
		return baitap;
	}

	public void setBaitap(BaiTap baitap) {
		this.baitap = baitap;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
