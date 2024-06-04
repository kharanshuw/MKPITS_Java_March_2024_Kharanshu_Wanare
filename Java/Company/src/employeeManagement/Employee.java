package employeeManagement;

public class Employee {
	String nameString;
	double salary;
	String birthdateString;
	public Employee(String nameString, double salary, String birthdateString) {
		super();
		this.nameString = nameString;
		this.salary = salary;
		this.birthdateString = birthdateString;
	}
	public Employee() {
		super();
		
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBirthdateString() {
		return birthdateString;
	}
	public void setBirthdateString(String birthdateString) {
		this.birthdateString = birthdateString;
	}
	
	public String getDetails() {
		return null;
	}
}
