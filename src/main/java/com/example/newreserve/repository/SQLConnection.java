package com.example.newreserve.repository;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SQLConnection {
	
	private final String INSERT_SQL = "INSERT INTO  Request (SessionID, PlaceID, requesttime, reservationdate, reservationtime, reservationcounter, Solution, TableID) VALUES (?,?,?,?,?,?,?,?)";

	public JdbcTemplate jdbcTemplate;
	
	public SQLConnection(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveTableRequest(String sessionID, int PlaceID , Timestamp currentTimeStamp, Date inputdate, Time inputtime, int inputcounter, boolean solution, int TableID) {
		 
				jdbcTemplate.update(INSERT_SQL, sessionID, PlaceID, currentTimeStamp, inputdate, inputtime, inputcounter, solution, TableID);
				
	}
	

}
