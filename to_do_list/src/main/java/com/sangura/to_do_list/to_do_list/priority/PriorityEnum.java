package com.sangura.to_do_list.to_do_list.priority;

import com.sangura.to_do_list.to_do_list.exceptions.InvalidPriorityException;

public enum PriorityEnum {
	
	LOW, MEDIUM, HIGH;
	
	public static PriorityEnum formString(String value) {
		
		try {
			return PriorityEnum.valueOf(value.toUpperCase());
		}
		catch (IllegalArgumentException e) {
			throw new InvalidPriorityException("Invalid Priority:" +value);
		}
	}
	

}
