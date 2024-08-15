package myinterfaces;

public class Addition implements Calculation {

	
	int a; int b;
	
	
	
	public Addition() {
		super();
	}



	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public void calArea() {
		System.out.println("addition is"+(a+b));
		
	}
	
}
