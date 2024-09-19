package springproject8;


public class Student {

	String nameString;

	String cityString;


	Address address;
	
	Address address2;
	
	

	public Address getAddress2() {
		return address2;
	}

	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

	public Student(String nameString, String cityString, Address address, Address address2) {
		super();
		this.nameString = nameString;
		this.cityString = cityString;
		this.address = address;
		this.address2 = address2;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + ", address=" + address
				+ ", address2=" + address2 + "]";
	}

	public Student(String nameString, String cityString, Address address) {
		super();
		this.nameString = nameString;
		this.cityString = cityString;
		this.address = address;
	}
	
	
	
	
}
