package com.shalini.rest.webservice.resfulwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shalini.rest.webservice.restfulwebservices.model.User;

@Component
public class UserDaoService {
	
	

	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1,"Shalini","10thJan1996"));
		users.add(new User(2,"Anjali","20thJan1996"));
	}
	public static int userId = 2;
	public List<User> findAll(){
		return users;
	}
	
	public User findByUserById(int id) {
		return  users.stream()
				.filter(user -> user.getId().equals(id)).findFirst().get();
	}
	
	public void addUser(String name, String birth) {
		++userId;
		User user = new User(userId,name,birth);
		users.add(user);
	}
}
