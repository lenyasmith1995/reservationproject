package com.example.newreserve.model;


import java.sql.Time;
import java.sql.Date;


import org.springframework.format.annotation.DateTimeFormat;

/*import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;*/


public class Requestmodel {
	
	@DateTimeFormat(pattern="DD/MM/YYYY")
	/* @NotNull @Future */
	private Date date;
	/* @NotNull */
	private Time time;
	/* @NotNull @Min(1) @Max(8) */
	private int counter;  
	
	
	public Requestmodel(String inputdate, String inputtime, int inputcounter) {
		this.date=java.sql.Date.valueOf(inputdate);
		this.time=java.sql.Time.valueOf(inputtime);
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
	    return time;  
	}   
	public void setTime(Time time) {  
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
