package com.spring.tutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.tutorial.custom.annotation.Loggable;
import com.spring.tutorial.model.EmployeeDTO;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager {
	public EmployeeDTO getEmployeeById(Integer employeeId) {
		System.out.println("Method getEmployeeById() called");
		return new EmployeeDTO();
	}

	public List<EmployeeDTO> getAllEmployee() {
		System.out.println("Method getAllEmployee() called");
		return new ArrayList<EmployeeDTO>();
	}

	public void createEmployee(EmployeeDTO employee) {
		System.out.println("Method createEmployee() called");
	}

	public void deleteEmployee(Integer employeeId) {
		System.out.println("Method deleteEmployee() called");
	}

	public void updateEmployee(EmployeeDTO employee) {
		System.out.println("Method updateEmployee() called");
	}

	public String addEmployeeReturnValue() {
		System.out.println("addEmployeeReturnValue() is running ");
		return "abc";
	}

	public void addEmployeeAround(String name) {
		System.out.println("addCustomerAround() is running, args : " + name);
	}

	public String simpleEmployeeGetter() {
		return "test";
	}

	@Loggable // This is a custom annotation defined in Loggable.java
	public void customAnnotationDemoMethod() {
		System.out.println("..... customAnnotationDemoMethod called ... ");
	}
}