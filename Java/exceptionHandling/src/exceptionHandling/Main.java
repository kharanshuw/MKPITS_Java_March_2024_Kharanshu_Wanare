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
