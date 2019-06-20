package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//User find(Optional<User> userOptional);
	
	
}
