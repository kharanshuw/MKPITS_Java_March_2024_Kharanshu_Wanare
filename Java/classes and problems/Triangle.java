package methods;

public class Triangle extends Shape {

	double base;
	double height;
	
	int a,b,c;
	
	
	
	public Triangle(double base, double height, int a, int b, int c) {
		super();
		this.base = base;
		this.height = height;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calArea() {
		// TODO Auto-generated method stub
		double result=(1/2)*base*height;
		System.out.println("area of triangle"+result);
		
	}

	@Override
	public void perimeterCal() {
		// TODO Auto-generated method stub
		double result=a+b+c;
		System.out.println(result);
		
	}

}
