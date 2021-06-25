package com.airways.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "flight_no")
	private int flightNumber;

	@Column(name = "seats_number")
	private int seatNumber;
	    
	@Column(name = "user_name")
	private String userName;
	
	public Reservation() {
		
	}

	public Reservation(int seatNumber, String userName) {
		super();
		this.seatNumber = seatNumber;
		this.userName = userName;
	}
	
	public Reservation(int flightNumber, int seatNumber, String userName) {
		super();
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	


}
