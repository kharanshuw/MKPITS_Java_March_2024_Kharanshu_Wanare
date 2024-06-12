package jdbctest;

public class Student {
	private String rollnoString;
	String nameString;
	String addressString;
	String cityString;
	public Student(String rollnoString, String nameString, String addressString, String cityString) {
		super();
		this.rollnoString = rollnoString;
		this.nameString = nameString;
		this.addressString = addressString;
		this.cityString = cityString;
	}
	public String getRollnoString() {
		return rollnoString;
	}
	public void setRollnoString(String rollnoString) {
		this.rollnoString = rollnoString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public String getCityString() {
		return cityString;
	}
	public void setCityString(String cityString) {
		this.cityString = cityString;
	}
	@Override
	public String toString() {
		return "Student [rollnoString=" + rollnoString + ", nameString=" + nameString + ", addressString="
				+ addressString + ", cityString=" + cityString + "]";
	}
	
	
}
