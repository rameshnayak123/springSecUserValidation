package com.winner.spsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winner.spsec.entity.Employee;
import com.winner.spsec.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService eservice;
	
	
	
	@GetMapping(produces="application/json")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<Employee>> getAllemployee()
	{
		return new ResponseEntity<List<Employee>>(eservice.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping(value="/id/{employeeId}",produces="application/json")
	public ResponseEntity<Employee> getAllemployeeById(@PathVariable int employeeId)
	{
		
		Employee e = eservice.getemployeeId(employeeId);
		if(e!=null) return new ResponseEntity<Employee>(e,HttpStatus.OK);
		return new ResponseEntity<Employee>(e,HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping(consumes="application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public HttpStatus addEmployee(@RequestBody Employee e)
	{
		
		if(eservice.saveEmployee(e)) return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	
	@PutMapping(consumes="application/json")
	public HttpStatus updateEmployee(@RequestBody Employee e)
	{
		if(eservice.saveEmployee(e)) return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	
	

	

}
