package com.employee.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.customException.SalaryLowException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeSerive {
	public static Logger log = Logger.getLogger(EmployeeSerive.class);
	@Autowired
	EmployeeDao ed;

	public String setAllEmployee(List<Employee> e) throws SalaryLowException{
		List<Employee> c = e.stream().filter(x->x.getSalary()>75000).toList();
		if(c.isEmpty()) {
		throw new SalaryLowException("Salary is Low");
	}
		else {
			return ed.setAllEmployee(c);
		}

}

	public List<Employee> getAllEmployee() {
		PropertyConfigurator.configure("Login.Pro");
		log.info(ed.getAllEmployee());
		return ed.getAllEmployee();
	}
}