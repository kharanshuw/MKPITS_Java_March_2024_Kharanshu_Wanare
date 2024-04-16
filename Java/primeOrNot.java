package practise;

import java.util.Scanner;

public class primeOrNot {

	public static void main(String[] args) {
		int count=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int number = sc.nextInt();

		for (int i = 2; i <number ;i++) {
			if (number%i==0) {
			count=count+1;	
			}
		}
		if (count==0) {
			System.out.println("no is prime");
		}
		else {
			System.out.println("no is not prime");
		}
	}

}
