package com.shalini.rest.webservice.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shalini.rest.webservice.resfulwebservices.service.UserDaoService;
import com.shalini.rest.webservice.restfulwebservices.exception.UserNotFoundException;
import com.shalini.rest.webservice.restfulwebservices.model.Post;
import com.shalini.rest.webservice.restfulwebservices.model.User;
import com.shalini.rest.webservice.restfulwebservices.repository.PostRepository;
import com.shalini.rest.webservice.restfulwebservices.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserControllerJpa {


	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepo;
	
	public UserControllerJpa() {}
	public UserControllerJpa(UserDaoService userDaoService,
			UserRepository userRepository, PostRepository postRepo) {
		super();
		this.userDaoService = userDaoService;
		this.userRepository = userRepository;
		this.postRepo = postRepo;
	}



	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id : "+id);
		}
		//hateaos to make response dynamic for the end user;
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@Operation(summary = "Creates a new book")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "201", description = "Created book"),
	@ApiResponse(responseCode = "400", description = "Bad request"),
	@ApiResponse(responseCode = "500", description = "Server Error")})
	@PostMapping("/jpa/users/add")
	public ResponseEntity<Boolean> createUser(@RequestBody @Valid User user){
		userRepository.save(user);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@DeleteMapping("/jpa/users/delete/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") int id) {
		userRepository.deleteById(id);
		 return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable("id") int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id : "+id);
		}
		 return new ResponseEntity<>(user.get().getPosts(),HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{id}/posts/add")
	public ResponseEntity<Post> createPostsForUser(
			@PathVariable("id") int id, @RequestBody @Valid Post post){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id : "+id);
		}
		post.setUser(user.get());
		Post savedPost = postRepo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return new ResponseEntity<>(savedPost,HttpStatus.OK);
	}
	
}
