package com.coralsoft.domain.exception;

public class GenreNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public GenreNotFoundException(String msg) {
		super(msg);
	}
	
	public GenreNotFoundException(Long id) {
		this(String.format("Genre with Id -> %s, not found!", id));
	}

}
