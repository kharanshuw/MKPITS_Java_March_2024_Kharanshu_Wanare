package myproject;

public class Area {
	public void areaOfSquare(int size) {
		System.out.println("area of square is "+size*size);
	}
	
	public void areaOfRectangle(int length,int width) {
		int result=length*width;
		System.out.println("area of rectangle is "+result);
	}
	
	public void areaOfCircle(double radius) {
		double result=2.14*radius;
		System.out.println("area of rectangle is "+result);
	}
	
	public void areaOfTriangle(double base,double height) {
		double result=(base*height)/2;
		System.out.println("area of rectangle is "+result);
	}
	
}


package myproject;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Area area = new Area();
		int key;
		System.out.println("enter choice 1.areaOfSquare 2.areaOfRectangle  3.areaOfCircle  4.areaOfTriangle");
		key = scanner.nextInt();
		switch (key) {
		case 1: {
			System.out.println("enter size");
			int size=scanner.nextInt();
			area.areaOfSquare(size);
			break;
		}
		case 2:{
			System.out.println("enter length");
			int length=scanner.nextInt();
			System.out.println("enter width");
			int width=scanner.nextInt();
			area.areaOfRectangle(length, width);
			break;
		}
		case 3:
		{
			System.out.println("enter radius");
			double radius=scanner.nextDouble();
			area.areaOfCircle(radius);
			break;
		}
		case 4:
		{
			System.out.println("enter base");
			double base=scanner.nextDouble();
			System.out.println("enter height");
			double height=scanner.nextDouble();
			area.areaOfTriangle(base, height);
			break;
		}
	}

}
}