package com.AOPmethods.AOP;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping(value = "/main/")
public class mainClass {

	@RequestMapping(value = "wish/", method = RequestMethod.GET)
	public String wishing() {
		return "Happy Birthday";
	}

	@RequestMapping(value = "greet/{name}/", method = RequestMethod.GET)
	public String greet(@PathVariable String name) {
//		 throw new RuntimeException("In @afterThrowing Exception raised ");
		return "Good Morning" + name;
	}

}
