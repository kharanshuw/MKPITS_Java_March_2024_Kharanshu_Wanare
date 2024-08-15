package myinterfaces;

public class Subtraction implements Calculation{
	int a;
	int b;
	public Subtraction(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public Subtraction() {
		super();
		
	}
	@Override
	public void calArea() {
		System.out.println("subtraction is"+(a-b));
		
	}
	
	
}
