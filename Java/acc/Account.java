package acc;

public class Account {

	  private double balance;
	  private String name;
	  private int accountNumber;

	  
	  public Account() {
	    this.balance = 5000;
	    this.name = "pratik";
	    this.accountNumber = 0;
	  }

	  
	  public Account(double balance, String name, int accountNumber) {
	    this.balance = balance;
	    this.name = name;
	    this.accountNumber = accountNumber;
	  }

	 
	  public void setBalance(double balance) {
	    this.balance = balance;
	  }

	  public double getBalance() {
	    return balance;
	  }

	  public String getName() {
	    return name;
	  }

	  public int getAccountNumber() {
	    return accountNumber;
	  }
	}
