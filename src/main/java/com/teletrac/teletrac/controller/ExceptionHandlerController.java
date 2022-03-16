package com.teletrac.teletrac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
	public ResponseEntity<HttpStatus> requestHandlingNoHandlerFound() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
