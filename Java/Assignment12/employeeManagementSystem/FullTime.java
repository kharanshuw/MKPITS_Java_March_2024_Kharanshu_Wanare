package employeeManagementSystem;

public class FullTime {
	
	Employee employee = new Employee() {
		
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
	
	public void display() {
		employee.calSalary();
		employee.displayDetails();
	}
}
