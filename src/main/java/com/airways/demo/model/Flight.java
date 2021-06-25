package com.airways.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "flight_no", unique = true)
    private int flightNumber;
    
    @Column(name = "flight_name")
    private String flightName;
    
    @Column(name = "flight_seat")
    private int flightSeat;

    @Column(name = "available_seat")
    private int availableSeat;
    
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public Flight() {
		
	}

	/*
	 * public Flight(int flightNumber, String flightName, int flightSeat, int
	 * availableSeat) { super(); this.flightNumber = flightNumber; this.flightName =
	 * flightName; this.flightSeat = flightSeat; this.availableSeat = availableSeat;
	 * }
	 */
	
	/*
	 * public Flight(String flightName, int flightSeat) { super(); this.flightName =
	 * flightName; this.flightSeat = flightSeat; }
	 */
	
	public Flight(int flightNumber, int flightSeat) {
		super();
		this.flightNumber = flightNumber;
		this.flightSeat = flightSeat;
	}
	
	public Flight(int flightNumber, int flightSeat, int availableSeat) {
		super();
		this.flightNumber = flightNumber;
		this.flightSeat = flightSeat;
		this.availableSeat = availableSeat;
	}



	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightSeat() {
		return flightSeat;
	}

	public void setFlightSeat(int flightSeat) {
		this.flightSeat = flightSeat;
	}
	
	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}
	
	
    
    
}
