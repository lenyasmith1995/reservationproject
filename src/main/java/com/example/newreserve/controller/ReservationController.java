package com.example.newreserve.controller;


import java.sql.Date;
import java.sql.Time;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.newreserve.model.Requestmodel2;
import com.example.newreserve.model.reservationmodel;
import com.example.newreserve.service.requestService;
import com.example.newreserve.service.reservationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

@Controller
@ControllerAdvice
public class ReservationController {
	
	@GetMapping("/")
	public String request() {
		return "myrequest2";
	}
	
	@Autowired
	DataSource dataSource;
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException(MethodArgumentNotValidException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
	
	@PostMapping("/request/create")
	public String createRequest(@Valid Requestmodel2 request, HttpSession session) {
		int tableid;
		requestService rs = new requestService(dataSource);
		session.setAttribute("date", request.getDate());
		session.setAttribute("time", request.getTime());
		session.setAttribute("counter", request.getCounter());
		tableid = rs.freetable(request, session);
		if (tableid!=0) {
		session.setAttribute("tableid", tableid);
		rs.saveRequest(request, session, tableid);
		return "myreservation";
		}
		else return "emptyspace";
		
	}
	
	@PostMapping("/reservation/create")
	public String createReservation(@Valid reservationmodel reserve, HttpSession session) {
		reservationService reservs = new reservationService(dataSource, (Date)session.getAttribute("date") , (Time)session.getAttribute("time"), (int)session.getAttribute("counter"));
		reservs.saveReservation(reserve, session);
		return "finish";
		
	}
	
	@GetMapping("/full")
	public String comeback() {
		return "myrequest2";
	
	}
		
	@GetMapping("/allgood")
		public String go() {
			return "myrequest2";
	
	}
	
}
