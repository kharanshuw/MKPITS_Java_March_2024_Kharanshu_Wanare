 package polymorphism;

public class B extends A{

	int b;
	
	public B(int b) {
		super(5);
		this.b = b;
		System.out.println("constructor b"+b);
	}
	
	
}
