package assignment11;

public abstract class Employee {
	private String nameString;
	private double paymentperhour;

	public abstract double calsalary1();

	public Employee(String nameString, double paymentperhour) {
		super();
		this.nameString = nameString;
		this.paymentperhour = paymentperhour;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public double getPaymentperhour() {
		return paymentperhour;
	}

	public void setPaymentperhour(double paymentperhour) {
		this.paymentperhour = paymentperhour;
	}

}
