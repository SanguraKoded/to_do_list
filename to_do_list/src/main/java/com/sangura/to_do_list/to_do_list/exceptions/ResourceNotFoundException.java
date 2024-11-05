package com.sangura.to_do_list.to_do_list.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
