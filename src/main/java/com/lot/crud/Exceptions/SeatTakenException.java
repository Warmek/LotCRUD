package com.lot.crud.Exceptions;

public class SeatTakenException extends RuntimeException {

	public SeatTakenException(Long flightNumber, Long seatNubmer) {
		super("Seat number: " + seatNubmer + " of flight: " + flightNumber + " is taken");
	}
}
