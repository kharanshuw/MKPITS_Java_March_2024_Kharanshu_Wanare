package vehicleRentalSystem;

public class Demo {
	public static void main(String[] args) {
		Rentable details = new Rentable() {
		
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
	
	Rentable bike = new Rentable() {
		
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
	
	Rentable car = new Rentable() {
		
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
	}
}
