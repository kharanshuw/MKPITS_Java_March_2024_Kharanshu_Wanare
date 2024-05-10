package employeeManagementSystem;

public class PartTime {
	Employee employee = new Employee() {
		
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
	
	public void display() {
		employee.displayDetails();
		employee.calSalary();
	}
}
