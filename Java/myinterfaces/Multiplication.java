package myinterfaces;

import upcasting.Calculation;

public class Multiplication extends Calculation{
	int a;
	int b;
	public Multiplication() {
		super();
	}
	public Multiplication(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public void calArea() {
		System.out.println("multiplication is "+(a*b));
	}
	
	
}
