package com.payroll;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
	private static ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public EmployeePayrollService() {
	}
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService.readEmployeePayrollData();
		EmployeePayrollService.writeEmployeePayrollData();
	}
	public static void readEmployeePayrollData() {
		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = sc.next();
		System.out.println("Enter Employee salary: ");
		double salary = sc.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id,name,salary));
	}
	private static void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roaster to console\n" + employeePayrollList);	
	}

}
