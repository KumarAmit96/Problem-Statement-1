package com.airways.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.airways.demo.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("from Flight where flight_no=:orderNumber")
    Flight getFlightByFlightNo(@Param("orderNumber")int orderNumber);

}

