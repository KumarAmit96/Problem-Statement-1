package com.airways.demo.model;

public class SeatCount {
	
	private String status;
    
    private int count;
    
    public SeatCount()
    {}
    
	public SeatCount(String status, int count) {
	    this.status = status;
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
