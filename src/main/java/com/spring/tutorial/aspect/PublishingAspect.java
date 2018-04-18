package com.spring.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublishingAspect {

	private ApplicationEventPublisher eventPublisher;

	@Autowired
	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Pointcut("@target(org.springframework.stereotype.Repository)")
	public void repositoryMethods() {
	}

	//@Pointcut("execution(* *..create*(Long,..))")
	@Pointcut("execution(* com.spring.tutorial.service.EmployeeManagerImpl.*(..))")
	public void firstLongParamMethods() {
	}

	@Pointcut("repositoryMethods() && firstLongParamMethods()")
	public void entityCreationMethods() {
	}

	@AfterReturning(value = "entityCreationMethods()", returning = "entity")
	public void logMethodCall(JoinPoint jp, Object entity) throws Throwable {
		// eventPublisher.publishEvent(new FooCreationEvent(entity));
		System.out.println("Called after returning the expected value from the specifed methods");
	}
}
