package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.ListaVaziaException;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UsuarioNaoEncontadoException;

@RestController
public class UserJPAResource {

	@Autowired
	public UserDaoService service;
	
	@Autowired
	public UserRepository UserRepository;

	@GetMapping("jpa/users")
	public List<User> retrieveAllUsers() {
		return UserRepository.findAll();

	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveOneUser(@PathVariable Integer id) {
		Optional<User> user = UserRepository.findById(id);
		if (user==null) {
			//throw new UsuarioNaoEncontadoException("id - "+ id);
			throw new UsuarioNaoEncontadoException("id - "+ id);
		}
		
		return user;

	}


	@DeleteMapping("jpa/users/{id}")
	public void deleteOneUser(@PathVariable Integer id) {
		User user = service.deleteUser(id);
		if (user==null) {
			//throw new UsuarioNaoEncontadoException("id - "+ id);
			throw new UsuarioNaoEncontadoException("id - "+ id);
		}
	}
	/*
	 * @PostMapping("/users") 
	 * public String addUser(@RequestBody User newUser){
	 * service.saveUser(newUser); return
	 * String.format("Usuário adicionado com o Identificador: %s", newUser.getId());
	 * }
	 */

	

	 @PostMapping("jpa//users") 
	 public ResponseEntity<Object> addUser(@Valid @RequestBody User newUser){
		 //Adiciona o Usuário
		 service.saveUser(newUser);
		 //Monta a URI de resposta baseado no usuário criado
		 URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		 //retorna uma RespostaEntidy p retornar 201
		 return ResponseEntity.created(local).build();
	 }
	 
}
