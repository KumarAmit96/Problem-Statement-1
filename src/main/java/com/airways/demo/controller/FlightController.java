package com.airways.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airways.demo.model.Flight;
import com.airways.demo.model.Reservation;
import com.airways.demo.model.Response;
import com.airways.demo.model.SeatCount;
import com.airways.demo.model.SeatResponse;
import com.airways.demo.model.SingleStatus;
import com.airways.demo.service.FlightService;
import com.airways.demo.service.ReservationService;


@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	private FlightService flight;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(value = "/getAvailablesSeats",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFlightJson(@RequestParam String flightNumber ) {
		
        if(flight.getFlight(Integer.parseInt(flightNumber)) == null)
        {
        	return new ResponseEntity<>(new SingleStatus("Failure"), HttpStatus.BAD_REQUEST);
        }else
        {
        	return new ResponseEntity<>(new SeatCount("Success", flight.getFlight(Integer.parseInt(flightNumber)).getFlightSeat()), HttpStatus.OK);
        } 
    }

	
	@PostMapping(value = "/bookSeat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrUpdateFlight(@RequestParam(value = "flightNumber") int flightNumber,
                                                  @RequestParam(value = "userName") String userName)
    {
		int seatNum = 0;
		int count = 0;
		Flight flightResponse = flight.getFlight(flightNumber);
		if(flightResponse == null)
        {
        	return new ResponseEntity<>(new SingleStatus("Failure"), HttpStatus.BAD_REQUEST);
        }else if(flightResponse.getFlightSeat() == 0)
        {
        	return new ResponseEntity<>(new Response("Failure","Flight is full"), HttpStatus.OK);
        }else
        {
        	count = flightResponse.getFlightSeat();
        	int seat_no = seatNum = flightResponse.getAvailableSeat();
        	flight.delete(flightResponse.getId());
        	reservationService.saveReservation(new Reservation(flightNumber, seatNum, userName));
        	flight.saveFlight(new Flight(flightNumber,--count, ++seat_no));
        } 
		
		return new ResponseEntity<>(new SeatResponse("Success", seatNum), HttpStatus.OK);
    }
    
	@PostMapping(value = "/scheduleFlight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrUpdateFlight(@RequestParam(value = "flightNumber") int flightNumber,
                                                  @RequestParam(value = "noOfSeats") int noOfSeats)
    {
		Flight flightResponse = flight.getFlight(flightNumber);
		if(flightResponse == null)
        {
        	flight.saveFlight(new Flight(flightNumber,noOfSeats, 1));
        	return new ResponseEntity<>(new SingleStatus("Success"), HttpStatus.OK);
        }else if(flightResponse.getFlightSeat() == 0)
        {
        	flight.delete(flightResponse.getId());
        	flight.saveFlight(new Flight(flightNumber,noOfSeats, 1));
        	return new ResponseEntity<>(new SingleStatus("Success"), HttpStatus.OK);
        }
    	return new ResponseEntity<>(new Response("Failure","Flight already exist!"), HttpStatus.OK);

    }
    
    

}
