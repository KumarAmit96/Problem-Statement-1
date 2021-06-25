package com.airways.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airways.demo.model.Reservation;
import com.airways.demo.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

}
