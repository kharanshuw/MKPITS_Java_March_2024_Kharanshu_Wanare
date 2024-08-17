package reflextion;

public class Student {
	private String nameString;
	private String idString;
	private String gpaString;
	private String rollnoString;
	
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
	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", idString=" + idString + ", gpaString=" + gpaString
				+ ", rollnoString=" + rollnoString + "]";
	}
	
	
}
