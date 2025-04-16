package com.lot.crud.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lot.crud.Models.Passenger;
import com.lot.crud.Models.Reservation;
import com.lot.crud.Repositories.FlightRepository;
import com.lot.crud.Repositories.PassengerRepository;
import com.lot.crud.Repositories.ReservationRepository;
import com.lot.crud.Exceptions.PassengerNotFoundException;

@RestController
class PassengerController {
	private final PassengerRepository passengerRepository;
	private final ReservationRepository reservationRepository;
	private final FlightRepository flightRepository;

	PassengerController(PassengerRepository passengerRepository, ReservationRepository reservationRepository,
			FlightRepository flightRepository) {
		this.passengerRepository = passengerRepository;
		this.reservationRepository = reservationRepository;
		this.flightRepository = flightRepository;
	}

	@GetMapping("passengers")
	List<Passenger> all() {
		return passengerRepository.findAll();
	}

	@PostMapping("passengers")
	Passenger newPassenger(@RequestBody Passenger newPassenger) {
		return passengerRepository.save(newPassenger);
	}

	// Single item

	@GetMapping("passengers/{id}")
	ResponseEntity one(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(passengerRepository.findById(id)
					.orElseThrow(() -> new PassengerNotFoundException(id)), HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("passengers/{id}")
	Passenger replacePassenger(@RequestBody Passenger newPassenger, @PathVariable Long id) {

		return passengerRepository.findById(id)
				.map(passenger -> {
					passenger.setFirstName(newPassenger.getFirstName());
					passenger.setLastName(newPassenger.getLastName());
					passenger.setEmail(newPassenger.getEmail());
					passenger.setPhoneNumber(newPassenger.getPhoneNumber());
					return passengerRepository.save(passenger);
				})
				.orElseGet(() -> {
					return passengerRepository.save(newPassenger);
				});
	}

	@DeleteMapping("passengers/{id}")
	void deletePassenger(@PathVariable Long id) {
		passengerRepository.deleteById(id);
	}
}
