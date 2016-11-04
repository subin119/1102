package com.dat.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadVO {
	
	private String name;
	private MultipartFile attachedFile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getAttachedFile() {
		return attachedFile;
	}
	public void setAttachedFile(MultipartFile attachedFile) {
		this.attachedFile = attachedFile;
	}

}
