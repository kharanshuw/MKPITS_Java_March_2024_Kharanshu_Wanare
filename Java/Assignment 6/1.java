package methods;

public class Calculator {	
	public void addition(int no1,int no2) {
		int result=no1+no2;
		System.out.println("addition is"+result);
	}
	public void subtraction(int no1,int no2) {
		int result=no1-no2;
		System.out.println("addition is"+result);
	}
	
	public void multiplication(int no1,int no2) {
		int result=no1*no2;
		System.out.println("addition is"+result);
	}
	public void division(int no1,int no2) {
		int result=no1/no2;
		System.out.println("addition is"+result);
	}
}

import java.util.Scanner;

import javax.xml.crypto.Data;

import methods.*;

public class Main {
	public static void main(String[] args)
	{
		Calculator calculator=new Calculator();
		int a,b,choice;
		boolean n=true;
		Scanner scanner=new Scanner(System.in);
		while (n==true) {
			System.out.println("enter two no");
			a=scanner.nextInt();
			b=scanner.nextInt();
			System.out.println("enter choice 1.Addition 2.Substraction 3.Multiplication 4.Division 5.exit");
			choice=scanner.nextInt();
			switch (choice){
			case 1: {
				calculator.addition(a, b);
				break;
			}
			case 2:
			{
				calculator.subtraction(a, b);
				break;
			}
			case 3:
			{
				calculator.multiplication(a, b);
				break;
			}
			case 4 :
			{
				calculator.division(a, b);
				break;
			}
			case 5:
			{
				n=false;
				System.out.println("exit .....");
				break;
			}
			
		}
	}
}
}


