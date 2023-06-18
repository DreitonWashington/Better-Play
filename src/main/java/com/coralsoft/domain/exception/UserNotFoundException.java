package com.coralsoft.domain.exception;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg) {
		super(msg);
	}

	public UserNotFoundException(Long id) {
		this(String.format("User with Id -> %s, not found!", id));
	}

}
