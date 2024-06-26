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


package exceptionHandling;

import myownexception.InvalidAgeException;
import myownexception.WithdrawlException;

public class Main {

	public static void main(String[] args) {
		Withdrawl withdrawl = new Withdrawl(0);
		withdrawl.deposit(900);
		try {
			withdrawl.withdrawl(1000);
		} catch (WithdrawlException e) {

			e.printStackTrace();
		}
	}

}
