package com.sangura.to_do_list.to_do_list.exceptions;

public class InvalidEmailException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public InvalidEmailException(String message) {
		super(message);
	}
}
