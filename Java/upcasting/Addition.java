package upcasting;

public class Addition extends Calculation {

	private int a;
	private int b;

	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public Addition() {
		super();
		}


	@Override
	public void calArea() {
		System.out.println("addition");
		System.out.println(a+b);
	}

}
