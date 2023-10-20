package com.example.newreserve.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import com.example.newreserve.model.reservationmodel;
import com.example.newreserve.repository.SQLConnection;

import jakarta.servlet.http.HttpSession;

public class reservationService {
	
	DataSource dataSource;
	
	Date inputdate;
	Time inputtime;
	int inputcounter;
	
	public reservationService(DataSource dataSource,Date inputdate, Time inputtime, int inputcounter) {
		this.dataSource =  dataSource;
		this.inputdate = inputdate;
		this.inputtime = inputtime;
		this.inputcounter = inputcounter;
	}
	
	public void saveReservation(reservationmodel reserve, HttpSession session) {
		String name = reserve.getname();
		String phone1 = reserve.getphone1();
		String phone2 = reserve.getphone2();
		String comment = reserve.getcomment();
		
		String ContactString = String.format("8%s%s",phone1, phone2);
		
		String sessionID = session.getId();
		int PlaceID = 3;
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		int TableID = (int)session.getAttribute("tableid");
		
		
		SQLConnection sqlconn = new SQLConnection(dataSource);
		sqlconn.saveTableReservation(sessionID, PlaceID , name, currentTimeStamp, ContactString, comment, TableID, inputdate, inputtime, inputcounter);
		
		
	}
}
