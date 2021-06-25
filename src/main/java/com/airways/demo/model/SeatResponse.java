package com.airways.demo.model;

public class SeatResponse {
	
	private String status;
    
    private int seatNumber;
    
    public SeatResponse()
    {}

	public SeatResponse(String status, int seatNumber) {
	    this.status = status;
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
