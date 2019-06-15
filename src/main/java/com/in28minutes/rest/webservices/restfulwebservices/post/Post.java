package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.Date;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;

public class Post extends User{

String mensagem;
Date data;

public Post(int id, String name, Date birthDate, String mensagem, Date data) {
	super(id, name, birthDate);
	this.mensagem = mensagem;
	this.data = data;
}



}
