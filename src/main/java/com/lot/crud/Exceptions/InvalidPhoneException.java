package com.lot.crud.Exceptions;

public class InvalidPhoneException extends RuntimeException {

	public InvalidPhoneException(String phone) {
		super("This phone number is not valid: " + phone);
	}
}
