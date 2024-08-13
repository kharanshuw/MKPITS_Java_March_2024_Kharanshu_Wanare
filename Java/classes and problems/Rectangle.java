package methods;

public class Rectangle extends Shape {

	double base;
	double height;
	
	
	@Override
	public void calArea() {
		// TODO Auto-generated method stub
		
		System.out.println("area of rectangle"+(base*height));
		
	}

	@Override
	public void perimeterCal() {
		// TODO Auto-generated method stub
		
		System.out.println("perimeter of rectangle"+(base+height)*2);
	}

}
