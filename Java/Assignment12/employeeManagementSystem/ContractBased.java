package employeeManagementSystem;

public class ContractBased {
	Employee employee = new Employee() {

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

	public void display() {
		employee.displayDetails();
		employee.calSalary();
	}
}

