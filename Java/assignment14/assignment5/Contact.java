package contactListApplication;

public class Contact {
	long contactid;
	String nameString;
	long phoneno;
	String emailString;

	public Contact(long contactid, String nameString, long phoneno, String emailString) {
		super();
		this.contactid = contactid;
		this.nameString = nameString;
		this.phoneno = phoneno;
		this.emailString = emailString;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getContactid() {
		return contactid;
	}

	public void setContactid(long contactid) {
		this.contactid = contactid;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	@Override
	public String toString() {
		return "Contact [contactid=" + contactid + ", nameString=" + nameString + ", phoneno=" + phoneno
				+ ", emailString=" + emailString + "]";
	}
	
	
}
