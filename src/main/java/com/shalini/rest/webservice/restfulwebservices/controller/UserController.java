package com.shalini.rest.webservice.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shalini.rest.webservice.resfulwebservices.service.UserDaoService;
import com.shalini.rest.webservice.restfulwebservices.model.User;

@RestController
public class UserController {


	@Autowired
	private UserDaoService userDaoService;
	
	
	public UserController() {}
	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}



	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userDaoService.findByUserById(id);
	}
	
	@PostMapping("/users/add")
	public ResponseEntity<Boolean> createUser(@RequestBody User user){
		userDaoService.addUser(user.getName(),user.getBirthDate());
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
}
