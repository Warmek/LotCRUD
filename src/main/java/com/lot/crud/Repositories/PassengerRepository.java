package com.lot.crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lot.crud.Models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
