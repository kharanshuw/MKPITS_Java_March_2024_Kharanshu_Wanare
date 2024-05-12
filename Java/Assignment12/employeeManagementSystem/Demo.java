
public class Demo {
public static void main(String[] args) {
	
	Employee part_time = new Employee() {
		
		@Override
		public void displayDetails() {
			System.out.println("part time employee details");
		}
		
		@Override
		public void calSalary() {
			// TODO Auto-generated method stub
			System.out.println("part time employee salary");
		}
	};
	
	Employee full_time = new Employee() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("fulltime deails salary");
		}
		
		@Override
		public void calSalary() {
			// TODO Auto-generated method stub
			System.out.println("fulltime calsalary");
		}
	};
	
	Employee contract_based = new Employee() {

		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("display details");
		}

		@Override
		public void calSalary() {
			// TODO Auto-generated method stub
			System.out.println("calculate salary");
		}
	};
}
}