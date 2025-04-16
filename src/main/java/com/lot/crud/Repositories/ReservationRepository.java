package com.lot.crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lot.crud.Models.Reservation;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findBySeatNumberAndFlightNumber(Long flightNumber, Long seatNumber);

	List<Reservation> findByPassengerId(Long passengerId);
}
