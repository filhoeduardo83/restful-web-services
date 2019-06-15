package com.in28minutes.rest.webservices.restfulwebservices.user;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;

@Component
public class UserDaoService {


	private static List<User> users = new ArrayList<>();
	
	private int countUser=3;
	
	

	
	  static { users.add(new User(1,"Eduardo", new Date())); users.add(new
	  User(2,"Fernanda", new Date())); users.add(new User(3,"Eliene", new Date()));
	  
	  }
	 
		
	public List<User> findAll() {
		return users;
	}

	public Integer saveUser(User novoUser){
		novoUser.setId(++countUser);
		users.add(novoUser);
		return novoUser.getId();
	}
	
	public User findUser(@PathVariable Integer id) {
		for (User user:users)
		if (user.getId()==id) {
			return user;
		}
		return null;
	}
	
	public User deleteUser(@PathVariable Integer id) {
		
		Iterator<User> iterator= users.iterator();
		
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
