package com.example.newreserve.repository;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SQLConnection {
	
	private final String INSERT_SQL_request = "INSERT INTO  Request (SessionID, PlaceID, requesttime, reservationdate, reservationtime, reservationcounter, Solution, TableID) VALUES (?,?,?,?,?,?,?,?)";
	private final String INSERT_SQL_reserve = "INSERT INTO  Reservation (SessionID, PlaceID, ContactName, ReservationTimeRequest, ContactString, ContactComment, TableID, reservationdate, reservationtime, reservationcounter) VALUES (?,?,?,?,?,?,?,?,?,?)";

	public JdbcTemplate jdbcTemplate;
	
	public SQLConnection(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveTableRequest(String sessionID, int PlaceID , Timestamp currentTimeStamp, Date inputdate, Time inputtime, int inputcounter, boolean solution, int TableID) {
		 
				jdbcTemplate.update(INSERT_SQL_request, sessionID, PlaceID, currentTimeStamp, inputdate, inputtime, inputcounter, solution, TableID);
				
	}

	public void saveTableReservation(String sessionID, int placeID, String name, Timestamp currentTimeStamp, String contactString, String comment, int tableID, Date inputdate, Time inputtime, int inputcounter) {
		jdbcTemplate.update(INSERT_SQL_reserve, sessionID, placeID, name, currentTimeStamp, contactString, comment, tableID, inputdate, inputtime, inputcounter);
		
	}

	public int lookForTable(int placeID, Date inputdate, Time inputtime, int inputcounter) {
		// TODO Auto-generated method stub
		return 1;
	}
	

}
