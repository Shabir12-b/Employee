package com.employee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customException.SalaryLowException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeSerive;


@RestController
public class EmployeeController {
	public static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeSerive es;
	
	@PostMapping(value="/setAllEmp")
	public String setAllEmployee(@RequestBody List<Employee> e )throws SalaryLowException {
		return es.setAllEmployee(e);
	}
	
	@GetMapping(value="/getAllEmp")
	public List<Employee> getAllEmployee(){
		PropertyConfigurator.configure("Login.Pro");
		log.info(es.getAllEmployee());
	  return es.getAllEmployee();
	}

}
