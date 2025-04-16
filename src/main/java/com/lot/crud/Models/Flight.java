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
	private int flightTime;
	private boolean oneWay;
	private Integer seatNumber;

	public Flight() {
	}

	public Flight(String origin, String destination, int flightTime, boolean oneWay) {
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

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public boolean isOneWay() {
		return oneWay;
	}

	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

}
