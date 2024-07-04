package functioninterface;

public class Circle {
	
	
	public void display() {
		Shape shape = new Shape() {
			
			@Override
			public void perimeterCal() {
				// TODO Auto-generated method stub
				System.out.println("paramiter");
				
			}
			
			@Override
			public void calArea() {
				// TODO Auto-generated method stub
				System.out.println("area");
			}
		};
		shape.perimeterCal();
		shape.calArea();
	}
	
}
