package methods;

public class Factorial {
	//Write a program to print the factorial of a number by defining a method named 'Factorial'.
	public void find(int no) {
		int sum=1;
		while (no>0) {
			sum=sum*no;
			no--;
		}
		System.out.println("factorial is "+sum);
	}
}
