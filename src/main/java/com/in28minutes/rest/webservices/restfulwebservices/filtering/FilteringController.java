package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/beanfiltrado")
	public SomeBean RecoveryBean () {
		return new SomeBean("valor 1","valor 2","valor 3");
	}

}
