package com.AOPmethods.AOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopMethodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopMethodsApplication.class, args);
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(beanConfig.class);
	}

}
