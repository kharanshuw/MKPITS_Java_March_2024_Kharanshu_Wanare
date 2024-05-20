package banking_system;

public class Current {
Account account = new Account() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("current account details");
		}
		
		@Override
		public void calculateInterest() {
			// TODO Auto-generated method stub
			System.out.println("current saving account");
		}
	};
	public void display() {
		account.displayDetails();
		account.calculateInterest();
	}
}
