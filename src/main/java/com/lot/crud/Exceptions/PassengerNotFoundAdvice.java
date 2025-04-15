package com.lot.crud.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class PassengerNotFoundAdvice {

	@ExceptionHandler(PassengerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String passengerNotFoundHandler(PassengerNotFoundException ex) {
		return ex.getMessage();
	}
}
