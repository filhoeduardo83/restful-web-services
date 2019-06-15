package com.in28minutes.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ListaVaziaException extends RuntimeException{

	public ListaVaziaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
