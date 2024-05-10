package vehicleRentalSystem;

public class Bikes {
	Rentable rentable = new Rentable() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("display bike details");
		}
		
		@Override
		public void calculateRent() {
			// TODO Auto-generated method stub
			System.out.println("calculaterent of bike");
		}
	};
	public void display() {
		rentable.displayDetails();
		rentable.calculateRent();
	}
}
