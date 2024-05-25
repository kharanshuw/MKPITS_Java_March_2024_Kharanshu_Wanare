package exceptionHandling;

import myownexception.WithdrawlException;

public class Withdrawl {
	private double balance;

	public Withdrawl(double balance) {
		super();
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance=balance+amount;
	}	
	
	public void withdrawl (double amount) throws WithdrawlException {
		if (amount>balance) {
			Double moreDouble=amount-balance;
			System.out.println("you are asking more by"+moreDouble);
			WithdrawlException withdrawl=new WithdrawlException(amount);
			throw withdrawl;
		}
		else {
			balance=balance-amount;
			System.out.println("amount withdrwn");
			System.out.println("balance updated");
		}
	}
}
