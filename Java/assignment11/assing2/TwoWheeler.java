package assignment11.assing2;

public class TwoWheeler extends Car implements MotorBike,Cycle{
	public void speed() {
		System.out.println("speed of moterbike 90km/hr");
	}

	@Override
	public void distance() {
		// TODO Auto-generated method stub
		System.out.println("50 meter of Cycle");
	}
	
	public void display() {
		super.display();
	}
}
