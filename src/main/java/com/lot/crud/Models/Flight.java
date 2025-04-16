package com.lot.crud.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private Long flightNumber;
	private String origin;
	private String destination;
	private Long flightTime;
	private boolean oneWay;
	private Long seatNumber;

	public Flight() {
	}

	public Flight(String origin, String destination, Long flightTime, boolean oneWay) {
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.oneWay = oneWay;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}

	public boolean isOneWay() {
		return oneWay;
	}

	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	public Long getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

}
