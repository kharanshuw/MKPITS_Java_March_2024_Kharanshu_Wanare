package myinterfaces;

public class Division implements Calculation{
	int a;
	int b;
	public Division(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public Division() {
		super();
	}
	@Override
	public void calArea() {
		System.out.println("division "+(a/b));		
	}
	
}
