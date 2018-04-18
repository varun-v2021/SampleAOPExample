package com.spring.tutorial.service;

import java.util.List;

import com.spring.tutorial.model.EmployeeDTO;

public interface EmployeeManager {
	public EmployeeDTO getEmployeeById(Integer employeeId);

	public List<EmployeeDTO> getAllEmployee();

	public void createEmployee(EmployeeDTO employee);

	public void deleteEmployee(Integer employeeId);

	public void updateEmployee(EmployeeDTO employee);
	
	public String addEmployeeReturnValue();
	
	public void addEmployeeAround(String name);
	
	public String simpleEmployeeGetter();
	
	public void customAnnotationDemoMethod();
	
}