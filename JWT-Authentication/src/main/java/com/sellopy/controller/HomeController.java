package com.sellopy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellopy.model.Employee;
import com.sellopy.service.EmployeeService;

@RestController
//@RequestMapping("/welcome")
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployeeList() {
		
		return employeeService.getEmployeeList();
	}
}
