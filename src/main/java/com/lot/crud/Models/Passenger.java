package com.lot.crud.Models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import com.lot.crud.regexutils;
import com.lot.crud.Exceptions.InvalidEmailException;
import com.lot.crud.Exceptions.InvalidPhoneException;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	Passenger() {
	}

	public Passenger(String firstName, String lastName, String email, String phoneNumber) {
		if (!regexutils.patternMatches(email, "^(.+)@(\\S+)$")) {
			throw new InvalidEmailException(email);
		}
		if (!regexutils.patternMatches(phoneNumber, "^\\d{9}$")) {
			throw new InvalidPhoneException(phoneNumber);
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!regexutils.patternMatches(email, "^(.+)@(\\S+)$")) {
			throw new InvalidEmailException(email);
		}
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (!regexutils.patternMatches(phoneNumber, "^\\d{9}$")) {
			throw new InvalidPhoneException(phoneNumber);
		}
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Passenger))
			return false;
		Passenger passenger = (Passenger) o;
		return Objects.equals(this.id, passenger.id) && Objects.equals(this.firstName, passenger.firstName);
	}

}
