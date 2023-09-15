package com.winner.spsec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winner.spsec.entity.Employee;
import com.winner.spsec.respository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional(readOnly=true)
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Employee getemployeeId(int employeeId)
	{
		Optional<Employee> oe = employeeRepository.findById(employeeId);
		
		if(oe.isPresent()) return oe.get();
		return null;
 	}
	
	@Transactional
	public boolean saveEmployee(Employee e)
	{
		return employeeRepository.save(e) !=null;
	}
	
	@Transactional
	public boolean deleteEmployeeById(int employeeId)
	{
		long count = employeeRepository.count();
		employeeRepository.deleteById(employeeId);
		if(count>employeeRepository.count())
			return true;
		return false;
	}

}
