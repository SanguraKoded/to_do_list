package com.sangura.to_do_list.to_do_list.priority;

import com.sangura.to_do_list.to_do_list.exceptions.InvalidStatusException;

public enum StatusEnum {
	
	PENDING, COMPLETED;

	public static StatusEnum formString(String value) {
		
		try {
			return StatusEnum.valueOf(value.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			throw new InvalidStatusException ("Invalid Status:" +value);
		}
	}
}
