package com.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {

	public static String PAYROLL_FILE = "payroll-file.txt";
	
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		 StringBuffer empBuffer = new StringBuffer();
		 employeePayrollList.forEach(employee -> {
			 String employeeDataString = employee.toString().concat("\n");
			 empBuffer.append(employeeDataString);
		 });
		 
		 try {
			 Files.write(Paths.get(PAYROLL_FILE),empBuffer.toString().getBytes());
		 }
		 catch(IOException x) {
			 x.printStackTrace();
		 }
	}

	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE).toPath()).forEach(System.out::println);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE).toPath()).count();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return entries;
		
	}
	public List<EmployeePayrollData> readData() {
		List<EmployeePayrollData> returnList = new ArrayList<>();
		try {
			Files.lines(new File(PAYROLL_FILE).toPath()).map(line -> line.trim()).forEach(line -> {
				int check = 1;
				int id = 0;
				double salary = 0;
				String name = "";
				String data = line.toString();
				String dataList[] = data.split(",");
				for (String string : dataList) {
					if (check == 1) {
						id = Integer.parseInt(string.replaceAll("id =", ""));
						check++;
						continue;
					}
					if(check==2) {
						name = string.replaceAll("name =", "");
						check++;
						continue;
					}
					if(check==3) {
						salary = Double.parseDouble(string.replaceAll("salary =", ""));
						break;
					}
				}
				returnList.add(new EmployeePayrollData(id, name, salary));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnList;
	}
	
}
