package myownexception;

public class WithdrawlException extends Exception {
	
	double amount;
	public WithdrawlException(double amount) {
		this.amount=amount;
	}
	
	@Override
	public String getMessage() {
		return ("your amount is greater than account balance +"+amount);
	}
}
