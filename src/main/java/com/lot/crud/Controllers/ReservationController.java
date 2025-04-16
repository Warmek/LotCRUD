package com.lot.crud.Controllers;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lot.crud.Models.Passenger;
import com.lot.crud.Models.Reservation;
import com.lot.crud.Models.Flight;
import com.lot.crud.Repositories.ReservationRepository;
import com.lot.crud.Exceptions.FlightNotFoundException;
import com.lot.crud.Exceptions.PassengerNotFoundException;
import com.lot.crud.Exceptions.ReservationNotFoundException;
import com.lot.crud.Exceptions.SeatTakenException;
import com.lot.crud.Repositories.FlightRepository;
import com.lot.crud.Repositories.PassengerRepository;
import com.lot.crud.DTOs.ReservationDTO;

@RestController
class ReservationController {
	private final ReservationRepository reservationRepository;
	private final PassengerRepository passengerRepository;
	private final FlightRepository flightRepository;

	private Environment env;

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(env.getProperties().getProperty("spring.mail.username"));

		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
	}

	ReservationController(ReservationRepository reservationRepository, PassengerRepository passengerRepository,
			FlightRepository flightRepository) {
		this.reservationRepository = reservationRepository;
		this.passengerRepository = passengerRepository;
		this.flightRepository = flightRepository;
	}

	// Read
	@GetMapping("reservations")
	ResponseEntity<List<Reservation>> all() {
		return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.FOUND);
	}

	// Create
	@PostMapping("reservations")
	ResponseEntity newReservation(@RequestBody ReservationDTO reservationDTO) {
		try {
			Long flightNumber = reservationDTO.flightNumber;
			Long passengerNumber = reservationDTO.passengerNumber;
			boolean didTakeoff = reservationDTO.didTakeoff;
			Long seatNumber = reservationDTO.seatNumber;

			// Check if seat is taken
			if (!reservationRepository.findBySeatNumberAndFlightNumber(flightNumber, seatNumber)
					.isEmpty()) {
				throw new SeatTakenException(flightNumber, seatNumber);
			}

			Flight flight = flightRepository.findById(flightNumber)
					.orElseThrow(() -> new FlightNotFoundException(flightNumber));
			Passenger passenger = passengerRepository.findById(passengerNumber)
					.orElseThrow(() -> new PassengerNotFoundException(passengerNumber));

			String passengerName = passenger.getFirstName();
			String passengerLastName = passenger.getLastName();
			String passengerEmail = passenger.getEmail();
			String passengerPhoneNumber = passenger.getPhoneNumber();

			Reservation newReservation = new Reservation(flightNumber, seatNumber,
					passenger.getId(),
					passengerName, passengerLastName,
					passengerEmail, passengerPhoneNumber, didTakeoff);

			flight.setFlightNumber(flightNumber);

			// Send Email
			sendEmail(passengerEmail, "Your new registration",
					"You have an reservation for flight " + newReservation.getFlightNumber()
							+ ". Your are seated at a seat number: "
							+ newReservation.getSeatNumber());
			flightRepository.save(flight);

			reservationRepository.save(newReservation);

			return new ResponseEntity<Reservation>(newReservation,
					HttpStatus.CREATED);

		} catch (Exception e) {
			throw e;
			// return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Single item

	// Read
	@GetMapping("reservations/{id}")
	ResponseEntity one(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(reservationRepository.findById(id)
					.orElseThrow(() -> new ReservationNotFoundException(id)), HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Update
	@PutMapping("reservations/{id}")
	ResponseEntity<Reservation> replaceReservation(@RequestBody Reservation newReservation, @PathVariable Long id) {
		return new ResponseEntity(reservationRepository.findById(id)
				.map(reservation -> {
					reservation.setReservationNumber(newReservation.getReservationNumber());
					return reservationRepository.save(reservation);
				})
				.orElseGet(() -> {
					return reservationRepository.save(newReservation);
				}), HttpStatus.OK);
	}

	// Delete
	@DeleteMapping("reservations/{id}")
	void deleteReservation(@PathVariable Long id) {
		reservationRepository.deleteById(id);
	}
}
