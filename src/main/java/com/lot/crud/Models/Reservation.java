package com.lot.crud.Models;

import com.lot.crud.Exceptions.InvalidEmailException;
import com.lot.crud.Exceptions.InvalidPhoneException;
import com.lot.crud.regexutils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Reservation
 * This class models a reservation.
 */
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long reservationNumber;

	// Flight
	private Long flightNumber;
	private Long seatNumber;

	// Passenger
	private Long passengerId;
	private String passangerName;
	private String passangerLastName;
	private String passangerEmail;
	private String passangerPhoneNumber;

	private boolean didTakeoff;

	public Reservation() {
	}

	public Reservation(Long flightNumber, Long seatNumber, Long passengerId, String passangerName,
			String passangerLastName, String passangerEmail, String passangerPhoneNumber,
			boolean didTakeoff) {
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;

		// Validate Email
		if (!regexutils.patternMatches(passangerEmail, "^(.+)@(\\S+)$")) {
			throw new InvalidEmailException(passangerEmail);
		}
		// Validate PhoneNumber
		if (!regexutils.patternMatches(passangerPhoneNumber, "^\\d{9}$")) {
			throw new InvalidPhoneException(passangerPhoneNumber);
		}
		this.passengerId = passengerId;
		this.passangerName = passangerName;
		this.passangerLastName = passangerLastName;
		this.passangerEmail = passangerEmail;
		this.passangerPhoneNumber = passangerPhoneNumber;
		this.didTakeoff = didTakeoff;
	}

	// Setter and Getters
	public Long getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(Long reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Long getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Long seatNumber) {
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
		// Validate Email
		if (!regexutils.patternMatches(passangerEmail, "^(.+)@(\\S+)$")) {
			throw new InvalidEmailException(passangerEmail);
		}
		this.passangerEmail = passangerEmail;
	}

	public String getPassangerPhoneNumber() {
		return passangerPhoneNumber;
	}

	public void setPassangerPhoneNumber(String passangerPhoneNumber) {
		// Validate Phone Number
		if (!regexutils.patternMatches(passangerPhoneNumber, "^\\d{9}$")) {
			throw new InvalidPhoneException(passangerPhoneNumber);
		}
		this.passangerPhoneNumber = passangerPhoneNumber;
	}

	public boolean isDidTakeoff() {
		return didTakeoff;
	}

	public void setDidTakeoff(boolean didTakeoff) {
		this.didTakeoff = didTakeoff;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

}
