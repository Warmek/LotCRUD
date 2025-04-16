package com.lot.crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lot.crud.Models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
