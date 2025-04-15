package com.lot.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lot.crud.Repositories.PassengerRepository;
import com.lot.crud.Models.Passenger;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(PassengerRepository repository) {

		return args -> {
			// log.info("Preloading " + repository
			// .save(new Passenger("Bilbo", "Baggins", "bb@hill.com", "000000000")));
		};
	}
}
