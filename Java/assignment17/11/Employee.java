package practise;

public class Employee {
	String idString;
	String nameString;
	String departmentString;
	public Employee(String idString, String nameString, String departmentString) {
		super();
		this.idString = idString;
		this.nameString = nameString;
		this.departmentString = departmentString;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean containsKey(String idString2) {
		
		if (idString2.equals(this.idString)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Employee [idString=" + idString + ", nameString=" + nameString + ", departmentString="
				+ departmentString + "]";
	}
	
	
	
	
}
