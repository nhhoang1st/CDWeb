package com.leansecurity.main.model;

import org.springframework.web.multipart.MultipartFile;

public class MyUpLoadForm {
	private int id ;
	private MultipartFile fileData;
	
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData= fileData;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return this.id +"........" ;
	}
	
}
