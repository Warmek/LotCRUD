package com.lot.crud.DTOs;

public class ReservationDTO {
	public Long flightNumber;
	public Long passengerNumber;
	public boolean didTakeoff;
	public Integer seatNumber;

	ReservationDTO() {

	}

	ReservationDTO(Long flightNumber, Long passengerNumber, boolean didTakeoff, Integer seatNumber) {
		this.flightNumber = flightNumber;
		this.passengerNumber = passengerNumber;
		this.didTakeoff = didTakeoff;
		this.seatNumber = seatNumber;
	}
}
