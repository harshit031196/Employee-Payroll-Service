package com.payroll;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import com.payroll.EmployeePayrollService.IOService;



public class EmployeePayrollServiceTest {

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayofEmps = {
			new EmployeePayrollData(1,"Jeff Bezos",100000.0),
			new EmployeePayrollData(2,"Bill Gates",200000.0),
			new EmployeePayrollData(3,"Mark Z",300000.0)
		};
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayofEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long numberOfEntries = employeePayrollService.countEntries(IOService.FILE_IO);
		assertEquals(3,numberOfEntries);
	}

}
