package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

PostDaoService service;

@GetMapping("/user/{id}/posts/")
public List<Post> listaPostUser(@PathVariable Integer id){	return service.listPostUser (id);
	
}

//get posts user
//post post 

	
	
}
