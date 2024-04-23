package library_management_system;

public class Members {
	String nameString;
	int id;
	long contactInformation;
	String checkoutString;
	String checkinString;
	
	public Members(String nameString, int id, long contactInformation, String checkoutString, String checkinString) {
		super();
		this.nameString = nameString;
		this.id = id;
		this.contactInformation = contactInformation;
		this.checkoutString = checkoutString;
		this.checkinString = checkinString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(long contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getCheckoutString() {
		return checkoutString;
	}
	public void setCheckoutString(String checkoutString) {
		this.checkoutString = checkoutString;
	}
	public String getCheckinString() {
		return checkinString;
	}
	public void setCheckinString(String checkinString) {
		this.checkinString = checkinString;
	}
	
	
}
