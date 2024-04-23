package student_management_system;

public class Instructor {

	String inameString;
	String idepartmentString;
	String officehourString;
	public Instructor(String inameString, String idepartmentString, String officehourString) {
		super();
		this.inameString = inameString;
		this.idepartmentString = idepartmentString;
		this.officehourString = officehourString;
	}
	public String getInameString() {
		return inameString;
	}
	public void setInameString(String inameString) {
		this.inameString = inameString;
	}
	public String getIdepartmentString() {
		return idepartmentString;
	}
	public void setIdepartmentString(String idepartmentString) {
		this.idepartmentString = idepartmentString;
	}
	public String getOfficehourString() {
		return officehourString;
	}
	public void setOfficehourString(String officehourString) {
		this.officehourString = officehourString;
	}

	
}
