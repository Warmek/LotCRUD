package com.lot.crud.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int reservationNumber;

	// Flight
	private Long flightNumber;
	private int seatNumber;

	// Passenger
	private String passangerName;
	private String passangerLastName;
	private String passangerEmail;
	private String passangerPhoneNumber;

	private boolean didTakeoff;

	public Reservation() {
	}

	public Reservation(Long flightNumber, int seatNumber, String passangerName,
			String passangerLastName, String passangerEmail, String passangerPhoneNumber,
			boolean didTakeoff) {
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
		this.passangerName = passangerName;
		this.passangerLastName = passangerLastName;
		this.passangerEmail = passangerEmail;
		this.passangerPhoneNumber = passangerPhoneNumber;
		this.didTakeoff = didTakeoff;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public String getPassangerLastName() {
		return passangerLastName;
	}

	public void setPassangerLastName(String passangerLastName) {
		this.passangerLastName = passangerLastName;
	}

	public String getPassangerEmail() {
		return passangerEmail;
	}

	public void setPassangerEmail(String passangerEmail) {
		this.passangerEmail = passangerEmail;
	}

	public String getPassangerPhoneNumber() {
		return passangerPhoneNumber;
	}

	public void setPassangerPhoneNumber(String passangerPhoneNumber) {
		this.passangerPhoneNumber = passangerPhoneNumber;
	}

	public boolean isDidTakeoff() {
		return didTakeoff;
	}

	public void setDidTakeoff(boolean didTakeoff) {
		this.didTakeoff = didTakeoff;
	}

}
