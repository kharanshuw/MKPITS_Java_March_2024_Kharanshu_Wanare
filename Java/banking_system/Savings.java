package banking_system;

public class Savings {
	Account account = new Account() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("saving account details");
		}
		
		@Override
		public void calculateInterest() {
			// TODO Auto-generated method stub
			System.out.println("calculating saving account");
		}
	};
	public void display() {
		account.displayDetails();
		account.calculateInterest();
	}
}
