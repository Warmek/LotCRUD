package com.lot.crud.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.lot.crud.Models.Passenger;
import com.lot.crud.Models.Reservation;
import com.lot.crud.Models.Flight;
import com.lot.crud.Repositories.ReservationRepository;
import com.lot.crud.Exceptions.FlightNotFoundException;
import com.lot.crud.Exceptions.PassengerNotFoundException;
import com.lot.crud.Exceptions.ReservationNotFoundException;
import com.lot.crud.Repositories.FlightRepository;
import com.lot.crud.Repositories.PassengerRepository;
import com.lot.crud.DTOs.ReservationDTO;

@RestController
class ReservationController {

	private final ReservationRepository repository;
	private final PassengerRepository passengerRepository;
	private final FlightRepository flightRepository;

	ReservationController(ReservationRepository repository, PassengerRepository passengerRepository,
			FlightRepository flightRepository) {
		this.repository = repository;
		this.passengerRepository = passengerRepository;
		this.flightRepository = flightRepository;
	}

	@GetMapping("reservations")
	List<Reservation> all() {
		return repository.findAll();
	}

	@PostMapping("reservations")
	Reservation newReservation(@RequestBody ReservationDTO reservationDTO) {

		Long flightNumber = reservationDTO.flightNumber;
		Long passengerNumber = reservationDTO.passengerNumber;
		boolean didTakeoff = reservationDTO.didTakeoff;
		Integer seatNumber = reservationDTO.seatNumber;

		Flight flight = flightRepository.findById(flightNumber)
				.orElseThrow(() -> new FlightNotFoundException(flightNumber));
		Passenger passenger = passengerRepository.findById(passengerNumber)
				.orElseThrow(() -> new PassengerNotFoundException(passengerNumber));

		String passengerName = passenger.getFirstName();
		String passengerLastName = passenger.getLastName();
		String passengerEmail = passenger.getEmail();
		String passengerPhoneNumber = passenger.getPhoneNumber();

		Reservation newReservation = new Reservation(flightNumber, seatNumber,
				passengerName, passengerLastName,
				passengerEmail, passengerPhoneNumber, didTakeoff);

		flight.setFlightNumber(flightNumber);

		flightRepository.save(flight);

		return repository.save(newReservation);
	}

	// Single item

	@GetMapping("reservations/{id}")
	Reservation one(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ReservationNotFoundException(id));
	}

	@PutMapping("reservations/{id}")
	Reservation replaceReservation(@RequestBody Reservation newReservation, @PathVariable Long id) {

		return repository.findById(id)
				.map(reservation -> {
					reservation.setReservationNumber(newReservation.getReservationNumber());
					return repository.save(reservation);
				})
				.orElseGet(() -> {
					return repository.save(newReservation);
				});
	}

	@DeleteMapping("reservations/{id}")
	void deleteReservation(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
