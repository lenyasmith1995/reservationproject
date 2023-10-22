package com.example.newreserve.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class reservationmodel {
	
    @NotBlank(message = "Поле имя не должно быть пустым")
	private String  clientname;
    @NotBlank(message = "Номер телефона не должен быть пустым") 
    @Size( 
    		min = 3, max = 3, 
            message 
	          = "Здесь должен быть трехзначный префикс номера телефона формата 929,916, и тд.")
	private String clientphone1;
    @NotBlank(message = "Номер телефона не должен быть пустым") 
    @Size( 
            min = 7, max = 7,  
            message 
	          = "Здесь должен быть номера телефона без трехзначного префикса")
	private String clientphone2;
	private String  clientcomment;  
	
	
	public reservationmodel(String clientname, String clientphone1, String clientphone2, String clientcomment) {

		this.clientname=clientname;
		this.clientphone1=clientphone1;
		this.clientphone2=clientphone2;
		this.clientcomment=clientcomment;
	}
	
	
	
	public String getname() {  
	    return clientname;  
	}   
	public void setname(String clientname) {  
	    this.clientname = clientname;  
	}   
	public void displayname(){  
	    System.out.println("Name: "+clientname);  
	}  
	
	
	public String getphone1() {  
	    return clientphone1;  
	}   
	public void setphone1(String clientphone1) {  
	    this.clientphone1 = clientphone1;  
	}    
	public void displayphone1(){  
	    System.out.println("Phone: "+clientphone1);  
	} 
	
	
	public String getphone2() {  
	    return clientphone2;  
	}   
	public void setphone2(String clientphone2) {  
	    this.clientphone2 = clientphone2;  
	}    
	public void displayphone2(){  
	    System.out.println("Phone: "+clientphone2);  
	} 
	
	
	public String getcomment() {  
	    return clientcomment;  
	}  
	public void setCounter(String clientcomment) {  
	    this.clientcomment = clientcomment;  
	}   
	public void displaycomment(){  
	    System.out.println("Comment: "+clientcomment);  
	}  
	
	
}