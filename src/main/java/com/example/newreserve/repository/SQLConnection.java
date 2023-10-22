package com.example.newreserve.repository;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLConnection {
	
	private final String INSERT_SQL_request = "INSERT INTO  Request (SessionID, PlaceID, requesttime, reservationdate, reservationtime, reservationcounter, Solution, TableID) VALUES (?,?,?,?,?,?,?,?)";
	private final String INSERT_SQL_reserve = "INSERT INTO  Reservation (SessionID, PlaceID, ContactName, ReservationTimeRequest, ContactString, ContactComment, TableID, reservationdate, reservationtime, reservationcounter) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT_TABLE_1="IF OBJECT_ID('tempdb..#TempTbl') IS NOT NULL DROP TABLE #TempTbl\n"
			+ "DECLARE @StartTime time\n"
			+ "DECLARE @EndTime time\n"
			+ "DECLARE @ReservationTime time\n"
			+ "DECLARE @TimeLag time\n"
			+ "DECLARE @RightSide time\n"
			+ "\n"
			+ "SET @StartTime = (SELECT MondayStart\n"
			+ "     FROM Shedule\n"
			+ "      WHERE SheduleId = 1)\n"
			+ "SET @EndTime = (SELECT MondayEnd\n"
			+ "     FROM Shedule\n"
			+ "      WHERE SheduleId = 1)\n"
			+ "SET @TimeLag = (SELECT TimeLag\n"
			+ "     FROM Shedule\n"
			+ "      WHERE SheduleId = 1)\n"
			+ "SET @ReservationTime = ?\n"
			+ "\n"
			+ "IF DATEDIFF(HOUR, (SELECT DATEDIFF(HOUR, cast('00:00:00' as time), @ReservationTime)), @EndTime )   < (SELECT DATEDIFF(HOUR, cast('00:00:00' as time),@TimeLag))\n"
			+ "       SET @RightSide =  @EndTime\n"
			+ "ELSE \n"
			+ "       SET @RightSide = (SELECT DATEADD( HOUR , (SELECT DATEDIFF(HOUR, cast('00:00:00' as time), @TimeLag)) , @ReservationTime))\n"
			+ "\n"
			+ "SELECT @StartTime AS StartTime,  \n"
			+ "   @EndTime AS EndTime, \n"
			+ "    @ReservationTime AS ReservationTime, \n"
			+ "     @TimeLag AS TimeLag,\n"
			+ "      @RightSide AS RightSide\n"
			+ "       INTO #TempTbl\n"
			+ "\n"
			+ ";\n"
			+ "\n"
			+ "with timetablenew as(\n"
			+ "SELECT * \n"
			+ "FROM [dbo].[TIMETABLE]('2020-10-05','2020-11-05')\n"
			+ ")\n"
			+ "\n"
			+ "SELECT TOP(1) TB.InsideID  \n"
			+ "FROM (\n"
			+ "  SELECT TB.InsideID, COUNT(reservationtime) AS RESERVE\n"
			+ "  FROM  (timetablenew tt FULL OUTER JOIN TableObj TB\n"
			+ "    ON TB.MinSeats <= ?\n"
			+ "    AND TB.MaxSeats >= ?\n"
			+ "    AND TB.PlaceID = ?\n"
			+ "    AND timeOfDay BETWEEN (SELECT StartTime\n"
			+ "          FROM #TempTbl\n"
			+ "          ) AND (SELECT EndTime\n"
			+ "            FROM #TempTbl\n"
			+ "            )\n"
			+ "    AND timeOfDay BETWEEN (SELECT DATEADD(HOUR, DATEDIFF(MINUTE, TimeLag, ReservationTime) / 60,\n"
			+ "          DATEADD(MINUTE, DATEDIFF(MINUTE, TimeLag, ReservationTime) / 3600, CAST('00:00:00' AS TIME)))\n"
			+ "          FROM #TempTbl\n"
			+ "         ) AND (SELECT RightSide\n"
			+ "          FROM #TempTbl)\n"
			+ "    )\n"
			+ "         LEFT JOIN Reservation re\n"
			+ "   ON tt.timeofday = re.reservationtime\n"
			+ "   AND TB.InsideID = re.TableID\n"
			+ "   AND reservationdate = ?\n"
			+ "  WHERE InsideID IS NOT NULL AND timeOfDay IS NOT NULL\n"
			+ "  GROUP BY InsideID\n"
			+ "  --ORDER BY MaxSeats ASC, Score DESC, TB.InsideID, timeOfDay ASC\n"
			+ "\n"
			+ " ) AS MYTABLE RIGHT JOIN TableObj TB\n"
			+ "  ON TB.InsideID = MYTABLE.InsideID\n"
			+ " WHERE RESERVE IS NOT NULL AND RESERVE < 1\n"
			+ " ORDER BY RESERVE DESC, MaxSeats ASC, Score DESC\n"
			+ "\n"
			+ "OPTION (MAXRECURSION 0)";
	
	
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
		List<Integer> tableIds = new ArrayList<Integer>();
		int tableId;
		try {
			tableIds= jdbcTemplate.queryForList(SELECT_TABLE_1,Integer.class, inputtime, inputcounter, inputcounter, placeID, inputdate);
		} 
		catch (IncorrectResultSizeDataAccessException e) {
			return 0;
		   }
		try {
			tableId = tableIds.get(0);
			return tableId;
		} 
		catch (java.lang.IndexOutOfBoundsException e) {
			return 0;
		   }
	}

		
	
	

}
