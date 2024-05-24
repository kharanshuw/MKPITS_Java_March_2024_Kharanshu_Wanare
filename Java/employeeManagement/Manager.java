package employeeManagement;

public class Manager extends Employee {
	String departmentString;

	public Manager(String nameString, double salary, String birthdateString, String departmentString) {
		super(nameString, salary, birthdateString);
		this.departmentString = departmentString;
	}
	
	

	public Manager(String nameString, double salary, String birthdateString) {
		super(nameString, salary, birthdateString);
		
	}



	public Manager() {
		super();
		
	}

	public String getDepartmentString() {
		return departmentString;
	}

	public void setDepartmentString(String departmentString) {
		this.departmentString = departmentString;
	}

	
	
	
}
