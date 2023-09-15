package com.winner.spsec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="empid")
	private int empId;
	
	@Column(name="ename")
	private String employeeName;
	
	private double salary;
	
	private int deptno;
	
	public Employee() {}

	public Employee(int empId, String employeeName, double salary, int deptno) 
	{
		this.empId = empId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.deptno = deptno;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	};
	
	
	
	

}
