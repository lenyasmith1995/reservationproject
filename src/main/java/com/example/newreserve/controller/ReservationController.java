package com.example.newreserve.controller;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.newreserve.model.Requestmodel2;
import com.example.newreserve.service.requestService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {
	
	@GetMapping("/")
	public String request() {
		return "myrequest2";
	}
	
	@GetMapping("/print")
	public String print() {
		return "TOMCAT hello!";
	}
	
	@Autowired
	DataSource dataSource;
	
	@PostMapping("/request/create")
	public String createRequest(Requestmodel2 request, HttpSession session) {
		requestService rs = new requestService(dataSource);
		rs.saveRequest(request, session);
		return "myreservation";
		
	}
	
	
}
