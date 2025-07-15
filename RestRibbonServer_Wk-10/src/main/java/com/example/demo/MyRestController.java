package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	@Autowired
	Environment environment;
	
	@GetMapping("/")
	public String health() {
		return "Server is running right now";
	}
	
	@GetMapping("/backend")
	public String backend() {
		System.out.println("Inside MyRestController::backend...");
		String serverport = environment.getProperty("local.server.port");
		System.out.println("Port: " + serverport);
		
		return "Running Host: Localhost::Port" + serverport;
	}
}
