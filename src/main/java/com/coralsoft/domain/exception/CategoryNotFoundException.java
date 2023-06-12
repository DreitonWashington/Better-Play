package com.coralsoft.domain.exception;

public class CategoryNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException(String msg) {
		super(msg);
	}
	
	public CategoryNotFoundException(Long id) {
		this(String.format("Category with Id -> %s, not found!", id));
	}

}
