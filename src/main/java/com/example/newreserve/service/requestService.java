package com.example.newreserve.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.example.newreserve.model.Requestmodel2;
import com.example.newreserve.repository.SQLConnection;

import jakarta.servlet.http.HttpSession;

@Component
public class requestService {
	
	DataSource dataSource;
	
	public requestService(DataSource dataSource) {
		this.dataSource =  dataSource;
	}
	
	public void saveRequest(Requestmodel2 request, HttpSession session) {
		Date inputdate = request.getDate();
		Time inputtime = request.getTime();
		int inputcounter = request.getCounter();
		
		String sessionID = session.getId();
		int PlaceID = 3;
		boolean solution = false;
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		int TableID = 1;
		
		
		SQLConnection sqlconn = new SQLConnection(dataSource);
		sqlconn.saveTableRequest(sessionID, PlaceID , currentTimeStamp, inputdate, inputtime, inputcounter, solution, TableID);
		
		
	}
}
