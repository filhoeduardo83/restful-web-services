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
import com.in28minutes.rest.webservices.restfulwebservices.post.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.PostRepository;
//Controlador exemplo utilizando o banco de dados. Ele tiliza o Repository para acessar as tabelas do banco
@RestController
public class UserJPAResource {

	
	@Autowired
	public UserRepository userRepository;
	
	
	@Autowired
	public PostRepository postRepository;

//
	@GetMapping("jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();

	}

//Consulta um usuário por id
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveOneUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user==null) {
			//throw new UsuarioNaoEncontadoException("id - "+ id);
			throw new UsuarioNaoEncontadoException("id - "+ id);
		}
		
		return user;

	}

//Apaga um usuário
	@DeleteMapping("jpa/users/{id}")
	public void deleteOneUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	/*
	 * @PostMapping("/users") 
	 * public String addUser(@RequestBody User newUser){
	 * service.saveUser(newUser); return
	 * String.format("Usuário adicionado com o Identificador: %s", newUser.getId());
	 * }
	 */

	
//Insere usuário
	 @PostMapping("jpa/users") 
	 public ResponseEntity<Object> addUser(@Valid @RequestBody User newUser){
		 //Adiciona o Usuário
		 User savedUser = userRepository.save(newUser);
		 //Monta a URI de resposta baseado no usuário criado
		 URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		 //retorna uma RespostaEntidy p retornar 201
		 return ResponseEntity.created(local).build();
	 }
	 
//Busca dos posts de um usuário	 
		@GetMapping("jpa/users/{id}/posts")
		public List<Post> retrievePosts(@PathVariable Integer id) {
			//verifica se usuário existe
			Optional<User> user = userRepository.findById(id);
			if (!user.isPresent()) {
				throw new UsuarioNaoEncontadoException("id - "+ id);
			}
			
			
			return user.get().getPosts();

		}
		
		
//Insere post de um usuário
		 @PostMapping("jpa/users/{id}/posts") 
		 public ResponseEntity<Object> addPost(@PathVariable int id, @RequestBody Post post){
			//verifica se usuário existe
			 Optional<User> userOptional = userRepository.findById(id);
				if (!userOptional.isPresent()) {
					throw new UsuarioNaoEncontadoException("id - "+ id);
				}
			 User user = userOptional.get();
			 post.setUser(user);
			 postRepository.save(post);	 
			 
			 //Monta a URI de resposta baseado no posthj criado
			 URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
			 //retorna uma RespostaEntidy p retornar 201
			 return ResponseEntity.created(local).build();
		 }
}
