package com.lot.crud;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PassengerController {

	private final PassengerRepository repository;

	PassengerController(PassengerRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("passengers")
	List<Passenger> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("passengers")
	Passenger newPassenger(@RequestBody Passenger newPassenger) {
		return repository.save(newPassenger);
	}

	// Single item

	@GetMapping("passengers/{id}")
	Passenger one(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@PutMapping("passengers/{id}")
	Passenger replacePassenger(@RequestBody Passenger newPassenger, @PathVariable Long id) {

		return repository.findById(id)
				.map(passenger -> {
					passenger.setFirstName(newPassenger.getFirstName());
					passenger.setLastName(newPassenger.getLastName());
					passenger.setEmail(newPassenger.getEmail());
					passenger.setPhoneNumber(newPassenger.getPhoneNumber());
					return repository.save(passenger);
				})
				.orElseGet(() -> {
					return repository.save(newPassenger);
				});
	}

	@DeleteMapping("passengers/{id}")
	void deletePassenger(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
