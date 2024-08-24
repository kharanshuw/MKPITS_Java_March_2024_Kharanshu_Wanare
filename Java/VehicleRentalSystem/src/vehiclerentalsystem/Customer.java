package vehiclerentalsystem;

public class Customer {
	private String nameString;
	private String licenseString;
	private String phonenoString;
	
	public Customer(String nameString, String licenseString, String phonenoString) {
		super();
		this.nameString = nameString;
		this.licenseString = licenseString;
		this.phonenoString = phonenoString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getLicenseString() {
		return licenseString;
	}
	public void setLicenseString(String licenseString) {
		this.licenseString = licenseString;
	}
	public String getPhonenoString() {
		return phonenoString;
	}
	public void setPhonenoString(String phonenoString) {
		this.phonenoString = phonenoString;
	}
	
	public void showRentalDetails()
	{
		
	}
	
}
