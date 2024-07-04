package functioninterface;

public class Demo {
	public static void main(String[] args) {
//		Circle circle=new Circle();
//		circle.display();
		
		Shape shape = new Shape() {
			
			@Override
			public void perimeterCal() {
				System.out.println("perimiter");
				
			}
			
			@Override
			public void calArea() {
				// TODO Auto-generated method stub
				System.out.println("calarea");
			}
		};
		shape.calArea();
		shape.perimeterCal();
	}
}
