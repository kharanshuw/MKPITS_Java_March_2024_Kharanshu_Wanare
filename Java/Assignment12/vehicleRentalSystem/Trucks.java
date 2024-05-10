package vehicleRentalSystem;

public class Trucks {
Rentable rentable = new Rentable() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("display truck details");
		}
		
		@Override
		public void calculateRent() {
			// TODO Auto-generated method stub
			System.out.println("calculaterent of truck");
		}
	};
	
	public void display() {
		rentable.displayDetails();
		rentable.calculateRent();
	}
}
