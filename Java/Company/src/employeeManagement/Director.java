package employeeManagement;

public class Director extends Manager {
	double carallowance;
	
	
	
	public Director() {
		super();
		
	}
	
	public Director(String nameString, double salary, String birthdateString, String departmentString,
			double carallowance) {
		super(nameString, salary, birthdateString, departmentString);
		this.carallowance = carallowance;
	}

	


	public void increaseAllowance() {
		
	}
}
