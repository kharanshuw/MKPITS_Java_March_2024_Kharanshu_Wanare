package banking_system;

public class Demo {
public static void main(String[] args) {
	Account current = new Account() {
		
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
	
	Account saving = new Account() {
		
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
}
}
