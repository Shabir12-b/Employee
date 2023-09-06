package com.employee.globalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.customException.SalaryLowException;

@RestControllerAdvice
public class GlobalHandling {
	
    @ExceptionHandler(SalaryLowException.class)
	public ResponseEntity<Object> SalaryHandler() {
		return new ResponseEntity<Object>("Salary is Low", HttpStatus.BAD_REQUEST);
	}
	

}
