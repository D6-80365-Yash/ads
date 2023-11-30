package com.sunbeam;

public class Employee {
	int empid;
	String name;
	int salary;
	
	
	public Employee() {
	}


	public Employee(int empid, String name, int salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [ empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}
}
