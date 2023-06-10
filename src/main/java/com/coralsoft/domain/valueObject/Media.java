package com.coralsoft.domain.valueObject;

import com.coralsoft.domain.enums.MediaStatus;

public class Media {
	
	private String filePath;
	private MediaStatus mediaStatus;
	
	public Media() {
	}

	public Media(String filePath, MediaStatus mediaStatus) {
		super();
		this.filePath = filePath;
		this.mediaStatus = mediaStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MediaStatus getMediaStatus() {
		return mediaStatus;
	}

	public void setMediaStatus(MediaStatus mediaStatus) {
		this.mediaStatus = mediaStatus;
	}
	
}
