package com.airways.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airways.demo.model.Flight;
import com.airways.demo.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public void saveFlight(Flight flight) {
		flightRepository.save(flight);		
	}
	
	public Flight getFlight(int flightNumber)
	{
		
		Flight flightOptional = flightRepository.getFlightByFlightNo(flightNumber);
        if (flightOptional == null) {
            return null;
        }
        return flightOptional;
	}
	
	public void delete(long id)
	{
		flightRepository.deleteById(id);
	}

}
