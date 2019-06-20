package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.restfulwebservices.post.Post;


@Entity
public class User {
	
	@Id
	@GeneratedValue(generator = "UserIdSequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "UserIdSequence", sequenceName = "P_USER_ID_SEQUENCE")
	private Integer id;
	
	@Size(min = 2,message = "O tamanho do nome deve ser maior que 2")
	private String name;
	
	@Past
	private Date birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	
	public User() {
		super();
	}



	public User(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthDate;
	}
	public void setBirthdate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
	
	

	
}
