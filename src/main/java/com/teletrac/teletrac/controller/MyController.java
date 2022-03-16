package com.teletrac.teletrac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teletrac.teletrac.entities.PayloadWrapper;
import com.teletrac.teletrac.services.PayloadService;

@RestController
public class MyController {
	
	@Autowired
	private PayloadService payloadService;
	
	@GetMapping("/home")
	public String home() {
		String text = "this is private page";
		text+="this page is not allowed to unauthorised users";
		
		return text;
	}
	
	@GetMapping("/device")
	public String getDeviceId() {
		return this.payloadService.getDeviceId();		
	}
	
	@GetMapping("/echo")
	public PayloadWrapper getDevice() {		
		return this.payloadService.getPayload();		
	}
	
	@GetMapping("/nocontent")
	public ResponseEntity<HttpStatus> getNocontent() {		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	
	@PostMapping(path="/addpayload", consumes="application/json")
	public PayloadWrapper addPayload(@RequestBody PayloadWrapper payloadWrapper) {
	
		return this.payloadService.addPayload(payloadWrapper);		
	}
	
}
