package com.winner.spsec.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winner.spsec.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

}
