package com.bridgelabz.fileIO;

import java.util.*;
import java.io.IOException;
import java.lang.NullPointerException;
import java.nio.file.Files;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	public ArrayList<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
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
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(EmployeePayrollService.IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		else if (ioService.equals(EmployeePayrollService.IOService.FILE_IO)) {
			new EmployeePayrollFileService().writeData(employeePayrollList);
		}
	}

	public long readData(IOService ioService) {
		if (ioService.equals(EmployeePayrollService.IOService.FILE_IO))
			return new EmployeePayrollFileService().readData(employeePayrollList);
		return 0;

	}

	public void printData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileService().printData();
	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(EmployeePayrollService.IOService.FILE_IO))
			return new EmployeePayrollFileService().countEntries();
		return 0;
	}
}
