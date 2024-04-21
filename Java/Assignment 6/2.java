package methods;

public class TemparatureConverter {
	public void celciusTofahrenhit(double no) {
		double result=(no*(9/5))+32;
		System.err.println(no+"celcius to fahrenhit is "+result);
	}
	
	public void fahrenhitTocelcius(double no) {
		double result=(no-32)*(5/9);
		System.err.println(no+"fahrenhit to celcius"+result);
	}
}

import java.util.Scanner;

import javax.xml.crypto.Data;

import methods.*;

public class Main {
	public static void main(String[] args)
	{
		TemparatureConverter temparatureConverter=new TemparatureConverter();
		
		boolean x=true;
		double degree;
		Scanner scanner=new Scanner(System.in);
		int choice;		
		while (x==true) {
			System.err.println("enter temperature ");
			degree=scanner.nextInt();
			System.out.println("enter choice 1.celcius to fahrenheit  2.fahrenheit to celcius 3.exit");
			choice=scanner.nextInt();
			switch (choice){
			case 1: {
				temparatureConverter.celciusTofahrenhit(degree);
				break;
			}
			case 2: {
				temparatureConverter.fahrenhitTocelcius(degree);
				break;
			}
			case 3: {
				x=false;
				break;
			}
		}
	}
}
}