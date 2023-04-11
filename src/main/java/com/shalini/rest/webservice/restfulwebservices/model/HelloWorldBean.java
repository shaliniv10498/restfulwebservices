package com.shalini.rest.webservice.restfulwebservices.model;

public class HelloWorldBean {
  private String message;

/**
 * @return the message
 */
public String getMessage() {
	return message;
}

/**
 * @param message the message to set
 */
public void setMessage(String message) {
	this.message = message;
}

public HelloWorldBean(String message) {
	super();
	this.message = message;
}
  

}
