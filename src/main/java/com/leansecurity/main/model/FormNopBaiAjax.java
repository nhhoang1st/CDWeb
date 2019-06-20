package com.leansecurity.main.model;

import org.springframework.web.multipart.MultipartFile;

public class FormNopBaiAjax {
	private String idUser;
	private String idBaiTap;
	private MultipartFile fileData;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdBaiTap() {
		return idBaiTap;
	}
	public void setIdBaiTap(String idBaiTap) {
		this.idBaiTap = idBaiTap;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
	
}
