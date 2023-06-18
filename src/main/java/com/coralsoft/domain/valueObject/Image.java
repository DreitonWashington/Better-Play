package com.coralsoft.domain.valueObject;

public class Image {

	private String filePath;

	public Image() {
	}

	public Image(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
