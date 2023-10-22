package com.example.newreserve.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Requestmodel2 {
	
    @Future(message = "Бронирование на прошедшую дату невозможно")
	private Date date;
	private String time;
    @Min( 
            value = 1, groups = Requestmodel2.class, 
            message 
	          = "Количество мест от 1 до 8")
    @Max( 
            value = 8, groups = Requestmodel2.class, 
            message 
	          = "Количество мест от 1 до 8") 
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
