package com.shalini.rest.webservice.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
  private LocalDate timestamp;
  private String message;
  private String Details;
public ErrorDetails(LocalDate timestamp, String message, String details) {
	super();
	this.timestamp = timestamp;
	this.message = message;
	Details = details;
}
/**
 * @return the timestamp
 */
public LocalDate getTimestamp() {
	return timestamp;
}
/**
 * @return the message
 */
public String getMessage() {
	return message;
}
/**
 * @return the details
 */
public String getDetails() {
	return Details;
}
  
  
}
