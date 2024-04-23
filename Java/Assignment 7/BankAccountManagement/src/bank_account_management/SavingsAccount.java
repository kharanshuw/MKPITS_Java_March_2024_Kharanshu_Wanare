package bank_account_management;

public class SavingsAccount {
	long accountno;
	long totalbalance;
	Customer customer;
	double minimumbalance;

	public SavingsAccount(long accountno, long totalbalance, Customer customer,double minimumbalance) {
		super();
		this.accountno = accountno;
		this.totalbalance = totalbalance;
		this.customer = customer;
		this.minimumbalance=minimumbalance;
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
	
	
	public double getMinimumbalance() {
		return minimumbalance;
	}

	public void setMinimumbalance(double minimumbalance) {
		this.minimumbalance = minimumbalance;
	}

	public void calculateInterest() {

	}

	public void deposit() {

	}

	public void withdraw() {

	}
	
	public void overdraftProtection() {
		
	}
}
