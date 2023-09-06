package com.employee.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;


@Repository
public class EmployeeDao {
	public static Logger log = Logger.getLogger(EmployeeDao.class);
	@Autowired
	EmployeeRepository er;

	public String setAllEmployee(List<Employee> e) {
		 er.saveAll(e);
		 return "SUCCESS";
	}

	public List<Employee> getAllEmployee() {
		PropertyConfigurator.configure("Login.Pro");
		log.info(er.findAll());
		return er.findAll();
	}
	
	

}
