package com.coralsoft.domain.exception;

public class CastMemberNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CastMemberNotFoundException(String msg) {
		super(msg);
	}
	
	public CastMemberNotFoundException(Long id) {
		this(String.format("CastMember with Id -> %s, not found!", id));
	}

}
