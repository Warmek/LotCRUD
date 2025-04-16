package com.lot.crud.Exceptions;

public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException(String email) {
		super("This email adress is not valid: " + email);
	}
}
