package com.shalini.rest.webservice.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shalini.rest.webservice.restfulwebservices.model.User;

public interface UserRepository extends JpaRepository<User,Integer	> {

}
