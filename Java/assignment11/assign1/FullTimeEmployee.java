package assignment11;

public class FullTimeEmployee extends Employee {

	private double workinghours;

	public FullTimeEmployee(String nameString, double paymentperhour, double workinghours) {
		super(nameString, paymentperhour);
		this.workinghours = workinghours;
	}

	public FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String nameString, double paymentperhour) {
		super(nameString, paymentperhour);
		// TODO Auto-generated constructor stub
	}

	public double getWorkinghours() {
		return workinghours;
	}

	public void setWorkinghours(double workinghours) {
		this.workinghours = workinghours;
	}

	@Override
	public double calsalary1() {
		double result = super.getPaymentperhour() * workinghours;
		return result;
	}

}
