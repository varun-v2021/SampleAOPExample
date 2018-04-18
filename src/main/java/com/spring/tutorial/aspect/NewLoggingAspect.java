package com.spring.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//This advice, as the name implies, is executed before the join point. 
//It does not prevent the continued execution of the method it advises unless an exception is thrown.
//Consider the following aspect that simply logs the method name before it is called:

@Component
@Aspect
public class NewLoggingAspect {
	@Pointcut("@target(org.springframework.stereotype.Repository)")
	public void repositoryMethods() {
	};

	@Before("repositoryMethods()")
	public void logMethodCall(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("Before " + methodName);
	}
	/*
	 * The logMethodCall advice will be executed before any repository method
	 * defined by the repositoryMethods pointcut.
	 */
}
