package com.shalini.rest.webservice.restfulwebservices.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //globalexception handling accross all controller classes
public class CustomisedResponseEntityHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, 
			WebRequest request) throws Exception {
		//customised error response, to get this we need to use ControllerAdvice too.
      ErrorDetails error = new ErrorDetails(LocalDate.now(), ex.getMessage(),ex.getLocalizedMessage());
	  
      return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//UserNotFoundException occurrs what kind of http status, 
	//error response needs to returned
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotException(Exception ex, 
			WebRequest request) throws Exception {
		//customised error response, to get this we need to use ControllerAdvice too.
      ErrorDetails error = new ErrorDetails(LocalDate.now(), ex.getMessage(),ex.getLocalizedMessage());
	  
      return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
