package com.example.newreserve.model;

import java.sql.Date;
import java.sql.Time;

public class Requestmodel2 {
	
	private Date date;
	private String time;
	private int counter;  
	
	
	public Requestmodel2(Date inputdate, String inputtime, int inputcounter) {
		this.date=inputdate;
		this.time=inputtime;
		this.counter=inputcounter;
	}
	
	
	
	public Date getDate() {  
	    return date;  
	}   
	public void setDate(Date date) {  
	    this.date = date;  
	}   
	public void displayDate(){  
	    System.out.println("Date: "+date);  
	}  
	
	
	public Time getTime() {  
	    return Time.valueOf(time+":00");  
	}   
	public void setTime(String time) {  
	    this.time = time;  
	}    
	public void displayTime(){  
	    System.out.println("Time: "+time);  
	} 
	
	
	
	public int getCounter() {  
	    return counter;  
	}  
	public void setCounter(int counter) {  
	    this.counter = counter;  
	}   
	public void displayCounter(){  
	    System.out.println("Counter: "+counter);  
	}  
	
	
}
