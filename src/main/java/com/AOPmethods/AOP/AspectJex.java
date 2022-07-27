package com.AOPmethods.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJex {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	// exection
	@Pointcut("execution(public String com.AOPmethods.AOP.mainClass.greet(..))")
	public void greetPointcut() {
	}

	@Before("greetPointcut()")
	public void beforeWishingPointCut(JoinPoint joinpoint) {
		System.out.println(joinpoint.getArgs());
		logger.info("Before method, In greetPointcut");
	}

	@AfterReturning(pointcut = "greetPointcut()", returning = "str")
	public void after(String str) {
		System.out.println(str + " in after");
		logger.info("AfterReturning Method, In greetPointcut");
	}

	@After("greetPointcut()")
	public void before(JoinPoint joinpoint) {
		System.out.println(joinpoint.getSignature());
		logger.info("After Method, In greetPointcut");
	}

	@AfterThrowing(value = "greetPointcut()", throwing = "e")
	public void throwing(Exception e) {
		logger.info(e.getMessage());
	}
	
	@Around("greetPointcut()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object object = proceedingJoinPoint.proceed();
		if  (object instanceof Integer) {
			logger.info("In @Around Method, In greetPointCut()");
			System.out.println("Instance is String");
		}
		else {
			logger.info("In @Around Method, In greetPointCut()");
			System.out.println("Instance is Not String");
			
		}
	}
	
	//within
	@Pointcut("within(com.AOPmethods.AOP.*)") // give path upto class level only
	public void mainClassPointCut() {}
	
	@Before("mainClassPointCut()")
	public void beforeOfMainClass() {
		logger.info("Before main class using within pointcut");
	}
	
	//this
	@Pointcut("this(com.AOPmethods.AOP.mainClass)") // give path upto class level only
	public void thisMainClassPointCut() {}
	
	@Before("thisMainClassPointCut()")
	public void beforeOfThisMainClass() {
		logger.info("Before main class using this pointcut");
	}
	
	


}
