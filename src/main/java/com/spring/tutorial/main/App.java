package com.spring.tutorial.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.tutorial.config.AppConfig;
import com.spring.tutorial.model.EmployeeDTO;
import com.spring.tutorial.service.AwareService;
import com.spring.tutorial.service.EmployeeManager;

public class App {
	public static void main(String[] args) {

		/*
		 * IMPORTANT NOTE:
		 * 
		 * This is a very important point to remember, if we will create
		 * Employee bean using new operator the advices will not be applied.
		 * Only when we will use ApplicationContext to get the bean, advices
		 * will be applied.
		 * 
		 */

		/* Method 1: Running application without using .xml configuration */
		AbstractApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
		// to demo event handling
		context1.start();
		// Byname Autowiring
		EmployeeManager manager = (EmployeeManager) context1.getBean("employeeManager");

		manager.getEmployeeById(1);
		manager.createEmployee(new EmployeeDTO());

		System.out.println("###################################################");

		/* Method 2: Running application using .xml configuration */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeManager manager1 = (EmployeeManager) context.getBean("employeeManager");

		manager1.getEmployeeById(1);
		manager1.createEmployee(new EmployeeDTO());
		manager1.addEmployeeReturnValue();
		manager1.addEmployeeAround("someone");
		manager1.simpleEmployeeGetter();
		manager1.customAnnotationDemoMethod();
		
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
		context2.getBean("awareService", AwareService.class);
		context2.close();
	}
}