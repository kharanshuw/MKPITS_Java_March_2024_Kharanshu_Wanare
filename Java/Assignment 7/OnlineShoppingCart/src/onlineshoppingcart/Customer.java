package onlineshoppingcart;

public class Customer {
	private String nameString;
	private String emailString;
	private long contactno;
	private String addressString;
	
	public Customer(String nameString, String emailString, long contactno, String addressString) {
		super();
		this.nameString = nameString;
		this.emailString = emailString;
		this.contactno = contactno;
		this.addressString = addressString;
	}


	public String getNameString() {
		return nameString;
	}


	public void setNameString(String nameString) {
		this.nameString = nameString;
	}


	public String getEmailString() {
		return emailString;
	}


	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}


	public long getContactno() {
		return contactno;
	}


	public void setContactno(long contactno) {
		this.contactno = contactno;
	}


	public String getAddressString() {
		return addressString;
	}


	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	
	
	
}
