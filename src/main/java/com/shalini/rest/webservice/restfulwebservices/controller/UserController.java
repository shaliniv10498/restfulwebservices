package com.shalini.rest.webservice.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shalini.rest.webservice.resfulwebservices.service.UserDaoService;
import com.shalini.rest.webservice.restfulwebservices.exception.UserNotFoundException;
import com.shalini.rest.webservice.restfulwebservices.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
	public EntityModel<User> getUserById(@PathVariable("id") int id) {
		User user = userDaoService.findByUserById(id);
		if(user == null) {
			throw new UserNotFoundException("id : "+id);
		}
		//hateaos to make response dynamic for the end user;
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@Operation(summary = "Creates a new book")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "201", description = "Created book"),
	@ApiResponse(responseCode = "400", description = "Bad request"),
	@ApiResponse(responseCode = "500", description = "Server Error")})
	@PostMapping("/users/add")
	public ResponseEntity<Boolean> createUser(@RequestBody @Valid User user){
		userDaoService.addUser(user.getName(),user.getBirthDate());
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") int id) {
		 userDaoService.deleteUserById(id);
		 return new ResponseEntity<>(true,HttpStatus.OK);
	}
}
