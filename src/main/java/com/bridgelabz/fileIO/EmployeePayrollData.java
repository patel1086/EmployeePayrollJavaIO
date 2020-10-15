package com.bridgelabz.fileIO;

public class EmployeePayrollData {
	public int ID;
	public String Name;
	public double salary;

	public EmployeePayrollData(int ID, String Name, double salary) {
		this.ID = ID;
		this.Name = Name;
		this.salary = salary;
	}

	public String toString() {
		return "id= " + ID + ", name= " + Name + ",salary " + salary;
	}
}
