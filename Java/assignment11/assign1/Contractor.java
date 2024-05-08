package assignment11;

public class Contractor extends Employee {

	private double workinghours;

	public Contractor(String nameString, double paymentperhour, double workinghours) {
		super(nameString, paymentperhour);
		this.workinghours = workinghours;
	}

	public Contractor() {
		super();
		
	}

	public Contractor(String nameString, double paymentperhour) {
		super(nameString, paymentperhour);
		
	}

	@Override
	public double calsalary1() {
		double result = super.getPaymentperhour() * workinghours;
		return result;
	}

}
