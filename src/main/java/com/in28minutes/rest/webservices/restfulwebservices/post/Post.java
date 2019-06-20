package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;

@Entity

public class Post{
	
@Id
@GeneratedValue(generator = "PostIdSequence", strategy = GenerationType.SEQUENCE)
@SequenceGenerator(name = "PostIdSequence", sequenceName = "P_POST_ID_SEQUENCE")
private Integer id;

private String mensagem;

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
private User user;

public String getMensagem() {
	return mensagem;
}

public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
}


public Post(String mensagem, Date data) {
	super();
	this.mensagem = mensagem;
}

public Post() {
	super();
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}



}
