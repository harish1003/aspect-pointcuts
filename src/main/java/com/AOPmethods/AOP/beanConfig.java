package com.AOPmethods.AOP;

import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configurable
@Scope( scopeName = "com.AOPmethods.AOP")
@EnableAspectJAutoProxy
public class beanConfig {
	

}
