package bank_account_management;

public class Account {
	String typeString;
	long accountno;
	long totalbalance;
	Customer customer;

	public Account(String typeString, long accountno, long totalbalance, Customer customer) {
		super();
		this.typeString = typeString;
		this.accountno = accountno;
		this.totalbalance = totalbalance;
		this.customer = customer;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public long getTotalbalance() {
		return totalbalance;
	}

	public void setTotalbalance(long totalbalance) {
		this.totalbalance = totalbalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void deposit() {
		
	}
	
	public void withdraw() {
		
	}
}
