package com.shalini.rest.webservice.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shalini.rest.webservice.restfulwebservices.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World API";
	}
	
	@GetMapping("/helloworldbean")
	public HelloWorldBean helloWorldbean() {
		return new HelloWorldBean("This is a Hello World Bean");
	}

}
