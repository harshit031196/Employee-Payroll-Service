package com.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	private List<EmployeePayrollData> employeePayrollList;
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	public EmployeePayrollService() {
		this.employeePayrollList = new ArrayList<>();
	}

	public List<EmployeePayrollData> getEmployeePayRollList() {
		return employeePayrollList;
	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}
	
	public static void main(String args[]) {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}

	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		Double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
	
	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService == IOService.CONSOLE_IO)
			System.out.println("Employee Payroll Roaster\n" + employeePayrollList);
		else if (ioService == IOService.FILE_IO) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}
	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().printData();
		}
	}
	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}
	public List<EmployeePayrollData> readData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			return new EmployeePayrollFileIOService().readData();
		}
		return null;
	}
}