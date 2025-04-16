package com.lot.crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lot.crud.Models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
