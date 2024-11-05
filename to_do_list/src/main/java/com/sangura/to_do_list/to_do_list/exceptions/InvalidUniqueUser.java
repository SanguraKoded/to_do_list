package com.sangura.to_do_list.to_do_list.exceptions;

public class InvalidUniqueUser extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public InvalidUniqueUser(String message) {
		super(message);
	}

}
