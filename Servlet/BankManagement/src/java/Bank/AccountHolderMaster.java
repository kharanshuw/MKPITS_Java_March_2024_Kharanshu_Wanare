package Bank;

public class AccountHolderMaster {

    private int userid;
    private String emailString;
    private String passwordString;
    private String name;
    private String address;
    private String city;
    private String phone_number;
    private double balance;

    public AccountHolderMaster() {
    }

    public AccountHolderMaster(int userid, String emailString, String passwordString, String name, String address, String city, String phone_number, double balance) {
	this.userid = userid;
	this.emailString = emailString;
	this.passwordString = passwordString;
	this.name = name;
	this.address = address;
	this.city = city;
	this.phone_number = phone_number;
	this.balance = balance;
    }

    public int getUserid() {
	return userid;
    }

    public void setUserid(int userid) {
	this.userid = userid;
    }

    public String getEmailString() {
	return emailString;
    }

    public void setEmailString(String emailString) {
	this.emailString = emailString;
    }

    public String getPasswordString() {
	return passwordString;
    }

    public void setPasswordString(String passwordString) {
	this.passwordString = passwordString;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getPhone_number() {
	return phone_number;
    }

    public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
    }

    public double getBalance() {
	return balance;
    }

    public void setBalance(double balance) {
	this.balance = balance;
    }

}
