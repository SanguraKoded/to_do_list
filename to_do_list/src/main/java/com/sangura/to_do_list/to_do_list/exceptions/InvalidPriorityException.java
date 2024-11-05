package com.sangura.to_do_list.to_do_list.exceptions;

public class InvalidPriorityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public InvalidPriorityException(String message) {
		super(message);
	}
}
