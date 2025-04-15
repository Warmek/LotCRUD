package com.lot.crud.Exceptions;

public class PassengerNotFoundException extends RuntimeException {

	public PassengerNotFoundException(Long id) {
		super("Could not find customer " + id);
	}
}
