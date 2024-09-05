package model;

public class User {

    private int id;
    private String nameString;
    private String emailString;
    private String countryString;

    public User(int id, String nameString, String emailString, String countryString) {
	this.id = id;
	this.nameString = nameString;
	this.emailString = emailString;
	this.countryString = countryString;
    }

    public User(String nameString, String emailString, String countryString) {
	this.nameString = nameString;
	this.emailString = emailString;
	this.countryString = countryString;
    }

    public User() {
	super();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public String getCountryString() {
	return countryString;
    }

    public void setCountryString(String countryString) {
	this.countryString = countryString;
    }

}
