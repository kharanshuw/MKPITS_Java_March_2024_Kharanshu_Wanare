package polymorphism;

public class C extends B {
	int c;

	public C(int b, int c) {
		super(b);
		this.c = c;
		System.out.println("constructor c"+c);
	}
	
	
}
