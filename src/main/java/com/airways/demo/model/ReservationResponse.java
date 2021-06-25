package com.airways.demo.model;

public class ReservationResponse {
	
	private int seatNumber;
	private String status;
	private String message;

	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ReservationResponse()
    {
    	
    }

	public ReservationResponse(String status) {
		super();
		this.status = status;
	}
	
	public ReservationResponse(int seatNumber, String status) {
		super();
		this.seatNumber = seatNumber;
		this.status = status;
	}
	
	public ReservationResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	


}
