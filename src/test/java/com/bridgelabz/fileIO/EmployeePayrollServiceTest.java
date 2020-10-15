package com.bridgelabz.fileIO;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeesWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayofEmps = { new EmployeePayrollData(1, "Jeff Bezoz", 10000.00),
				new EmployeePayrollData(2, "Mark Zuckerburg", 15300.00),
				new EmployeePayrollData(3, "David Melan", 9876.00) };
		ArrayList<EmployeePayrollData> arraylist = new ArrayList<>();
		arraylist.add(arrayofEmps[0]);
		arraylist.add(arrayofEmps[1]);
		arraylist.add(arrayofEmps[2]);
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(arraylist);
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}

	@Test
	public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
		EmployeePayrollData[] arrayofEmps = { new EmployeePayrollData(1, "Jeff Bezoz", 10000.00),
				new EmployeePayrollData(2, "Mark Zuckerburg", 15300.00),
				new EmployeePayrollData(3, "David Melan", 9876.00) };
		ArrayList<EmployeePayrollData> arraylist = new ArrayList<>();
		arraylist.add(arrayofEmps[0]);
		arraylist.add(arrayofEmps[1]);
		arraylist.add(arrayofEmps[2]);
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(arraylist);
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.readData(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}

}
