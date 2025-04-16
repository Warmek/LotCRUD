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

import com.lot.crud.Models.Flight;
import com.lot.crud.Repositories.FlightRepository;
import com.lot.crud.Exceptions.FlightNotFoundException;

@RestController
class FlightController {

	private final FlightRepository repository;

	FlightController(FlightRepository repository) {
		this.repository = repository;
	}

	@GetMapping("flights")
	List<Flight> all() {
		return repository.findAll();
	}

	@PostMapping("flights")
	Flight newFlight(@RequestBody Flight newFlight) {
		return repository.save(newFlight);
	}

	// Single item

	@GetMapping("flights/{id}")
	ResponseEntity one(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(repository.findById(id)
					.orElseThrow(() -> new FlightNotFoundException(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("flights/{id}")
	Flight replaceFlight(@RequestBody Flight newFlight, @PathVariable Long id) {

		return repository.findById(id)
				.map(flight -> {
					flight.setFlightNumber(newFlight.getFlightNumber());
					flight.setOrigin(newFlight.getOrigin());
					flight.setDestination(newFlight.getDestination());
					flight.setFlightTime(newFlight.getFlightTime());
					flight.setFlightNumber(newFlight.getFlightNumber());
					flight.setOneWay(newFlight.isOneWay());
					return repository.save(flight);
				})
				.orElseGet(() -> {
					return repository.save(newFlight);
				});
	}

	@DeleteMapping("flights/{id}")
	void deleteFlight(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
