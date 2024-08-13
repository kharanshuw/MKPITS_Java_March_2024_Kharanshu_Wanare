package methods;

public class Circle extends Shape{

	int a;
	
	
	
	public Circle(int a) {
		super();
		this.a = a;
	}

	public Circle() {
		super();

	}

	@Override
	public void calArea() {
		System.out.println("area of circle is "+(3.14*a*a));		
	}

	@Override
	public void perimeterCal() {
			double result=2*3.14*a;
			System.out.println(result);
	}

}
