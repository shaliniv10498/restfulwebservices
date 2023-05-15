package com.shalini.rest.webservice.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shalini.rest.webservice.restfulwebservices.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}
