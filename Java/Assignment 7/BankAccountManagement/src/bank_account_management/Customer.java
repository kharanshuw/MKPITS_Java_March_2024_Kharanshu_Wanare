package bank_account_management;

public class Customer {
	String nameString;
	String addressString;
	String emailString;
	String ph_number;
	Account account;
	public Customer(String nameString, String addressString, String emailString, String ph_number, Account account) {
		super();
		this.nameString = nameString;
		this.addressString = addressString;
		this.emailString = emailString;
		this.ph_number = ph_number;
		this.account = account;
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
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPh_number() {
		return ph_number;
	}
	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void openAccount() {
		
	}
	
	public void closeAccount() {
		
	}
}
