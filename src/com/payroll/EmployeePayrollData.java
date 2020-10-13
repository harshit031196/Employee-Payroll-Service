package com.payroll;

public class EmployeePayrollData {
	private int id;
	private String name;
	private double salary;
	public EmployeePayrollData(int id, String name, double salary) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
	public String toString() {
		return "id=" +id + " , name="+name+ ", salary="+salary;
	}
}
