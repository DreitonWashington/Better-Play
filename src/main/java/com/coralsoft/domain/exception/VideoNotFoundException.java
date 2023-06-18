package com.coralsoft.domain.exception;

public class VideoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public VideoNotFoundException(String msg) {
		super(msg);
	}

	public VideoNotFoundException(Long id) {
		this(String.format("Video with Id -> %s, not found!", id));
	}

}
