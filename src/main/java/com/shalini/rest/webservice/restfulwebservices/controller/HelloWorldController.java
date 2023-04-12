package com.shalini.rest.webservice.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   
	@GetMapping("/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable("name")String name) {
		return new HelloWorldBean(String.format("Hello World ,%s,",name));
	}
}
