package com.lot.crud.DTOs;

public class ReservationDTO {
	public Long flightNumber;
	public Long passengerNumber;
	public boolean didTakeoff;
	public Long seatNumber;

	ReservationDTO() {

	}

	ReservationDTO(Long flightNumber, Long passengerNumber, boolean didTakeoff, Long seatNumber) {
		this.flightNumber = flightNumber;
		this.passengerNumber = passengerNumber;
		this.didTakeoff = didTakeoff;
		this.seatNumber = seatNumber;
	}
}
