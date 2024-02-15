package edu.ucalgary.oop;

public class Employee {
	private String name;
	private final String IDNUMBER;
	private String managerID;
	private Employee[] supervisedEmployees;
	
	public Employee(String name, String idNumber) {
		this.name = name;
		this.IDNUMBER = idNumber;
	}
	
	public Employee(String name, String idNumber, String managerID) {
		this.name = name;
		this.IDNUMBER = idNumber;
		this.managerID = managerID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIDNumber() {
		return IDNUMBER;
	}
	
	public String getManagerID() {
		return managerID;
	}
	
	public void setManagerID(String newManager) {
		this.managerID = newManager;
	}
	
	public void addEmployee(Employee newEmployee) {	
		int currentEmployees;
		if(supervisedEmployees == null) {
			currentEmployees = 0;
		}
		else {
			currentEmployees = supervisedEmployees.length;
		}
		Employee[] addEmployee = new Employee[currentEmployees + 1];
		for(int i = 0; i < currentEmployees; i++){
			addEmployee[i] = supervisedEmployees[i];
		}
		addEmployee[currentEmployees] = newEmployee;
		supervisedEmployees = addEmployee;
	}
	
	public Employee[] getEmployees() {
		return supervisedEmployees;
	}
}