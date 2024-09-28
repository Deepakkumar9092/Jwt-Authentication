package com.sellopy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sellopy.model.Employee;

@Service
public class EmployeeService {
	
	private List<Employee>empList = new ArrayList<>();

	public EmployeeService() {
		empList.add(new Employee(UUID.randomUUID().toString(),"Deepak", "deepakjp9092@gmail.com"));
		
		empList.add(new Employee(UUID.randomUUID().toString(), "Vanisha", "vanisha90@gmail.com"));
	}
	
	public List<Employee>getEmployeeList(){
		return empList;
	}
}
