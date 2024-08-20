package student_management_system;

public class Student {
	String nameString;
	String idString;
	String gpaString;
	String rollnoString;
	public Student(String nameString, String idString, String gpaString, String rollnoString) {
		super();
		this.nameString = nameString;
		this.idString = idString;
		this.gpaString = gpaString;
		this.rollnoString = rollnoString;
	}
	public String getNameString() {
		return nameString;
	}
	public String getGpaString() {
		return gpaString;
	}
	public String getidString()
	{
		return idString;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getRollnoString() {
		return rollnoString;
	}
	public void setRollnoString(String rollnoString) {
		this.rollnoString = rollnoString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public void setGpaString(String gpaString) {
		this.gpaString = gpaString;
	}
}
