package bank_account_management;

public class CheckingAccount {
	long accountno;
	long totalbalance;
	double minimumbalance;
	
	

	public CheckingAccount(long accountno, long totalbalance, double minimumbalance) {
		super();
		this.accountno = accountno;
		this.totalbalance = totalbalance;
		this.minimumbalance = minimumbalance;
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



	public double getMinimumbalance() {
		return minimumbalance;
	}



	public void setMinimumbalance(double minimumbalance) {
		this.minimumbalance = minimumbalance;
	}



	public void overdraftProtection() {
		
	}
	
	public void calculateInterest() {

	}
}
