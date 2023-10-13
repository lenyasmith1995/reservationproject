package com.example.newreserve.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import com.example.newreserve.model.Requestmodel2;
import com.example.newreserve.repository.SQLConnection;

import jakarta.servlet.http.HttpSession;

public class requestService {
	
	DataSource dataSource;
	
	public requestService(DataSource dataSource) {
		this.dataSource =  dataSource;
	}
	
	public void saveRequest(Requestmodel2 request, HttpSession session, int tableid) {
		Date inputdate = request.getDate();
		Time inputtime = request.getTime();
		int inputcounter = request.getCounter();
		
		String sessionID = session.getId();
		int PlaceID = 3;
		boolean solution = false;
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		
		
		SQLConnection sqlconn = new SQLConnection(dataSource);
		sqlconn.saveTableRequest(sessionID, PlaceID , currentTimeStamp, inputdate, inputtime, inputcounter, solution, tableid);	
	}

	public int freetable(Requestmodel2 request, HttpSession session) {
		Date inputdate = request.getDate();
		Time inputtime = request.getTime();
		int inputcounter = request.getCounter();
	
		int PlaceID = 3;
		
		SQLConnection sqlconn = new SQLConnection(dataSource);
		int tableid = sqlconn.lookForTable(PlaceID,inputdate, inputtime, inputcounter);
		
		return tableid;
	}
	
	
}
