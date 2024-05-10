package vehicleRentalSystem;

public class Cars {
	Rentable rentable = new Rentable() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("display car details");
		}
		
		@Override
		public void calculateRent() {
			// TODO Auto-generated method stub
			System.out.println("calculaterent of car");
		}
	};
	
	public void display() {
		rentable.displayDetails();
		rentable.calculateRent();
	}
}
