package com.sangura.to_do_list.to_do_list.exceptions;

public class InvalidStatusException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public InvalidStatusException(String message) {
		super(message);
	}

}
